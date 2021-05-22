package Controller;

import Model.Eveniment;
import Model.Alarma;
import Model.An;
import Model.Luna;
import Model.Recurenta;
import Model.Saptamana;
import Model.Zi;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Clasa Container manipuleaza cu evenimentele din baza de date
 * 
 * @author Elena
 */
public class Container {

    /**
     * Lista de evenimente
     */
    private static List<Eveniment> evenimente;
    private static Container instance;
    private static Connection connection;

    /**
     * Genereaza o instanta a obiectului Container
     *
     * @return instanta a obiectului Container
     */
    public static Container getInstance() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (Exception e) {
                System.err.println("Unable to connect to " + e.getMessage());
            }
            connection = null;
            try {
                // create a database connection
                connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\CalendarDB.s3db");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println("Connection error: " + e.getMessage());
            }
        }
        return instance;
    }

    /**
     * Citeste evenimentele din baza de date pentru o anumita zi 
     *
     * @param data data evenimentului
     * @return evenimente dint-o zi
     */
    public static Zi FurnizareZi(Date data) throws ParseException {
        evenimente = new ArrayList<Eveniment>();
        String SELECT_SQL = "select * from Events where date(StartDate)=date(?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_SQL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(1, dateFormat.format(data));
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startDate = formatter.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));
                Date endDate = formatter.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));

                Alarma alarma = getAlarmById(rs.getInt("AlarmId"));
                Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));

                Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
                if (inactive == true) {
                    continue;
                }
                Recurenta recurenta = getRecurrenceById(rs.getInt("RecurrenceId"));

                Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                        rs.getString("Color"), alarmActive, inactive);

                evenimente.add(evt);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
        
        List<Eveniment> evtRepet = AdaugareEvenimenteRepetate(data);
        if (!evtRepet.isEmpty()) {
            evenimente.addAll(evtRepet);
        }
        
        return new Zi(evenimente);
    }

    /**
     * Extrage informatia privind recurenta din baza de date
     * 
     * @param recurrenceId id recurenta
     * @return obiect Recurenta cautat in baza de date
     * @throws ParseException 
     */
    private static Recurenta getRecurrenceById(int recurrenceId) throws ParseException {
        Recurenta recurenta = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String SELECT_SQL3 = "select * from Recurrence where RecurrenceId=?";
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_SQL3)) {
            stmt.setInt(1, recurrenceId);
            ResultSet re = stmt.executeQuery();
            while (re != null && re.next()) {
                if (re.getInt("RepetMode") == 0) {
                    recurenta = new Recurenta();
                } else {
                    Date endDate = dateFormat.parse(re.getString("EndDate"));
                    recurenta = new Recurenta(re.getInt("RepetMode"), endDate);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Connection error: " + ex.getMessage());
        }
        return recurenta;
    }

    /**
     * Extrage informatia privind alarma din baza de date
     * 
     * @param alarmId id alarma
     * @return obiect Alarma cautat in baza de date
     */
    private static Alarma getAlarmById(int alarmId) {
        Alarma alarma = null;
        String SELECT_SQL2 = "select * from Alarms where AlarmId=?";
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_SQL2)) {
            stmt.setInt(1, alarmId);
            ResultSet al = stmt.executeQuery();
            while (al != null && al.next()) {
                alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
            }
        } catch (SQLException ex) {
            System.err.println("Connection error: " + ex.getMessage());
        }
        return alarma;
    }

    /**
     * Gaseste evenimentele din baza de date pentru o anumita luna
     *
     * @param data data evenimentelor cautate
     * @return evenimente dintr-o luna
     */
    public static Luna FurnizareLuna(Date data) throws ParseException {
        List<Zi> luna = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int current = calendar.get(calendar.DAY_OF_MONTH);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < maxDays; i++) {
            int n = (i - current + 1);
            Date datesOfWeek = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            List<Eveniment> evte = Agenda.SelectareEvente(datesOfWeek, "DAY").getEventList();
            luna.add(new Zi(evte, datesOfWeek));
        }
        return new Luna(luna);
    }

    /**
     * Gaseste evenimentele din baza de date pentru o anumita saptamana
     * 
     * @param data data evenimentelor cautate
     * @return evenimente dintr-o saptamana
     */
    public static Saptamana FurnizareSaptamana(Date data) throws ParseException {
        List<Zi> saptamana = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int current = calendar.get(calendar.DAY_OF_WEEK);
        for (int i = 0; i < 7; i++) {
            int n = (i - current + 1);
            Date datesOfWeek = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            List<Eveniment> evte = Agenda.SelectareEvente(datesOfWeek, "DAY").getEventList();
            saptamana.add(new Zi(evte));
        }
        return new Saptamana(saptamana);
    }

    /**
     * Gaseste evenimentele din baza de date pentru un anumit an
     *
     * @param data data evenimentelor cautate
     * @return evenimente dintr-un an
     */
    public static An FurnizareAn(Date data) {
        return null;
    }

    /**
     * Gaseste toate evenimentele din baza de date
     *
     * @return toate evenimentele din baza de date
     */
    public static Zi FurnizareToateEvent() throws ParseException {
        evenimente = new ArrayList<Eveniment>();
        String SELECT_SQL = "select * from Events";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_SQL);
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                // read the result set
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startDate = dateFormatter.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));
                Date endDate = dateFormatter.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));
                Alarma alarma = getAlarmById(rs.getInt("AlarmId"));
                Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
                Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
                if (inactive == true) {
                    continue;
                }

                Recurenta recurenta = getRecurrenceById(rs.getInt("RecurrenceId"));
                Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                        rs.getString("Color"), alarmActive, inactive);
                evenimente.add(evt);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
        return new Zi(evenimente);
    }

    /**
     * Adauga un eveniment in baza de date
     * 
     * @param titlu titlul evenimentului
     * @param descriere descrierea evenimentului
     * @param dataInceput data de incepere a evenimentului format yyyy-mm-dd
     * @param timpInceput ora de incepere a evenimentului format hh:mm:ss
     * @param dataSfarsit data de sfarsire a evenimentului format yyyy-mm-dd
     * @param timpSfarsit ora de sfarsire a evenimentului format hh:mm:ss
     * @param culoare culoare in hexa a evenimentului
     * @param alarmaPornita valoarea de adevar sau fals a starii alarmei
     * @param factorRecurenta factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     * @param intervalTimp intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     * @param esteRecurenta valoarea de adevar sau fals al starii de recurenta a evenimentului
     * @param modRecurenta modul de recurenta a evenimentului
     * @param dataFinala ultima data de declansare a evenimentului recurent
     */
    public static void AdaugareEveniment(String titlu, String descriere, String dataInceput, String timpInceput, String dataSfarsit, String timpSfarsit, String culoare,
            boolean alarmaPornita, int factorRecurenta, int intervalTimp, boolean esteRecurenta, int modRecurenta, String dataFinala) {
        String INSERT_SQL = "INSERT INTO Events(Title, StartDate, StartTime, EndDate, EndTime, Color, Description, AlarmId, RecurrenceId, AlarmActive, Inactive) "
                + "VALUES(?, Date(?), Time(?), Date(?), Time(?), ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Integer alarmId = 1;
        Integer recurrenceId = 1;
        if (alarmaPornita) {
            alarmId = AdaudareAlarma(factorRecurenta, intervalTimp);
        }
        if (esteRecurenta) {
            recurrenceId = AdaugareRecurenta(modRecurenta, dataFinala);
        }
        try {
            stmt = connection.prepareStatement(INSERT_SQL);
            stmt.setString(1, titlu);
            stmt.setString(2, dataInceput);
            stmt.setString(3, timpInceput);
            stmt.setString(4, dataSfarsit);
            stmt.setString(5, timpSfarsit);
            stmt.setString(6, culoare);
            stmt.setString(7, descriere);
            stmt.setInt(8, alarmId);
            stmt.setInt(9, recurrenceId);
            stmt.setBoolean(10, alarmaPornita);
            stmt.setBoolean(11, false);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    /**
     * Adauga un eveniment alarma in baza de date
     * 
     * @param factorRecurenta factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     * @param intervalTimp intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     * @return id-ul alarmei adaugate
     */
    private static Integer AdaudareAlarma(int factorRecurenta, int intervalTimp) {
        String INSERT_SQL = "INSERT INTO Alarms(Snooze, ReminderMinutes) VALUES(?, ?)";
        PreparedStatement stmt = null;
        Integer alarmId = null;
        try {
            stmt = connection.prepareStatement(INSERT_SQL);
            stmt.setInt(1, factorRecurenta);
            stmt.setInt(2, intervalTimp);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                alarmId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
        }
        return alarmId;
    }

    /**
     * Adauga un eveniment de recurenta in baza de date
     *
     * @param modRecurenta modul de recurenta a evenimentului
     * @param dataFinala ultima data de declansare a evenimentului recurent
     * @return id-ul evenimentului de recurenta adaugat
     */
    private static Integer AdaugareRecurenta(int modRecurenta, String dataFinala) {
        String INSERT_SQL = "INSERT INTO Recurrence(RepetMode, EndDate) VALUES(?, Date(?))";
        PreparedStatement stmt = null;
        Integer recurrenceId = null;
        try {
            stmt = connection.prepareStatement(INSERT_SQL);
            stmt.setInt(1, modRecurenta);
            stmt.setString(2, dataFinala);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                recurrenceId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
        }
        return recurrenceId;
    }

    /**
     * Incheie executia unui SQL query
     * 
     * @param statement obiectul executiei SQL query
     */
    private static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica un eveniment
     *
     * @param eveniment evenimentul care va fi modificat
     */
    public static void ModificareEvent(Eveniment eveniment) {
        PrelucrareEvent(eveniment, "edit");
    }

    /**
     * Anuleaza un eveniment
     *
     * @param eveniment evenimentul care va fi anulat
     */
    public static void AnulareEvent(Eveniment eveniment) {
        PrelucrareEvent(eveniment, "delete");
    }

    /**
     * Prelucrarea datelor unui eveniment in baza de date in dependenta de modul ales
     * 
     * @param eveniment evenimentul care va fi prelucrat
     * @param operation modul de prelucrare ales: 0=editarea evenimentul in baza de date; 1=anularea evenimentului in baza de date
     */
    private static void PrelucrareEvent(Eveniment eveniment, String operation) {
        String SELECT_SQL = "SELECT * FROM Events WHERE EventId=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_SQL);
            statement.setInt(1, eveniment.getEvenimentId());
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                if (operation.compareTo("edit") == 0) {
                    String UPDATE_SQL = "update Events set Title=?,Description=? where EventId=?";
                    try (PreparedStatement stmt = connection.prepareStatement(UPDATE_SQL)) {
                        stmt.setString(1, eveniment.getTitlu());
                        stmt.setString(2, eveniment.getDescriere());
                        stmt.setInt(3, eveniment.getEvenimentId());
                        stmt.executeUpdate();
                    } catch (SQLException ex2) {
                        System.err.println("Connection error, failed to update: " + ex2.getMessage());
                    }
                } else if (operation.compareTo("delete") == 0) {
                    String DELETE_SQL = "update Events set Inactive=? where EventId=?";
                    try (PreparedStatement stmt = connection.prepareStatement(DELETE_SQL)) {
                        stmt.setBoolean(1, true);
                        stmt.setInt(2, eveniment.getEvenimentId());
                        stmt.executeUpdate();
                    } catch (SQLException ex3) {
                        System.err.println("Connection error, failed to delete: " + ex3.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
    }

    /**
     * Actualizarea statutului alarmei in baza de date
     *
     * @param eveniment evenimentul carui alarma va vi oprita
     */
    public static void OprireAlarma(Eveniment eveniment) {
        String UPDATE_SQL = "update Events set AlarmActive=false where EventId=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_SQL);
            statement.setInt(1, eveniment.getEvenimentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
    }

    /**
     * Actualizarea intervalului alarmei in baza de date
     *
     * @param eveniment evenimentul a carui alarma va fi actualizata
     */
    public static void AmanareAlarma(Eveniment eveniment) {
        String SELECT_SQL = "select * from Events where EventId=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_SQL);
            statement.setInt(1, eveniment.getEvenimentId());
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                String SELECT_SQL2 = "select * from Alarms where AlarmId=?";
                try (PreparedStatement stmt = connection.prepareStatement(SELECT_SQL2)) {
                    stmt.setInt(1, rs.getInt("AlarmId"));
                    ResultSet al = stmt.executeQuery();
                    while (al != null && al.next()) {
                        String UPDATE_SQL = "update Alarms set ReminderMinutes=? where AlarmId=?";
                        try (PreparedStatement stmt2 = connection.prepareStatement(UPDATE_SQL)) {
                            int shift = al.getInt("ReminderMinutes") - al.getInt("Snooze");
                            stmt2.setInt(1, shift);
                            stmt2.setInt(2, al.getInt("AlarmId"));
                            stmt2.executeUpdate();
                        } catch (SQLException ex2) {
                            System.err.println("Connection error, failed to update: " + ex2.getMessage());
                        }
                    }
                } catch (SQLException ex) {
                    System.err.println("Connection error: " + ex.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
    }

    /**
     * Adaugarea evenimentelor recurente
     * 
     * @param data data de cautare a evenimentelor
     * @return lista de evenimente recurente
     * @throws ParseException 
     */
    private static List<Eveniment> AdaugareEvenimenteRepetate(Date data) throws ParseException {
        ArrayList<Eveniment> evte = new ArrayList<Eveniment>();
        String SELECT_SQL = "select * from Events where date(StartDate)<date(?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_SQL);            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(1, dateFormat.format(data));
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                Recurenta recurenta = null;
                String SELECT_SQL2 = "select * from Recurrence where RecurrenceId=?";
                try (PreparedStatement stmt = connection.prepareStatement(SELECT_SQL2)) {
                    stmt.setInt(1, rs.getInt("RecurrenceId"));
                    ResultSet re = stmt.executeQuery();
                    while (re != null && re.next()) {
                        Date endDate = dateFormat.parse(re.getString("EndDate"));
                        int mod = re.getInt("RepetMode");
                        if (mod == 1 && endDate.compareTo(dateFormat.parse(dateFormat.format(data))) >= 0) {
                            recurenta = new Recurenta(mod, endDate);
                        }
                        if(mod == 2){
                            int yearCompared = compareYears(data, dateFormat.parse(rs.getString("StartDate")));                            
                            int weekCompared = compareWeeks(data, endDate);                            
                            int dayOfWeekCompared = compareDayOfWeek(data, dateFormat.parse(rs.getString("StartDate")));
                            if(dayOfWeekCompared == 0 && yearCompared <= 0 && weekCompared <= 0){
                                recurenta = new Recurenta(mod, data);
                            }
                        }
                        if(mod == 3){
                            int monthCompared = compareMonths(data, endDate);                            
                            int yearCompared = compareYears(data, endDate);                            
                            int daysCompared = compareDays(data, dateFormat.parse(rs.getString("StartDate")));
                            if(monthCompared <= 0 && daysCompared == 0 && yearCompared <= 0){
                                recurenta = new Recurenta(mod, data);
                            }
                        }
                        if(mod == 4){
                            int yearCompared = compareYears(data, endDate);                              
                            int daysCompared = compareDays(data, dateFormat.parse(rs.getString("StartDate")));                            
                            int monthCompared = compareMonths(data, dateFormat.parse(rs.getString("StartDate")));  
                            if(monthCompared == 0 && daysCompared == 0 && yearCompared <= 0){
                                recurenta = new Recurenta(mod, data);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    System.err.println("Connection error: " + ex.getMessage());
                }
                
                if (recurenta == null) {
                    continue;
                }

                Alarma alarma = getAlarmById(rs.getInt("AlarmId"));
                
                Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
                Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
                if (inactive == true) {
                    continue;
                }
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startDate = formatter.parse(dateFormat.format(data) + " " + rs.getString("StartTime"));
                Date endDate = formatter.parse(dateFormat.format(data) + " " + rs.getString("EndTime"));
                Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                        rs.getString("Color"), alarmActive, inactive);
                evte.add(evt);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            close(statement);
        }
        return new ArrayList(evte);
    }
    
    /**
     * Compara ziua intre doua evenimente
     * 
     * @param currentDate data primului eveniment
     * @param lastDate data celui de-al doilea eveniment
     * @return 0=daca ziua e aceeasi; -1=daca ziua primului eveniment e mai mica; 1=daca ziua primului eveniment e mai mare
     */
    private static int compareDays(Date currentDate, Date lastDate){        
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int currentDay = cal.get(Calendar.DATE);
        cal.setTime(lastDate);
        int endDay = cal.get(Calendar.DATE);
        if(currentDay < endDay){
            return -1;
        }
        if(currentDay > endDay){
            return 1;
        }
        return 0;
    }
    
    /**
     * Compara ziua saptamanii intre doua evenimente
     * 
     * @param currentDate data primului eveniment
     * @param lastDate data celui de-al doilea eveniment
     * @return 0=daca ziua saptamanii e aceeasi; -1=daca ziua saptamanii primului eveniment e mai mica; 1=daca ziua saptamanii primului eveniment e mai mare
     */
    private static int compareDayOfWeek(Date currentDate, Date lastDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.setTime(lastDate);        
        int endDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(currentDayOfWeek < endDayOfWeek){
            return -1;
        }
        if (currentDayOfWeek > endDayOfWeek){
            return 1;
        }
        return 0;
    }
    
    /**
     * Compara saptamanile intre doua evenimente
     * 
     * @param currentDate data primului eveniment
     * @param lastDate data celui de-al doilea eveniment
     * @return 0=daca saptamana e aceeasi; -1=daca saptamana primului eveniment e mai mica; 1=daca saptamana primului eveniment e mai mare
     */
    private static int compareWeeks(Date currentDate, Date lastDate){        
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        cal.setTime(currentDate);
        int currentWeek = cal.get(Calendar.WEEK_OF_YEAR);
        cal.setTime(lastDate);        
        int endWeek = cal.get(Calendar.WEEK_OF_YEAR);
        if(currentWeek < endWeek){
            return -1;
        }
        if (currentWeek > endWeek){
            return 1;
        }
        return 0;
    }
    
    /**
     * Compara lunile intre doua evenimente
     * 
     * @param currentDate data primului eveniment
     * @param lastDate data celui de-al doilea eveniment
     * @return 0=daca luna e aceeasi; -1=daca luna primului eveniment e mai mica; 1=daca luna primului eveniment e mai mare
     */
    private static int compareMonths(Date currentDate, Date lastDate){        
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int currentMonth = cal.get(Calendar.MONTH);
        cal.setTime(lastDate);        
        int endMonth = cal.get(Calendar.MONTH);
        if(currentMonth < endMonth){
            return -1;
        }
        if (currentMonth > endMonth){
            return 1;
        }
        return 0;
    }
    
    /**
     * Compara anii intre doua evenimente
     * 
     * @param currentDate data primului eveniment
     * @param lastDate data celui de-al doilea eveniment
     * @return 0=daca anul e aceeasi; -1=daca anul primului eveniment e mai mic; 1=daca anul primului eveniment e mai mare
     */
    private static int compareYears(Date currentDate, Date lastDate){        
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(lastDate);     
        int endYear = cal.get(Calendar.YEAR);   
        if(currentYear < endYear){
            return -1;
        }
        if (currentYear > endYear){
            return 1;
        }
        return 0;
    }
    
    
}
