/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Eveniment;
import Model.Alarma;
import Model.An;
import Model.Luna;
import Model.Saptamana;
import Model.Zi;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
          Statement statement2 = connection.createStatement();
          // set timeout to 30 sec.
          statement.setQueryTimeout(30);  
          ResultSet rs = statement.executeQuery("select * from Events");
          while(rs.next())
          {
            // read the result set
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date startDate=formatter1.parse(rs.getString("StartDate") + " " + rs.getString("StartTime"));  
            Date endDate=formatter1.parse(rs.getString("EndDate") + " " + rs.getString("EndTime"));  
            ResultSet al = statement2.executeQuery("select * from Alarms where AlarmId=" + rs.getString("AlarmId"));
            Alarma alarma = new Alarma(al.getInt("ReminderMinutes"), al.getInt("Snooze"));
            Eveniment evt = new Eveniment(rs.getInt("EventId"), rs.getString("Title"), rs.getString("Description"), endDate, startDate, 
                    alarma, rs.getString("Color"), (rs.getObject("AlarmActive") == null ? false : true), (rs.getObject("Inactive") == null ? false : true));
            evenimente.add(evt);
          }
        }
        catch(SQLException e)
        {
          System.err.println("onnection error: " + e.getMessage());
        }
        return new Zi(evenimente);
    }

    /**
     * Returneaza evenimentele dintr-o luna
     * @param data
     * @return
     */
    public static Luna FurnizareLuna(Date data) {
        //
        return null;
    }

    /**
     * Returneaza evenimentele dintr-o saptamana
     * @param data
     * @return
     */
    public static Saptamana FurnizareSaptamana(Date data) {
        return null;
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
    public List <Eveniment> FurnizareToateEvent() {
        return null;
    }

    /**
     * Modifica un eveniment
     * @param eveniment 
     */
    public void ModificareEvent(Eveniment eveniment) {

    }

    /**
     * Anuleaza un eveniment
     * @param eveniment 
     */
    public void AnulareEvent(Eveniment eveniment) {

    }

    /**
     * Returneaza lista de alarme
     * @param alarma
     * @return 
     */
    public Alarma FurnizareAlarme(Alarma alarma) {
        return null;
    }
    
    /**
     * Actualizarea statutului alarmei in baza de date
     * @param eveniment 
     */
    public void OprireAlarma(Eveniment eveniment){
        //update db, set inactive to true
    }
    
    /**
     * Actualizarea intervalului alarmei in baza de date
     * @param eveniment 
     */
    public void AmanareAlarma(Eveniment eveniment){
        //update interval in db
    }
}
