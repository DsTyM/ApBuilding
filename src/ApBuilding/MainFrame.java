package ApBuilding;

import com.bulenkov.darcula.DarculaLaf;
import java.util.ArrayList;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        setResizable(false);
        setTitle("Διαχείριση Κοινοχρήστων Πολυκατοικίας");
    }

    private int bid = 0;

    public int getBid() {
        return bid;
    }

    private String selected_month = "";

    public String getSelectedMonth() {
        return selected_month;
    }

    private String selected_year = "";

    public String getSelectedYear() {
        return selected_year;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel1.setText("Διαχείριση Κοινοχρήστων Πολυκατοικίας");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel1.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Πολυκατοικίες (βάσει ID)");

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton1.setText("Εισαγωγή Πολυκατοικίας");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setAutoscrolls(true);

        jList1.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList1.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        ArrayList<Integer> buildings = new ArrayList<>();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings ORDER BY bid");

            while (rs.next()) {
                buildings.add(rs.getInt(1));
            }

            DefaultListModel<String> model = new DefaultListModel<>();
            //JList<String> list = new JList<>(model);

            for (int i = 0; i < buildings.size(); i++) {
                model.addElement("Πολυκατοικία " +buildings.get(i));
            }

            jList1.setModel(model);

            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jList1PropertyChange(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Πολυκατοικία");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Διάλεξε Ημερομηνία");

        jComboBox1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setText("Διάλεξε Όροφο:");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel8.setText("Διάλεξε Διαμέρισμα:");

        jComboBox3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton2.setText("Διαγραφή Πολυκατοικίας");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton3.setText("Εισαγωγή Διαμερίσματος");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Όνομα Διαμερίσματος");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Έξοδα Κοινοχρήστων:");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Έξοδα Θέρμανσης:");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setText("Έξοδα Συνιδιοκτησίας:");

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setText("Έξοδα Ανελκυστήρα:");

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel14.setText("Χιλιοστά Διαμερίσματος: ");

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton4.setText("Διαγραφή");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Τύπος, Τετραγωνικά Μέτρα, Όνομα Ιδιοκτήτη, Τηλέφωνο");

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel23.setText("Σύνολο:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(20, 20, 20)))
                                .addGap(138, 138, 138)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel23)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24))
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Συνολικά Κοινόχρηστα:");

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel16.setText("Όλης της Πολυκατοικίας");

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel17.setText("Έξοδα Κοινοχρήστων:");

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel18.setText("Έξοδα Θέρμανσης:");

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel19.setText("Έξοδα Συνιδιοκτησίας:");

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel20.setText("Έξοδα Ανελκυστήρα:");

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Μήνας, Χρόνος");

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel22.setText("Σύνολο:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel16)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(46, 46, 46)
                .addComponent(jLabel17)
                .addGap(40, 40, 40)
                .addComponent(jLabel18)
                .addGap(48, 48, 48)
                .addComponent(jLabel19)
                .addGap(48, 48, 48)
                .addComponent(jLabel20)
                .addGap(46, 46, 46)
                .addComponent(jLabel22)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton5.setText("Επεξεργασία Εξόδων Επιλεγμένου Μήνα");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton6.setText("Εκτύπωση Απόδειξης");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Διεύθυνση και Πόλη");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(619, 619, 619))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InsBuildingFrame b1 = new InsBuildingFrame(this);
        b1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // starts jComboBox3 (Apartments) Intialization
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            String sfloor = (String) jComboBox4.getSelectedItem();
            int floor = 0;
            if (sfloor.equals("Ισόγειο")) {
                floor = 0;
            } else {
                sfloor = sfloor.substring(0, (sfloor.length() - 2));
                floor = Integer.parseInt(sfloor);
            }

            String year = "";
            String month2 = "";

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid);

            if (rs.next()) {
                year = rs.getString(10);
                month2 = rs.getString(9);
            }

            String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

            int imonth2 = 0;

            for (int i = 0; i < months.length; i++) {
                if (months[i].equals((String) jComboBox2.getSelectedItem())) {
                    imonth2 = i + 1;
                }
            }

            if (imonth2 <= 9) {
                this.selected_month = "0" + imonth2;
            } else {
                this.selected_month = imonth2 + "";
            }

            int iyear = Integer.parseInt(year);
            int imonth = Integer.parseInt(month2);

            int iyear2 = Integer.parseInt((String) jComboBox1.getSelectedItem());

            if (iyear2 == iyear && imonth2 >= imonth) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else if (iyear2 > iyear) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else {
                jComboBox3.removeAllItems();
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends jComboBox3 (Apartments) Intialization

        // starts Expenses Calculation and Printing for whole Building
        jLabel21.setText(((String) jComboBox1.getSelectedItem()) + ", " + ((String) jComboBox2.getSelectedItem()));

        int shared = 0, heat = 0, jown = 0, elevator = 0;
        int gsm = 0; // square meters of whole Building

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Expenses where bid = " + bid + " AND emonth = '" + selected_month
                    + "' AND eyear = '" + selected_year + "'");

            if (rs.next()) {
                shared = rs.getInt(5) + rs.getInt(6) + rs.getInt(7) + rs.getInt(8);
                heat = rs.getInt(9) + rs.getInt(10);
                jown = rs.getInt(11);
                elevator = rs.getInt(12) + rs.getInt(13) + rs.getInt(14);
            }

            rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + bid);

            if (rs.next()) {
                gsm = rs.getInt(8) * rs.getInt(7);
            }

            int all = shared + heat + jown + elevator;

            jLabel17.setText("Έξοδα Κοινοχρήστων: " + shared + "€");
            jLabel18.setText("Έξοδα Θέρμανσης: " + heat + "€");
            jLabel19.setText("Έξοδα Συνιδιοκτησίας: " + jown + "€");
            jLabel20.setText("Έξοδα Ανελκυστήρα: " + elevator + "€");

            jLabel22.setText("Σύνολο: " + all + "€");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends Expenses Calculation and Printing for whole Building
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            st.executeUpdate("delete from ApBuildings where bid = " + this.bid);

            ImageIcon icon = new ImageIcon("images/tick.png");
            JOptionPane.showMessageDialog(null, "Η διαγραφή της πολυκατοικίας πραγματοποιήθηκε με επιτυχία.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE, icon);

            new MainFrame().setVisible(true);

            this.dispose();

            st.close();
        } catch (Exception e2) {
            System.out.println(e2.getMessage());

            JOptionPane.showMessageDialog(null, "Η πολυκατοικία δεν κατάφερε να διαγραφτεί.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InsApartmentFrame ap1 = new InsApartmentFrame(this);
        ap1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            String aname = (String) jComboBox3.getSelectedItem();

            st.executeUpdate("delete from Apartments where bid = " + this.bid + " AND aname = '" + aname + "'");

            ImageIcon icon = new ImageIcon("images/tick.png");
            JOptionPane.showMessageDialog(null, "Η διαγραφή του διαμερίσματος πραγματοποιήθηκε με επιτυχία.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE, icon);

            new MainFrame().setVisible(true);

            this.dispose();

            st.close();
        } catch (Exception e2) {
            System.out.println(e2.getMessage());

            JOptionPane.showMessageDialog(null, "Το διαμέρισμα δεν κατάφερε να διαγραφτεί.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        PDF pdf1 = new PDF(this.bid, this.selected_month, this.selected_year);
        boolean done = pdf1.createPdfs();

        if (done) {
            ImageIcon icon = new ImageIcon("images/tick.png");
            JOptionPane.showMessageDialog(null, "Οι αποδείξεις σε μορφή PDF δημιουργήθηκαν με επιτυχία.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            JOptionPane.showMessageDialog(null, "Δεν κατάφεραν να δημιουργηθούν οι αποδείξεις σε μορφή PDF.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InsExpenses exp1 = new InsExpenses(this);
        exp1.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String apname = (String) jComboBox3.getSelectedItem();

        if (apname == null) {
            jLabel9.setText("Όνομα Διαμερίσματος");
            jButton4.setText("Διαγραφή");
        } else {
            jLabel9.setText(apname);
            jButton4.setText("Διαγραφή " + apname);
        }

        String type = "", owner = "", phone = "";
        int tm = 0;

        Connection conn = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND aname = '" + apname + "'");

            if (rs.next()) {
                type = rs.getString(3);
                owner = rs.getString(6) + " " + rs.getString(7);
                tm = rs.getInt(5);
                phone = rs.getString(8);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        String sen1 = "";

        if (type != null && !type.equals("")) {
            sen1 += type;
        }
        if (tm != 0) {
            sen1 += " , " + tm + " τ.μ.";
        }
        if (!owner.equals(" ") && !owner.equals("") && owner != null) {
            sen1 += " , " + owner;
        }
        if (phone != null && !phone.equals("")) {
            sen1 += ", " + phone;
        }

        if (sen1.equals("")) {
            jLabel6.setText("Τύπος, Τετραγωνικά Μέτρα, Όνομα Ιδιοκτήτη, Τηλέφωνο");
        } else {
            jLabel6.setText(sen1);
        }

        // starts Expenses Calculation and Printing for specific Apartment
        int shared = 0, heat = 0, jown = 0, elevator = 0;
        int gsm = 0; // square meters of whole Building

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Expenses where bid = " + bid + " AND emonth = '" + selected_month
                    + "' AND eyear = '" + selected_year + "'");

            if (rs.next()) {
                shared = rs.getInt(5) + rs.getInt(6) + rs.getInt(7) + rs.getInt(8);
                heat = rs.getInt(9) + rs.getInt(10);
                jown = rs.getInt(11);
                elevator = rs.getInt(12) + rs.getInt(13) + rs.getInt(14);
            }

            rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                gsm = rs.getInt(8) * rs.getInt(7);
            }

            rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND aname = '" + apname + "'");

            double xiliosta = 0.0;
            int sqm = 0;

            double all = 0.0;

            if (rs.next()) {
                sqm = rs.getInt(5);

                xiliosta = (double) Math.round(((double) sqm / gsm) * 1000) / 1000;

                all = shared + heat + jown + elevator;
                all = ((double) Math.round(all * xiliosta * 100) / 100);

                jLabel10.setText("Κοινόχρηστα: " + ((double) Math.round((shared * xiliosta * 100)) / 100) + "€");
                jLabel11.setText("Θέρμανση: " + ((double) Math.round((heat * xiliosta * 100)) / 100) + "€");
                jLabel12.setText("Συνιδιοκτησία: " + ((double) Math.round((jown * xiliosta * 100)) / 100) + "€");
                jLabel13.setText("Ανελκυστήρας: " + ((double) Math.round((elevator * xiliosta * 100)) / 100) + "€");
                
                jLabel23.setText("Σύνολο: " +all +"€");

                jLabel14.setText("Χιλιοστά Διαμερίσματος: " + xiliosta);
            }

            if (apname == null) {
                jLabel10.setText("Κοινόχρηστα:");
                jLabel11.setText("Θέρμανση:");
                jLabel12.setText("Συνιδιοκτησία:");
                jLabel13.setText("Ανελκυστήρας:");

                jLabel23.setText("Σύνολο:");
                
                jLabel14.setText("Χιλιοστά Διαμερίσματος:");
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends Expenses Calculation and Printing for specific Apartment
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jList1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jList1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1PropertyChange

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String buil_name = jList1.getSelectedValue();
        jLabel3.setText(buil_name);
        jButton2.setText("Διαγραφή " + buil_name);

        // 13, επειδη 12 γραμματα ειναι η λεξη πολυκατοικια +1 που ειναι το κενο
        this.bid = Integer.parseInt(buil_name.substring(13, buil_name.length()));

        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox3.setEnabled(true);
        jComboBox4.setEnabled(true);

        // starts jComboBox1 (Years) Intialization
        String year = "";

        Connection conn = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                year = rs.getString(11);
            }

            st.close();
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

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String d1 = dateFormat.format(date);

        String cur_year = d1.substring(0, 4);

        String given_year = year;

        jComboBox1.removeAllItems();

        for (int i = Integer.parseInt(given_year); i <= Integer.parseInt(cur_year); i++) {
            String s1 = String.valueOf(i);
            jComboBox1.addItem(s1);
        }
        jComboBox1.setSelectedItem(cur_year);
        // ends jComboBox1 (Years) Intialization

        // starts jComboBox2 (Months) Intialization
        String month2 = "";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                month2 = rs.getString(10);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        String cur_month = d1.substring(5, 7);

        String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

        String syear = (String) jComboBox1.getSelectedItem();

        if (syear.equals(cur_year)) {
            jComboBox2.removeAllItems();

            for (int i = 0; i < months.length; i++) {
                String month = months[i];
                jComboBox2.addItem(month);

                //βαζουμε i+1 αντι για i, γιατι: π.χ. ο Ιανουαριος θα εχει i = 0 και θα πρεπει να ελενξουμε αν ισουνται με "01"
                if (i + 1 == Integer.parseInt(cur_month)) {
                    break;
                }
            }
        }
        // ends jComboBox2 (Months) Intialization

        // starts jComboBox4 (Floors) Intialization
        int floors = 0;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                floors = rs.getInt(7);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        jComboBox4.removeAllItems();

        for (int i = 0; i < floors; i++) {
            String s1 = "";

            if (i == 0) {
                s1 = "Ισόγειο";
            } else {
                s1 = i + "ος";
            }

            jComboBox4.addItem(s1);
        }
        // ends jComboBox4 (Floors) Intialization

        // starts jComboBox3 (Apartments) Intialization
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = 0");

            jComboBox3.removeAllItems();

            while (rs.next()) {
                jComboBox3.addItem(rs.getString(11));
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends jComboBox3 (Apartments) Intialization

        // show Building address code and city
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                String adcity = rs.getString(2) + ", " + rs.getString(3);
                if (!adcity.equals(", ")) {
                    jLabel5.setText(rs.getString(2) + ", " + rs.getString(3));
                } else {
                    jLabel5.setText("Διεύθυνση και Πόλη");
                }
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String year = "";
        String month2 = "";

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings where bid = " + this.bid);

            if (rs.next()) {
                year = rs.getString(11);
                month2 = rs.getString(10);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String d1 = dateFormat.format(date);

        String cur_year = d1.substring(0, 4);
        String cur_month = d1.substring(5, 7);

        String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

        String syear = "-";

        if ((String) jComboBox1.getSelectedItem() != null) {
            syear = (String) jComboBox1.getSelectedItem();

            this.selected_year = (String) jComboBox1.getSelectedItem();
        }

        if (syear.equals(cur_year)) {
            jComboBox2.removeAllItems();

            for (int i = 0; i < months.length; i++) {
                String month = months[i];
                jComboBox2.addItem(month);

                //βαζουμε i+1 αντι για i, γιατι: π.χ. ο Ιανουαριος θα εχει i = 0 και θα πρεπει να ελενξουμε αν ισουνται με "01"
                if (i + 1 == Integer.parseInt(cur_month)) {
                    break;
                }
            }
        } else if (syear.equals(year)) {
            jComboBox2.removeAllItems();

            for (int i = Integer.parseInt(month2) - 1; i < months.length; i++) {
                String month = months[i];
                jComboBox2.addItem(month);
            }
        } else {
            jComboBox2.removeAllItems();

            for (int i = 0; i < months.length; i++) {
                String month = months[i];
                jComboBox2.addItem(month);
            }
        }

        // starts jComboBox3 (Apartments) Intialization
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            String sfloor = (String) jComboBox4.getSelectedItem();
            int floor = 0;
            if (sfloor.equals("Ισογειο")) {
                floor = 0;
            } else {
                sfloor = sfloor.substring(0, (sfloor.length() - 2));
                floor = Integer.parseInt(sfloor);
            }

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid);

            if (rs.next()) {
                year = rs.getString(10);
                month2 = rs.getString(9);
            }

            int imonth2 = 0;

            for (int i = 0; i < months.length; i++) {
                if (months[i].equals((String) jComboBox2.getSelectedItem())) {
                    imonth2 = i + 1;
                }
            }

            int iyear = Integer.parseInt(year);
            int imonth = Integer.parseInt(month2);

            int iyear2 = Integer.parseInt((String) jComboBox1.getSelectedItem());

            if (iyear2 == iyear && imonth2 >= imonth) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else if (iyear2 > iyear) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else {
                jComboBox3.removeAllItems();
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends jComboBox3 (Apartments) Intialization
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // starts jComboBox3 (Apartments) Intialization
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            String sfloor = (String) jComboBox4.getSelectedItem();
            int floor = 0;
            if (sfloor.equals("Ισόγειο")) {
                floor = 0;
            } else {
                sfloor = sfloor.substring(0, (sfloor.length() - 2));
                floor = Integer.parseInt(sfloor);
            }

            String year = "";
            String month2 = "";

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid);

            if (rs.next()) {
                year = rs.getString(10);
                month2 = rs.getString(9);
            }

            String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

            int imonth2 = 0;

            for (int i = 0; i < months.length; i++) {
                if (months[i].equals((String) jComboBox2.getSelectedItem())) {
                    imonth2 = i + 1;
                }
            }

            int iyear = Integer.parseInt(year);
            int imonth = Integer.parseInt(month2);

            int iyear2 = Integer.parseInt((String) jComboBox1.getSelectedItem());

            if (iyear2 == iyear && imonth2 >= imonth) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else if (iyear2 > iyear) {
                rs = st.executeQuery("SELECT * FROM Apartments where bid = " + this.bid + " AND floor = " + floor);

                jComboBox3.removeAllItems();

                while (rs.next()) {
                    jComboBox3.addItem(rs.getString(11));
                }
            } else {
                jComboBox3.removeAllItems();
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        // ends jComboBox3 (Apartments) Intialization
    }//GEN-LAST:event_jComboBox4ActionPerformed

    public static void main(String args[]) {
        try {
            BasicLookAndFeel darcula = new DarculaLaf();

            javax.swing.UIManager.setLookAndFeel(darcula);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
