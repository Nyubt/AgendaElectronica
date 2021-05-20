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


/**
 *
 * @author Elena, Nadia
 */

/**
 * Clasa Container manipuleaza cu evenimentele din baza de date
 *  
 */
public class Container {
    /**
     * Lista de evenimente
     */
    private static List<Eveniment> evenimente;
    private static Container instance;
    private static Connection connection;
    
    
    /**
     *  Functia get pentru a obtine instanta
     * @return instanta
     */
    public static Container getInstance(){
        if (connection == null){
            try{
                Class.forName("org.sqlite.JDBC");
            } catch(Exception e){
                System.err.println("Unable to connect to " + e.getMessage());
            }
            connection = null;
            try
            {
              // create a database connection
              connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\CalendarDB.s3db");
              connection.setAutoCommit(true);
            }
            catch(SQLException e)
            {
              // if the error message is "out of memory",
              // it probably means no database file is found
              System.err.println("Connection error: " + e.getMessage());
            }
        }
        return instance;
    }
    
    /**
     * Functia FurnizareZi: citeste evenimentele din baza de date pentru o anumita zi si le returneaza in formatul ("yyyy-MM-dd HH:mm:ss")
     * @param data
     * @return evenimentele dint-o zi
     */
    public static Zi FurnizareZi(Date data) throws ParseException {
        //citire din DB pt anumita zi
        evenimente = new ArrayList<Eveniment>();
        try
        {
          Statement statement = connection.createStatement();
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          ResultSet rs = statement.executeQuery("select * from Events where date(\"StartDate\")=date(\"" + dateFormat.format(data) + "\")");
          while(rs != null && rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date startDate=formatter1.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));  
            
            Alarma alarma = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet al = stmt.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
                
                while (al != null && al.next()) {
                    alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
             
            Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
            if (inactive == true){
                continue;
            }
            Recurenta recurenta = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet re = stmt.executeQuery("select * from Recurrence where RecurrenceId=" + rs.getString("RecurrenceId"));
                while (re != null && re.next()) {
                    if (re.getInt("RepetMode") == 0){
                        recurenta = new Recurenta();
                    } else {
                        Date endDate2 = dateFormat.parse(re.getString("EndDate"));
                        recurenta = new Recurenta(re.getInt("RepetMode"), endDate2);
                    }
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
         
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                    rs.getString("Color"), alarmActive, inactive);
          
            evenimente.add(evt);
          }
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
        List<Eveniment> evtRepet = AdaugareEvenimenteRepetateZi(data);
        if (!evtRepet.isEmpty()) {
            evenimente.addAll(evtRepet);
        }
        return new Zi(evenimente);
    }

    /**
     * Functia FurnizareLuna: citeste evenimentele din baza de date pentru o anumita luna si le returneaza
     * @param data
     * @return evenimentele dintr-o luna
     */
    public static Luna FurnizareLuna(Date data) throws ParseException {
        List <Zi> luna = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int current = calendar.get(calendar.DAY_OF_MONTH);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i = 0; i < maxDays; i++){
            int n = (i - current + 1);
            Date datesOfWeek = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            List <Eveniment> evte = Agenda.SelectareEvente(datesOfWeek, "DAY").getEventList();
            luna.add(new Zi(evte, datesOfWeek));
        }
        return new Luna(luna);
    }

    /**
     * Functia FurnizareSaptamana: citeste evenimentele din baza de date pentru o anumita saptamana si le returneaza
     * @param data
     * @return evenimentele dintr-o saptamana
     */
    public static Saptamana FurnizareSaptamana(Date data) throws ParseException {
        List <Zi> saptamana = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int current = calendar.get(calendar.DAY_OF_WEEK);
        for(int i = 0; i < 7; i++){
            int n = (i - current + 1);
            Date datesOfWeek = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            List <Eveniment> evte = Agenda.SelectareEvente(datesOfWeek, "DAY").getEventList();
            saptamana.add(new Zi(evte));
        }
        return new Saptamana(saptamana);
    }

    /**
     * Functia FurnizareAn: citeste evenimentele din baza de date pentru un anumit an si le returneaza
     * @param data
     * @return evenimentele dintr-un an
     */
    public static An FurnizareAn(Date data) {
        return null;
    }

    /**
     * Functia FurnizareToateEvent: citeste toate evenimentele din baza de date si le returneaza
     * @return toate evenimentele din baza de date
     */
    public static Zi FurnizareToateEvent() throws ParseException {
        evenimente = new ArrayList<Eveniment>();
        try
        {
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);
          ResultSet rs = statement.executeQuery("select * from Events");
          while(rs != null && rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date startDate=formatter1.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));  
            Alarma alarma = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet al = stmt.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
                while (al != null && al.next()) {
                    alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
            Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
            if (inactive == true){
                continue;
            }
            
            Recurenta recurenta = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet re = stmt.executeQuery("select * from Recurrence where RecurrenceId=" + rs.getString("RecurrenceId"));
                while (re != null && re.next()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate2 = dateFormat.parse(re.getString("EndDate"));
                    recurenta = new Recurenta(re.getInt("RepetMode"), endDate2);
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                    rs.getString("Color"), alarmActive, inactive);
            evenimente.add(evt);
          }
        }
        catch(SQLException e)
        {
            System.err.println("Connection error: " + e.getMessage());
        }
        return new Zi(evenimente);
    }
    
    /**
     * 
     * @param titlu
     * @param descriere
     * @param dataInceput
     * @param timpInceput
     * @param dataSfarsit
     * @param timpSfarsit
     * @param culoare
     * @param alarmaPornita
     * @param factorRecurenta
     * @param intervalTimp
     * @param esteRecurenta
     * @param modRecurenta
     * @param dataFinala 
     */
    public static void AdaugareEveniment(String titlu, String descriere, String dataInceput, String timpInceput, String dataSfarsit, String timpSfarsit, String culoare, 
            boolean alarmaPornita, int factorRecurenta, int intervalTimp, boolean esteRecurenta, int modRecurenta, String dataFinala){
        String INSERT_SQL = "INSERT INTO Events(Title, StartDate, StartTime, EndDate, EndTime, Color, Description, AlarmId, RecurrenceId, AlarmActive, Inactive) " + 
                "VALUES(?, Date(?), Time(?), Date(?), Time(?), ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Integer alarmId = 1;
        Integer recurrenceId = 1;
        if (alarmaPornita){
            alarmId = AdaudareAlarma(factorRecurenta, intervalTimp);
        }
        if (esteRecurenta){
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
     * 
     * @param factorRecurenta
     * @param intervalTimp
     * @return 
     */
    private static Integer AdaudareAlarma(int factorRecurenta, int intervalTimp){
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
     * 
     * @param modRecurenta
     * @param dataFinala
     * @return 
     */
    private static Integer AdaugareRecurenta(int modRecurenta, String dataFinala){
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
     * @param eveniment 
     */
    public static void ModificareEvent(Eveniment eveniment) {
        PrelucrareEvent(eveniment, "edit");
    }

    /**
     * Anuleaza un eveniment
     * @param eveniment 
     */
    public static void AnulareEvent(Eveniment eveniment) {
        PrelucrareEvent(eveniment, "delete");        
    }
    
     /**
     * Modificarea datelor unui eveniment: titlul, descrierea, ID-ului si stergerea sau stergerea unui eveniment
     * Daca nu s-a putut conecta cu baza de date, returneaza un mesaj specific
     * @param eveniment 
     */
    private static void PrelucrareEvent(Eveniment eveniment, String operation){
        try
        {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from Events where EventId=" + eveniment.getEvenimentId());
            while(rs != null && rs.next())
            {
                if(operation.compareTo("edit") == 0){
                    String newTitle = eveniment.getTitlu();
                    String newDescription = eveniment.getDescriere();
                    try (Statement stmt2 = connection.createStatement()){
                          stmt2.executeUpdate("update Events set Title=\"" + newTitle + "\",Description=\"" + newDescription + "\" where EventId=" + eveniment.getEvenimentId());
                    } catch(SQLException ex2){
                        System.err.println("Connection error, failed to update: " + ex2.getMessage());
                    }
                } else if(operation.compareTo("delete") == 0){
                    try (Statement stmt2 = connection.createStatement()){
                          stmt2.executeUpdate("update Events set Inactive=" + true + " where EventId=" + eveniment.getEvenimentId());
                    } catch(SQLException ex3){
                        System.err.println("Connection error, failed to update: " + ex3.getMessage());
                    }
                }
            }          
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
    }
    
    /**
     * Actualizarea statutului alarmei in baza de date
     * @param eveniment 
     */
    public static void OprireAlarma(Eveniment eveniment){
        //update db, set inactive to true 
        try
        {
          Statement statement = connection.createStatement();
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          statement.executeUpdate("update Events set AlarmActive=false where EventId=" + eveniment.getEvenimentId());          
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
    }
    
    /**
     * Functia de actualizare a intervalului alarmei in baza de date
     * @param eveniment 
     */
    public static void AmanareAlarma(Eveniment eveniment){
        //update interval in db ;
        try
        {
          Statement statement = connection.createStatement();
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          ResultSet rs = statement.executeQuery("select * from Events where EventId=" + eveniment.getEvenimentId());
          while(rs != null && rs.next())
          {
            try (Statement stmt1 = connection.createStatement()){
                ResultSet al = stmt1.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
                while (al != null && al.next()) {
                    int shift = al.getInt("ReminderMinutes") - al.getInt("Snooze");
                    try (Statement stmt2 = connection.createStatement()){
                        stmt2.executeUpdate("update Alarms set ReminderMinutes=" + shift + " where AlarmId=" + rs.getString("AlarmId"));
                    } catch(SQLException ex2){
                        System.err.println("Connection error: " + ex2.getMessage());
                    }
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
          }
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
    }
    
    
    /**
     * Functia de adaugare a unui eveniment
     * Adaugam id, titlul, descrierea, data de inceput, data de sfarsit, recurenta, reminderMinutes, culoarea unui eveniment din combo box si daca alarma e activa sau nu, 
     * Daca nu s-a putut conecta cu baza de date, returneaza un mesaj specific
     * @param eveniment 
     */
    private static List<Eveniment> AdaugareEvenimenteRepetateZi(Date data) throws ParseException{
        ArrayList<Eveniment> evte = new ArrayList<Eveniment>();
        try
        {
          Statement statement = connection.createStatement(); 
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          ResultSet rs = statement.executeQuery("select * from Events where date(\"StartDate\") < date(\"" + dateFormat.format(data) + "\")"); 
          while(rs != null && rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Recurenta recurenta = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet re = stmt.executeQuery("select * from Recurrence where RecurrenceId=" + rs.getString("RecurrenceId"));
                while (re != null && re.next()) {
                    Date endDate2 = dateFormat.parse(re.getString("EndDate"));
                    int mod = re.getInt("RepetMode");
                    if (mod == 1 && endDate2.compareTo(dateFormat.parse(dateFormat.format(data))) >= 0){ 
                        recurenta = new Recurenta(mod, endDate2);
                    }
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            if (recurenta == null){
                continue;
            }
            
            Alarma alarma = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet al = stmt.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
                while (al != null && al.next()) {
                    alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
            Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
            if (inactive == true){
                continue;
            }
            Date startDate=formatter1.parse(dateFormat.format(data) + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(dateFormat.format(data) + " " + rs.getString("EndTime"));  
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                    rs.getString("Color"), alarmActive, inactive); 
            evte.add(evt);
          }
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
        return new ArrayList(evte);
    }
}
