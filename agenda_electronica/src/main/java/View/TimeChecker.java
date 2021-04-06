/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Alarma;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Elena
 */
public class TimeChecker {
    public static int hour;
    public static int minute;
    public static int second; 
    public static int date;
    public static int month;
    public static int year;  
    public static int flag = 0;
    //private static AudioStream a;
    //private static InputStream in;
    private static AudioClip clip;
    private static File file;
    
    public static void checkAlarm(){
        Thread t = new Thread(){
            public void run(){
                while(true){
                    //citire lista evenimente pt ziua curenta
                    //obtine lista evenimente
                    //obtine lista alarme
                    //comparam alarme din lista si vedem daca e active
                    //adauga in lista daca exista alarme noi
                    Calendar c = new GregorianCalendar();
                    int currentHour = c.get(Calendar.HOUR);
                    int currentMinute = c.get(Calendar.MINUTE);
                    //int currentSecond = c.get(Calendar.SECOND);
                    int currentDay = c.get(Calendar.DAY_OF_MONTH);
                    int currentMonth = c.get(Calendar.MONTH) + 1;
                    int currentYear = c.get(Calendar.YEAR);
                    if (currentHour == hour && currentMinute == minute && currentDay == date && currentMonth == month && currentYear == year) {
                        try {
                            //in = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\AlarmClockShort.wav"));
                            //a = new AudioStream(in);
                            //AudioPlayer.player.start(a);         
                            file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\AlarmClockShort.wav");
                            clip = (AudioClip) file.toURI().toURL().getContent();
                            clip.play();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                        //cream copie a alarmei si adaugam in lista + factor de recurenta
                    }
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        };   
        t.start();
    }
    
    public static void StopAlarm(Alarma id){
        //sterge din lista de evenimente
        //AudioPlayer.player.stop(a);
        clip.stop();
    }
}
