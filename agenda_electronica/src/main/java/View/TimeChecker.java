/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Eveniment;
import Controller.*;
import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import sun.audio.AudioPlayer;AudioClip
//import sun.audio.AudioStream;
import java.applet.AudioClip;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
    
    /**
     * Verifica daca exista alarme active si le ruleaza
     */
    public static void checkAlarm(){
        map = new TreeMap<>();
        Thread t = new Thread(){
            public void run(){
                while(true){
                    ExtractAlarmEvents();
                    for (Map.Entry<Date, Eveniment> entry : map.entrySet()) {
                        Eveniment event = entry.getValue();
                        Date now = new Date();     
                        Date eventDate = event.getInceput();
                        if (eventDate.compareTo(now) <= 0) {
                            try {
                                file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\AlarmClockShort.wav");
                                clip = (AudioClip) file.toURI().toURL().getContent();
                                clip.play();
                            } catch (Exception e) {
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
    private static void ExtractAlarmEvents(){
        List <Eveniment> evenimente = (List<Eveniment>) Agenda.SelectareEvente(new Date(), "DAY");        
        int i = 0;
        final long ONE_MINUTE_IN_MILLIS = 60000;
        while (i < evenimente.size()) {
            Eveniment event = evenimente.get(i);
            Date eventDate = new Date(event.getInceput().getTime() + (event.getAlarma().getIntervalTimp() * ONE_MINUTE_IN_MILLIS));
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
