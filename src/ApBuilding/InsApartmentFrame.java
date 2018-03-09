package ApBuilding;

import com.bulenkov.darcula.DarculaLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class InsApartmentFrame extends javax.swing.JFrame {
    
    Connection conn = null;

    public InsApartmentFrame() {
        initComponents();
        setResizable(false);
        setTitle("Εισαγωγή Διαμερίσματος");
    }

    MainFrame mf1;

    public InsApartmentFrame(MainFrame mf1) {
        this.mf1 = mf1;
        initComponents();
        setResizable(false);
        setTitle("Εισαγωγή Διαμερίσματος");
    }

    public String getYear() {
        String year = "";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + mf1.getBid());

            if (rs.next()) {
                year = rs.getString(11);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return year;
    }

    public String getMonth() {
        String month = "";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + mf1.getBid());

            if (rs.next()) {
                month = rs.getString(10);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return month;
    }

    public int getFloors() {
        int floors = 7;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + mf1.getBid());

            if (rs.next()) {
                floors = rs.getInt(7);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return floors;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Διαχείριση Κοινοχρήστων Πολυκατοικίας");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Εισαγωγή Διαμερίσματος");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setText("Τύπος:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setText("Όροφος:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel5.setText("Τετραγωνικά Μέτρα:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Όνομα, Επώνυμο Ιδιοκτητη:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setText("Τηλέφωνο Ιδιοκτήτη:");

        jComboBox1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Διαμέρισμα", "Κατάστημα" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        int given_floors = getFloors();

        for(int i = 0; i < given_floors; i++)
        {
            String s1 = "";

            if(i == 0)
            {
                s1 = "Ισόγειο";
            }
            else
            {
                s1 = i +"ος";
            }

            jComboBox2.addItem(s1);
        }
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton1.setText("Εισαγωγή");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel8.setText("Ημερομηνία:");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String d1 = dateFormat.format(date);

        String cur_year = d1.substring(0, 4);

        String given_year = getYear();

        for(int i = Integer.parseInt(given_year); i <= Integer.parseInt(cur_year); i++)
        {
            String s1 = String.valueOf(i);
            jComboBox3.addItem(s1);
        }
        jComboBox3.setSelectedItem(cur_year);
        jComboBox3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        String cur_month = d1.substring(5, 7);

        String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
            "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

        for (int i = 0; i < months.length; i++) {
            String month = months[i];
            jComboBox4.addItem(month);

            //βαζουμε i+1 αντι για i, γιατι: π.χ. ο Ιανουαριος θα εχει i = 0 και θα πρεπει να ελενξουμε αν ισουνται με "01"
            if (i + 1 == Integer.parseInt(cur_month)) {
                break;
            }
        }

        jComboBox4.setSelectedItem(cur_month);
        jComboBox4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Πολυκατοικία " +mf1.getBid());

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setText("Όνομα Διαμερίσματος:");

        jTextField5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(226, 226, 226)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(48, 48, 48)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel9))
                                    .addGap(169, 169, 169)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(179, 179, 179)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))))
                        .addGap(42, 42, 42))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(70, 70, 70)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Apartment ap1 = new Apartment(mf1.getBid());

            ap1.setAtype((String) jComboBox1.getSelectedItem());

            String sfloor = (String) jComboBox2.getSelectedItem();
            int floor = 0;
            if (sfloor.equals("Ισόγειο")) {
                floor = 0;
            } else {
                sfloor = sfloor.substring(0, (sfloor.length() - 2));
                floor = Integer.parseInt(sfloor);
            }

            ap1.setAname(jTextField5.getText());

            ap1.setFloor(floor);
            ap1.setSq_meters(Integer.parseInt(jTextField1.getText()));
            ap1.setOwner_fname(jTextField2.getText());
            ap1.setOwner_lname(jTextField3.getText());
            ap1.setOwner_phone(jTextField4.getText());

            ap1.setAyear((String) jComboBox3.getSelectedItem());

            String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};
            String[] monthsToNum = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
            String sbmonth = "";
            String givenMonth = (String) jComboBox4.getSelectedItem();
            for (int i = 0; i < months.length; i++) {
                if (givenMonth.equals(months[i])) {
                    sbmonth = monthsToNum[i];
                }
            }
            ap1.setAmonth(sbmonth);

            ap1.closeConnection();

            ImageIcon icon = new ImageIcon("images/tick.png");

            JOptionPane.showMessageDialog(null, "Η εγγραφή έγινε με επιτυχία.", "Επιτυχία.", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM Apartments ORDER BY aid DESC");
                int aid = 0;
                if (rs.next()) {
                    aid = rs.getInt(1);
                }

                st.executeUpdate("delete from Apartments where aid = " + aid);
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            } finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

            JOptionPane.showMessageDialog(null, "Υπήρξε σφάλμα στις εγγραφές των τιμών.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }

        mf1.dispose();

        new MainFrame().setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String d1 = dateFormat.format(date);

        String cur_year = d1.substring(0, 4);
        String cur_month = d1.substring(5, 7);

        String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

        String syear = (String) jComboBox3.getSelectedItem();

        if (syear.equals(cur_year)) {
            jComboBox4.removeAllItems();

            for (int i = 0; i < months.length; i++) {
                String month = months[i];
                jComboBox4.addItem(month);

                //βαζουμε i+1 αντι για i, γιατι: π.χ. ο Ιανουαριος θα εχει i = 0 και θα πρεπει να ελενξουμε αν ισουνται με "01"
                if (i + 1 == Integer.parseInt(cur_month)) {
                    break;
                }
            }
        } else if (syear.equals(getYear())) {
            jComboBox4.removeAllItems();

            for (int i = Integer.parseInt(getMonth()) - 1; i < months.length; i++) {
                String month = months[i];
                jComboBox4.addItem(month);
            }
        } else {
            jComboBox4.removeAllItems();

            for (int i = 0; i < months.length; i++) {
                String month = months[i];
                jComboBox4.addItem(month);
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    public static void main(String args[]) {
        try {
            BasicLookAndFeel darcula = new DarculaLaf();

            javax.swing.UIManager.setLookAndFeel(darcula);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsApartmentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private static javax.swing.JComboBox<String> jComboBox3;
    private static javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
