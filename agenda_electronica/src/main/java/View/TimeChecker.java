package View;

import Model.Eveniment;
import Controller.*;

import java.io.File;
import java.applet.AudioClip;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clasa TimeChecker manipuleaza cu alarmele existente
 *
 * @author Elena
 */
public class TimeChecker {

    /**
     * Obiectul AudioClip
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
     * Valoarea unui minut in milisecunde
     */
    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

    /**
     * Verifica daca exista alarme active si le ruleaza
     *
     * @param jAlarmList lista de alarme
     * @param jAlarmTextField perioada pana la prima alarma
     */
    public static void checkAlarm(JList jAlarmList, JTextField jAlarmTextField) {
        map = new TreeMap<>();
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        ExtractAlarmEvents();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeChecker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DefaultListModel model = new DefaultListModel();
                    String firstAlarm = "";
                    for (Map.Entry<Date, Eveniment> entry : map.entrySet()) {
                        Eveniment event = entry.getValue();
                        Date now = new Date();
                        Date eventDate = entry.getKey();

                        long duration = eventDate.getTime() - now.getTime();
                        if (firstAlarm.isEmpty() || Integer.parseInt(firstAlarm) > duration) {
                            firstAlarm = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(duration));
                        }
                        model.addElement(event.getInceput());

                        if (eventDate.compareTo(now) <= 0) {
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
                    jAlarmList.setModel(model);
                    jAlarmTextField.setText(String.valueOf(firstAlarm));

                }
            }
        };
        t.start();
    }

    /**
     * Amana perioada alarmei cu valoarea factorului de recurenta
     *
     * @param eveniment evenimentul care va fi actualizat
     */
    private static void UpdateAlarmTime(Eveniment eveniment) {
        for (Map.Entry<Date, Eveniment> entry : map.entrySet()) {
            Date key = entry.getKey();
            Eveniment value = entry.getValue();
            if (value.equals(eveniment)) {
                map.remove(key);
                Agenda.AmanareAlarma(eveniment);
            }
        }
    }

    /**
     * Extrage lista de evenimente cu alarme pentru ziua curenta si o salveaza in map
     * 
     * @throws ParseException 
     */
    private static void ExtractAlarmEvents() throws ParseException {
        List<Eveniment> evenimente = Agenda.SelectareEvente(new Date(), "DAY").getEventList();

        int i = 0;
        while (i < evenimente.size()) {
            Eveniment event = evenimente.get(i);
            Date eventDate = new Date(event.getInceput().getTime() - (event.getAlarma().getIntervalTimp() * ONE_MINUTE_IN_MILLIS));

            if (!map.containsValue(event) && event.isAlarmaPornita() == true && event.getInactiveState() == false && eventDate.compareTo(new Date()) >= 0) {
                map.put(eventDate, evenimente.get(i));
            }
            if ((map.containsKey(eventDate) || map.containsValue(event)) && (event.getInactiveState() == true || event.isAlarmaPornita() == false)) {
                map.remove(eventDate);
            }
            i++;
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Apeleaza metoda de oprire a alarmei
     */
    public static void StopAlarm() {
        Map.Entry<Date, Eveniment> entry = map.entrySet().iterator().next();
        Eveniment eveniment = entry.getValue();
        Agenda.OprireAlarma(eveniment);
    }
}
