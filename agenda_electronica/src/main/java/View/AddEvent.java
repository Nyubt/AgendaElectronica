package View;

import Controller.Agenda;
import Model.ComboHtmlRenderer;
import Validators.DateTimeValidator;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * Clasa AddEvent afiseaza un UI care permite adaugarea unui eveniment
 * 
 * @author Nadia, Elena
 */
public class AddEvent extends javax.swing.JFrame {

    /**
     * Obiect CalendarMain care creeaza obiectul AddEvent
     */
    CalendarMain parentFrame;
    /**
     * Instanta a obiectului Calendar
     */
    Calendar cal = Calendar.getInstance();

    /**
     * Constructor AddEvent
     */
    public AddEvent() {
        initComponents();
    }

    /**
     * Constructor AddEvent
     * 
     * @param parent obiectul CalendarMain care creeaza obiectul AddEvent
     */
    public AddEvent(CalendarMain parent) {
        initComponents();
        jColorComboBox.setRenderer(new ComboHtmlRenderer());
        this.parentFrame = parent;
        parentFrame.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTitleTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDescriptionTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jColorComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        label7 = new java.awt.Label();
        jEndDayTextField = new javax.swing.JTextField();
        jEndHourTextField = new javax.swing.JTextField();
        label8 = new java.awt.Label();
        jEndMinTextField = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        label1 = new java.awt.Label();
        jEndMonthTextField = new javax.swing.JTextField();
        jEndYearTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        label9 = new java.awt.Label();
        jUntilDayTextField = new javax.swing.JTextField();
        label12 = new java.awt.Label();
        label13 = new java.awt.Label();
        jUntilMonthTextField = new javax.swing.JTextField();
        jUntilYearTextField = new javax.swing.JTextField();
        jRecurCheckBox = new javax.swing.JCheckBox();
        jSnoozeComboBox = new javax.swing.JComboBox<>();
        jRemMinComboBox = new javax.swing.JComboBox<>();
        jAlarmCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jRecurComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        label14 = new java.awt.Label();
        label15 = new java.awt.Label();
        jStartDayTextField = new javax.swing.JTextField();
        jStartHourTextField = new javax.swing.JTextField();
        label16 = new java.awt.Label();
        jStartMinTextField = new javax.swing.JTextField();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        jStartMonthTextField = new javax.swing.JTextField();
        jStartYearTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jExitButton = new javax.swing.JButton();
        jAddButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("ADAUGARE EVENIMENT");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Titlu");

        jTitleTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTitleTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jTitleTextField.setName("JTextFiledTitle"); // NOI18N

        jDescriptionTextArea.setColumns(20);
        jDescriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDescriptionTextArea.setRows(5);
        jDescriptionTextArea.setName("JTextAreaDescriere"); // NOI18N
        jScrollPane1.setViewportView(jDescriptionTextArea);

        jLabel2.setBackground(new java.awt.Color(255, 255, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Descriere");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Inceput");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Until date");
        jLabel4.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Culoare");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Notificare alarma (min)");

        jColorComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jColorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "#A8DADC", "#457B9D", "#D0F0C0" }));

        label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(0, 102, 102));
        label5.setText("ZI");

        label7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label7.setForeground(new java.awt.Color(0, 102, 102));
        label7.setText("ORA");

        jEndDayTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEndDayTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jEndDayTextField.setName("JTextFiledTitle"); // NOI18N

        jEndHourTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEndHourTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jEndHourTextField.setName("JTextFiledTitle"); // NOI18N

        label8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label8.setForeground(new java.awt.Color(0, 102, 102));
        label8.setText("MINUTE");

        jEndMinTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEndMinTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jEndMinTextField.setName("JTextFiledTitle"); // NOI18N

        label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 102, 102));
        label4.setText("LUNA");

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 102, 102));
        label1.setText("AN");

        jEndMonthTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEndMonthTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jEndMonthTextField.setName("JTextFiledTitle"); // NOI18N

        jEndYearTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEndYearTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jEndYearTextField.setName("JTextFiledTitle"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEndHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEndDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEndMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEndYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jEndMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEndDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEndMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEndYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEndMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEndHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        label9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label9.setForeground(new java.awt.Color(0, 102, 102));
        label9.setText("ZI");

        jUntilDayTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jUntilDayTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jUntilDayTextField.setName("JTextFiledTitle"); // NOI18N

        label12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label12.setForeground(new java.awt.Color(0, 102, 102));
        label12.setText("LUNA");

        label13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label13.setForeground(new java.awt.Color(0, 102, 102));
        label13.setText("AN");

        jUntilMonthTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jUntilMonthTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jUntilMonthTextField.setName("JTextFiledTitle"); // NOI18N

        jUntilYearTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jUntilYearTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jUntilYearTextField.setName("JTextFiledTitle"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUntilDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUntilMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUntilYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUntilDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUntilYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUntilMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRecurCheckBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRecurCheckBox.setForeground(new java.awt.Color(0, 102, 102));
        jRecurCheckBox.setText("Eveniment recurent");

        jSnoozeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSnoozeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "30" }));

        jRemMinComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRemMinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "120", "60", "30" }));

        jAlarmCheckBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jAlarmCheckBox.setForeground(new java.awt.Color(0, 102, 102));
        jAlarmCheckBox.setText("Alarma pornita");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Amanare alarma (min)");

        jRecurComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zilnic", "Saptamanal", "Lunar", "Anual" }));

        label14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label14.setForeground(new java.awt.Color(0, 102, 102));
        label14.setText("ZI");

        label15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label15.setForeground(new java.awt.Color(0, 102, 102));
        label15.setText("ORA");

        jStartDayTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStartDayTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartDayTextField.setName("JTextFiledTitle"); // NOI18N

        jStartHourTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStartHourTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartHourTextField.setName("JTextFiledTitle"); // NOI18N

        label16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label16.setForeground(new java.awt.Color(0, 102, 102));
        label16.setText("MINUTE");

        jStartMinTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStartMinTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartMinTextField.setName("JTextFiledTitle"); // NOI18N

        label17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label17.setForeground(new java.awt.Color(0, 102, 102));
        label17.setText("LUNA");

        label18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label18.setForeground(new java.awt.Color(0, 102, 102));
        label18.setText("AN");

        jStartMonthTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStartMonthTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartMonthTextField.setName("JTextFiledTitle"); // NOI18N

        jStartYearTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStartYearTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartYearTextField.setName("JTextFiledTitle"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jStartMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStartDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStartMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStartYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStartMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStartHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Sfarsit");
        jLabel5.setToolTipText("");

        jExitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jExitButton.setForeground(new java.awt.Color(0, 102, 102));
        jExitButton.setText("Iesire");
        jExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitButtonMouseClicked(evt);
            }
        });

        jAddButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jAddButton.setForeground(new java.awt.Color(0, 102, 102));
        jAddButton.setText("Adaugare");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jAlarmCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11)
                        .addGap(16, 16, 16)
                        .addComponent(jSnoozeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jRemMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRecurCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRecurComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(jColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAlarmCheckBox)
                            .addComponent(jSnoozeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jRemMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRecurCheckBox)
                    .addComponent(jRecurComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddButton)
                    .addComponent(jExitButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /**
      * Apeleaza metoda de adaugare a unui eveniment in baza de date si inchide fereastra
      * 
      * @param evt 
      */
    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        String title = jTitleTextField.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduceti titlul");
            return;
        }
        
        String startDate = jStartYearTextField.getText().trim() + "-"
                + String.format("%2s", jStartMonthTextField.getText().trim()).replace(' ', '0') + "-"
                + String.format("%2s", jStartDayTextField.getText().trim()).replace(' ', '0');

        boolean startDateValid = DateTimeValidator.validateDateInput(jStartDayTextField.getText().trim(),
                jStartMonthTextField.getText().trim(), jStartYearTextField.getText().trim());
        
        if (!startDateValid) {
            JOptionPane.showMessageDialog(null, "Introduceti o data valida");
            return;
        }
        String startHour = jStartHourTextField.getText().trim();
        String startMinutes = jStartMinTextField.getText().trim();
        String startTime = String.format("%2s", startHour).replace(' ', '0') + ":" + String.format("%2s", startMinutes).replace(' ', '0') + ":00";
        boolean startTimeValid = DateTimeValidator.validateTimeInput(startTime);
        
        if (startHour.isEmpty() || startMinutes.isEmpty() || !startTimeValid) {
            JOptionPane.showMessageDialog(null, "Introduceti o ora valida");
            return;
        }
        Boolean recOn = jRecurCheckBox.isSelected();
        boolean untilDateValid = DateTimeValidator.validateDateInput(jUntilDayTextField.getText().trim(),
                jUntilMonthTextField.getText().trim(), jUntilYearTextField.getText().trim());
        
        if (recOn && !untilDateValid) {
            JOptionPane.showMessageDialog(null, "Introduceti o data valida pentru evenimentul de recurenta");
            return;
        }
        String endDate = jEndYearTextField.getText().trim() + "-"
                + String.format("%2s", jEndMonthTextField.getText().trim()).replace(' ', '0') + "-"
                + String.format("%2s", jEndDayTextField.getText().trim()).replace(' ', '0');

        boolean endDateValid = DateTimeValidator.validateDateInput(jEndDayTextField.getText().trim(),
                jEndMonthTextField.getText().trim(), jEndYearTextField.getText().trim());
        if (!endDateValid) {
            endDate = startDate;
        }

        String endHour = jEndHourTextField.getText().trim();
        String endMinutes = jEndMinTextField.getText().trim();
        String endTime = String.format("%2s", endHour).replace(' ', '0') + ":" + String.format("%2s", endMinutes).replace(' ', '0') + ":00";

        boolean endTimeValid = DateTimeValidator.validateTimeInput(endTime);
        if (endHour.isEmpty() || endMinutes.isEmpty() || !endTimeValid) {
            endTime = startTime;
        }

        String recDate = jUntilYearTextField.getText().trim() + "-"
                + String.format("%2s", jUntilMonthTextField.getText().trim()).replace(' ', '0') + "-"
                + String.format("%2s", jUntilDayTextField.getText().trim()).replace(' ', '0');

        int repetMode = 0;
        if (recOn) {
            repetMode = jRecurComboBox.getSelectedIndex() + 1;
        }

        String description = jDescriptionTextArea.getText().trim();
        String color = String.valueOf(jColorComboBox.getSelectedItem());

        Boolean alrmOn = jAlarmCheckBox.isSelected();
        int snooze = Integer.parseInt(jSnoozeComboBox.getSelectedItem().toString());
        int notif = Integer.parseInt(jRemMinComboBox.getSelectedItem().toString());

        try {
            Agenda.AdaugareEveniment(title, description, startDate, startTime, endDate, endTime, color, alrmOn, snooze, notif, recOn, repetMode, recDate);
            JOptionPane.showMessageDialog(null, "Eveniment adaugat!");
            jExitButtonMouseClicked(evt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eroare. Nu am putut salva evenimentul. Contactati customer support.");
        }
    }//GEN-LAST:event_jAddButtonMouseClicked

    /**
     * Inchide fereastra la apasarea butonului exit
     * 
     * @param evt 
     */
    private void jExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitButtonMouseClicked
        parentFrame.refillCalenderData();
        parentFrame.setVisible(true);
        parentFrame.revalidate();
        super.dispose();
    }//GEN-LAST:event_jExitButtonMouseClicked

    /**
     * Configureaza evenimentul formWindowClosing
     * 
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parentFrame.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Apeleaza functia main a ferestrei
     * 
     * @param args argumentele din linia de commanda
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddButton;
    private javax.swing.JCheckBox jAlarmCheckBox;
    private javax.swing.JComboBox<String> jColorComboBox;
    private javax.swing.JTextArea jDescriptionTextArea;
    private javax.swing.JTextField jEndDayTextField;
    private javax.swing.JTextField jEndHourTextField;
    private javax.swing.JTextField jEndMinTextField;
    private javax.swing.JTextField jEndMonthTextField;
    private javax.swing.JTextField jEndYearTextField;
    private javax.swing.JButton jExitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox jRecurCheckBox;
    private javax.swing.JComboBox<String> jRecurComboBox;
    private javax.swing.JComboBox<String> jRemMinComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jSnoozeComboBox;
    private javax.swing.JTextField jStartDayTextField;
    private javax.swing.JTextField jStartHourTextField;
    private javax.swing.JTextField jStartMinTextField;
    private javax.swing.JTextField jStartMonthTextField;
    private javax.swing.JTextField jStartYearTextField;
    private javax.swing.JTextField jTitleTextField;
    private javax.swing.JTextField jUntilDayTextField;
    private javax.swing.JTextField jUntilMonthTextField;
    private javax.swing.JTextField jUntilYearTextField;
    private java.awt.Label label1;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    // End of variables declaration//GEN-END:variables
}
