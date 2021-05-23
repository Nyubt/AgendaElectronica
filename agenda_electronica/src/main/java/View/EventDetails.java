package View;

import Controller.Agenda;
import Model.Eveniment;

/**
 * Clasa EventDetails afiseaza un UI cu detaliile evenimentului si permite prelucrarea acestora
 * 
 * @author Nadia, Elena
 */
public class EventDetails extends javax.swing.JFrame {

    /**
     * Obiect CalendarMain care creeaza obiectul EventDetails
     */
    CalendarMain parentFrame;
    /**
     * Evenimentul detaliile carora sunt afisate
     */
    Eveniment eveniment;

    /**
     * Constructor EventDetails
     */
    public EventDetails() {
        initComponents();
    }
    
    /**
     * Constructor EventDetails
     * 
     * @param parent obiect CalendarMain care creeaza obiectul EventDetails
     * @param info evenimentul detaliile carora sunt afisate
     */
    public EventDetails(CalendarMain parent, Eveniment info) {
        initComponents();
        this.parentFrame = parent;
        this.eveniment = info;
        if(eveniment.getAlarma().getIntervalTimp() != 0){
            jAlarmaActivaCheckbox.setState(true);
            jSnoozeTextField.setText(eveniment.getAlarma().getFactorRecurenta() + " min");
            jIntervalTimpTextField.setText(eveniment.getAlarma().getIntervalTimp() + " min");
        }
        if(eveniment.getRecurenta().getModRecurenta() != 0){
            jRecurentaCheckbox.setState(true);
        }
        jTitluTextField.setText(eveniment.getTitlu());
        jDescriereTextArea.setText(eveniment.getDescriere());
        jInceputTextField.setText(eveniment.getInceput().toString());
        jSfarsitTextField.setText(eveniment.getSfarsit().toString());
        jColorTextField.setText(getColorNameFromHex(eveniment.getCuloare()));
        jRecurentaTextField.setText(eveniment.getModRecurenta());
        parentFrame.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDescriereTextArea = new javax.swing.JTextArea();
        jTitluTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jInceputTextField = new javax.swing.JTextField();
        jSfarsitTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jColorTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jIntervalTimpTextField = new javax.swing.JTextField();
        jModificareButton = new javax.swing.JButton();
        jAnulareButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jRecurentaTextField = new javax.swing.JTextField();
        jRecurentaCheckbox = new java.awt.Checkbox();
        jAlarmaActivaCheckbox = new java.awt.Checkbox();
        jSnoozeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Titlu");

        jLabel2.setBackground(new java.awt.Color(255, 255, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Descriere");

        jDescriereTextArea.setColumns(20);
        jDescriereTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDescriereTextArea.setRows(5);
        jDescriereTextArea.setName("JTextAreaDescriere"); // NOI18N
        jScrollPane1.setViewportView(jDescriereTextArea);
        jDescriereTextArea.getAccessibleContext().setAccessibleName("jDescriereTextArea");

        jTitluTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTitluTextField.setText(" ");
        jTitluTextField.setMaximumSize(new java.awt.Dimension(20, 20));
        jTitluTextField.setName("JTextFiledTitle"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Inceput");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Sfarsit");
        jLabel4.setToolTipText("");

        jInceputTextField.setEditable(false);
        jInceputTextField.setName("jTextFiledIncepe"); // NOI18N

        jSfarsitTextField.setEditable(false);
        jSfarsitTextField.setText("  ");
        jSfarsitTextField.setName("jTextFiledFinal"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Culoare");

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText(" ");

        jColorTextField.setEditable(false);
        jColorTextField.setText(" ");
        jColorTextField.setName("jTextFiledIntervalTimp"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("DETALII EVENIMENT");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Amanare alarma");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Notificare alarma");

        jIntervalTimpTextField.setEditable(false);
        jIntervalTimpTextField.setText(" ");
        jIntervalTimpTextField.setName("jTextFiledIntervalTimp"); // NOI18N

        jModificareButton.setText("Modificare");
        jModificareButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModificareButtonMouseClicked(evt);
            }
        });

        jAnulareButton.setText("Anulare");
        jAnulareButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAnulareButtonMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Se repeta");

        jRecurentaTextField.setEditable(false);
        jRecurentaTextField.setText(" ");
        jRecurentaTextField.setName("jTextFiledIntervalTimp"); // NOI18N

        jRecurentaCheckbox.setEnabled(false);
        jRecurentaCheckbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRecurentaCheckbox.setForeground(new java.awt.Color(0, 102, 102));
        jRecurentaCheckbox.setLabel("Eveniment recurent");

        jAlarmaActivaCheckbox.setEnabled(false);
        jAlarmaActivaCheckbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jAlarmaActivaCheckbox.setForeground(new java.awt.Color(0, 102, 102));
        jAlarmaActivaCheckbox.setLabel("Alarma activa");

        jSnoozeTextField.setEditable(false);
        jSnoozeTextField.setText(" ");
        jSnoozeTextField.setName("jTextFiledIntervalTimp"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jModificareButton)
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(jAlarmaActivaCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jAnulareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRecurentaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jIntervalTimpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSnoozeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRecurentaCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSfarsitTextField)
                                        .addComponent(jTitluTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jInceputTextField)
                                        .addComponent(jColorTextField)))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTitluTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jInceputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jSfarsitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jColorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRecurentaCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAlarmaActivaCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRecurentaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jSnoozeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jIntervalTimpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModificareButton)
                    .addComponent(jAnulareButton))
                .addContainerGap())
        );

        jTitluTextField.getAccessibleContext().setAccessibleName("jTitluTextField");
        jInceputTextField.getAccessibleContext().setAccessibleName("jInceputTextField");
        jInceputTextField.getAccessibleContext().setAccessibleDescription("");
        jSfarsitTextField.getAccessibleContext().setAccessibleName("jSfarsitTextField");
        jColorTextField.getAccessibleContext().setAccessibleName("jColorTextField");
        jIntervalTimpTextField.getAccessibleContext().setAccessibleName("jIntervalTimpTextField");
        jModificareButton.getAccessibleContext().setAccessibleName("jModificareButton");
        jAnulareButton.getAccessibleContext().setAccessibleName("jAnulareButton");
        jRecurentaTextField.getAccessibleContext().setAccessibleName("jRecurentaTextField");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
     * Apeleaza metoda de modificare a evenimentului si inchide fereastra
     * Permite modificarea titlului si descrierii evenimentului
     * 
     * @param evt
     */
    private void jModificareButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModificareButtonMouseClicked
        eveniment.setTitlu(jTitluTextField.getText());
        eveniment.setDescriere(jDescriereTextArea.getText());
        Agenda.ModificareEvent(eveniment);
        parentFrame.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jModificareButtonMouseClicked

    /**
     * Apeleaza metoda de anulare a evenimentului si inchide fereastra
     * 
     * @param evt 
     */
    private void jAnulareButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAnulareButtonMouseClicked
        Agenda.AnulareEvent(eveniment);
        parentFrame.setVisible(true);
        parentFrame.revalidate();
        super.dispose();
    }//GEN-LAST:event_jAnulareButtonMouseClicked

    /**
     * Transforma valoare hex in nume a culorii
     * 
     * @param hexColor valoarea hex a culorii
     * @return numele culorii
     */
    public static String getColorNameFromHex(String hexColor) {
        if (hexColor.compareTo("#A8DADC") == 0) {
            return "Aqua Island";
        }
        if (hexColor.compareTo("#457B9D") == 0) {
            return "Wedgewood";
        }
        if (hexColor.compareTo("#D0F0C0") == 0) {
            return "Tea Green";
        }

        return "No Color";
    }

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
            java.util.logging.Logger.getLogger(EventDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox jAlarmaActivaCheckbox;
    private javax.swing.JButton jAnulareButton;
    private javax.swing.JTextField jColorTextField;
    private javax.swing.JTextArea jDescriereTextArea;
    private javax.swing.JTextField jInceputTextField;
    private javax.swing.JTextField jIntervalTimpTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jModificareButton;
    private java.awt.Checkbox jRecurentaCheckbox;
    private javax.swing.JTextField jRecurentaTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSfarsitTextField;
    private javax.swing.JTextField jSnoozeTextField;
    private javax.swing.JTextField jTitluTextField;
    // End of variables declaration//GEN-END:variables
}
