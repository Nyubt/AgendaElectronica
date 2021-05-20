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
     * Returneaza evenimentele dintr-o zi
     * @param data
     * @return
     */
    public static Zi FurnizareZi(Date data) throws ParseException {
        //citire din DB pt anumita zi
        evenimente = new ArrayList<Eveniment>();
        try
        {
          Statement statement = connection.createStatement();
          //System.out.println("connection 1");
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          ResultSet rs = statement.executeQuery("select * from Events where date(\"StartDate\")=date(\"" + dateFormat.format(data) + "\")");
          //System.out.println("data "+data);
          while(rs != null && rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date startDate=formatter1.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));  
            //System.out.println("event start date "+startDate);
            //System.out.println("event end date "+endDate);
            Alarma alarma = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet al = stmt.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
                //System.out.println("Alarma " + al.getInt("ReminderMinutes"));
                //System.out.println("Alarma " + al.getInt("Snooze"));
                while (al != null && al.next()) {
                    alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            Boolean alarmActive = (rs.getObject("AlarmActive") != null && rs.getString("AlarmActive").contentEquals("1"));
            //System.out.println("Alarma " + alarmActive);
            //System.out.println("Inactive " + !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0")));
            Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
            if (inactive == true){
                continue;
            }
            Recurenta recurenta = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet re = stmt.executeQuery("select * from Recurrence where RecurrenceId=" + rs.getString("RecurrenceId"));
                while (re != null && re.next()) {
                    Date endDate2=dateFormat.parse(re.getString("EndDate"));
                    recurenta = new Recurenta(re.getInt("RepetMode"), endDate2);
                }
            } catch(SQLException ex){
                System.err.println("Connection 2 error: " + ex.getMessage());
            }
            //System.out.println("Inactive " + inactive);
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                    rs.getString("Color"), alarmActive, inactive);
            //System.out.println(evt.getInceput());
            evenimente.add(evt);
          }
        }
        catch(SQLException e)
        {
          System.err.println("Connection error: " + e.getMessage());
        }
        List<Eveniment> evtRepet = AdaugareEvenimenteRepetateZi(data);
        //System.out.println(evtRepet);
        if (!evtRepet.isEmpty()) {
            evenimente.addAll(evtRepet);
        }
        return new Zi(evenimente);
    }

    /**
     * Returneaza evenimentele dintr-o luna
     * @param data
     * @return
     */
    public static Luna FurnizareLuna(Date data) throws ParseException {
        List <Zi> luna = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int current = calendar.get(calendar.DAY_OF_MONTH);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //System.out.println(maxDays);
        for(int i = 0; i < maxDays; i++){
            int n = (i - current + 1);
            Date datesOfWeek = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            List <Eveniment> evte = Agenda.SelectareEvente(datesOfWeek, "DAY").getEventList();
            luna.add(new Zi(evte, datesOfWeek));
        }
        
        return new Luna(luna);
    }

    /**
     * Returneaza evenimentele dintr-o saptamana
     * @param data
     * @return
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
     * Returneaza evenimentele dintr-un an
     * @param data
     * @return
     */
    public static An FurnizareAn(Date data) {
        return null;
    }

    /**
     * Returneaza toate evenimentele din baza de date
     * @return
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
                    Date endDate2=dateFormat.parse(re.getString("EndDate"));
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
    
    public static void AdaugareEveniment(){
        
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
        //System.out.println(eveniment.getEvenimentId());
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
     * Actualizarea intervalului alarmei in baza de date
     * @param eveniment 
     */
    public static void AmanareAlarma(Eveniment eveniment){
        //update interval in db
        //System.out.println(eveniment.getEvenimentId());
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
     * Adaugarea unui eveniment
     * @param eveniment 
     */

    private static List<Eveniment> AdaugareEvenimenteRepetateZi(Date data) throws ParseException{
        ArrayList<Eveniment> evte = new ArrayList<Eveniment>();
        try
        {
          Statement statement = connection.createStatement();
          //System.out.println("connection 1");
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          ResultSet rs = statement.executeQuery("select * from Events where date(\"StartDate\") < date(\"" + dateFormat.format(data) + "\")");
          //System.out.println("data "+data);
          while(rs != null && rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            //System.out.println("event start date "+startDate);
            //System.out.println("event end date "+endDate);
            Recurenta recurenta = null;
            try (Statement stmt = connection.createStatement()){
                ResultSet re = stmt.executeQuery("select * from Recurrence where RecurrenceId=" + rs.getString("RecurrenceId"));
                while (re != null && re.next()) {
                    Date endDate2 = dateFormat.parse(re.getString("EndDate"));
                    int mod = re.getInt("RepetMode");
                    if (mod == 1 && endDate2.compareTo(dateFormat.parse(dateFormat.format(data))) >= 0){
                        //System.out.println(endDate2);
                        //System.out.println(dateFormat.parse(dateFormat.format(data)));
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
            //System.out.println("Alarma " + alarmActive);
            //System.out.println("Inactive " + !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0")));
            Boolean inactive = !(rs.getObject("Inactive") == null || rs.getString("Inactive").contentEquals("0"));
            if (inactive == true){
                continue;
            }
            Date startDate=formatter1.parse(dateFormat.format(data) + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(dateFormat.format(data) + " " + rs.getString("EndTime"));  
            //System.out.println("Inactive " + inactive);
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), startDate, endDate, alarma, recurenta,
                    rs.getString("Color"), alarmActive, inactive);
            //System.out.println(evt.getInceput());
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
