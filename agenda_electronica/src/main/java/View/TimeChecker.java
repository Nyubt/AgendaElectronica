/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
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
    private static AudioStream a;
    private static InputStream in;
    
    public static void checkAlarm(){
        Thread t = new Thread(){
            public void run(){
                int w=0;
                while(true){
                    Calendar c = new GregorianCalendar();
                    int currentHour = c.get(Calendar.HOUR);
                    int currentMinute = c.get(Calendar.MINUTE);
                    //int currentSecond = c.get(Calendar.SECOND);
                    int currentDay = c.get(Calendar.DAY_OF_MONTH);
                    int currentMonth = c.get(Calendar.MONTH) + 1;
                    int currentYear = c.get(Calendar.YEAR);
                    if (currentHour == hour && currentMinute == minute && currentDay == date && currentMonth == month && currentYear == year && flag == 1) {
                        try {
                            in = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\AlarmClockShort.wav"));
                            a = new AudioStream(in);
                            AudioPlayer.player.start(a);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                    if(flag == 0 && AudioPlayer.player.isAlive()){
                        AudioPlayer.player.stop(a);
                        return;
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
    
    public static void ResetAlarm(){
        
    }
}
