/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Eveniment;
import Controller.*;
import Model.Alarma;
import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import sun.audio.AudioPlayer;AudioClip
//import sun.audio.AudioStream;
import java.applet.AudioClip;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clasa TimeChecker manipuleaza cu alarmele existente
 * @author Elena
 */
public class TimeChecker {
    /**
     * Clip audio
     */
    private static AudioClip clip;
    /**
     * Fisierul audio
     */
    private static File file;
    /**
     * Map cu lista de evenimente cu alarme ordonata
     */
    private static Map<Date, Eveniment> map;
    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
    
    
    /**
     * Verifica daca exista alarme active si le ruleaza
     */
    public static void checkAlarm(){
        map = new TreeMap<>();
        //for testing, remove
        /*Calendar date = Calendar.getInstance();
        long tl = date.getTimeInMillis();
        Date afterAddingMins=new Date(tl + (30 * ONE_MINUTE_IN_MILLIS));
        Alarma al = new Alarma(30, 5);
        Eveniment event = new Eveniment(1, "aaa", "di dijsd  disjd", afterAddingMins, afterAddingMins, al, "red", true, false);
        List<Eveniment> evenimente = new ArrayList<Eveniment>();
        evenimente.add(event);
        Date eventDate = new Date(event.getInceput().getTime() - (event.getAlarma().getIntervalTimp() * ONE_MINUTE_IN_MILLIS));
        map.put(eventDate, evenimente.get(0));*/
        Thread t = new Thread(){
            public void run(){
                while(true){
                    try {
                        ExtractAlarmEvents();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeChecker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (Map.Entry<Date, Eveniment> entry : map.entrySet()) {    
                        //System.out.println("xx");
                        Eveniment event = entry.getValue();
                        Date now = new Date();     
                        //System.out.print(now + " ");
                        Date eventDate = entry.getKey();
                        //System.out.println(eventDate);
                        if (eventDate.compareTo(now) <= 0) { 
                            //System.out.println("yes!");
                            try {
                                file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\AlarmClockShort.wav");
                                clip = (AudioClip) file.toURI().toURL().getContent();
                                clip.play();
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e);
                            }                            
                            UpdateAlarmTime(event);
                        }
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }
            }
        };   
        t.start();
    }
    
    /**
     * Amanam perioada alarmei cu valoarea factorului de recurenta
     * @param eveniment 
     */
    private static void UpdateAlarmTime(Eveniment eveniment){
        for (Map.Entry<Date,Eveniment> entry : map.entrySet()) {
            Date key = entry.getKey();
            Eveniment value = entry.getValue();
            if(value.equals(eveniment)){
                map.remove(key);
                Agenda.AmanareAlarma(eveniment);
                //ExtractAlarmEvents();
            }
        }
    }
    
    /**
     * Extragem lista de evenimente cu alarme pentru ziua curenta si o adaugam in map
     */
    private static void ExtractAlarmEvents() throws ParseException{       
        List <Eveniment> evenimente = Agenda.SelectareEvente(new Date(), "DAY").getEventList();   
        int i = 0;
        while (i < evenimente.size()) { 
            Eveniment event = evenimente.get(i);
            Date eventDate = new Date(event.getInceput().getTime() - (event.getAlarma().getIntervalTimp() * ONE_MINUTE_IN_MILLIS));
            if(!map.containsValue(event) && event.isAlarmaPornita() == true && event.getInactiveState() == false && eventDate.compareTo(new Date()) >= 0) {
                map.put(eventDate, evenimente.get(i));
            }
            if(map.containsValue(event) && event.getInactiveState() == true){
                map.remove(eventDate);
            }
            i++;
        }
    }
    
    /**
     * Oprim alarma si o stergem din baza de date
     * @param eveniment 
     */
    public static void StopAlarm(Eveniment eveniment){
        map.entrySet().forEach(entry -> {
            Date key = entry.getKey();
            Eveniment value = entry.getValue();
            if (value.equals(eveniment)) {
                map.remove(key);
            }
        });
        Agenda.OprireAlarma(eveniment);
        clip.stop();
    }
}
