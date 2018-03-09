package ApBuilding;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class PDF {

    int bid = 0;
    String month = "";
    String year = "";

    String path = "";

    int shared = 0, heat = 0, jown = 0, elevator = 0;
    int gsm = 0; // square meters of whole Building

    PDF(int bid, String month, String year) {
        this.bid = bid;
        this.month = month;
        this.year = year;
    }

    public boolean createPdfs() {

        Connection conn = null;

        try {
            if (bid == 0 || month.equals("") || year.equals("")) {
                return false;
            }

            File def_folder = new File("Αποδείξεις");
            if (!def_folder.exists()) {
                if (def_folder.mkdir()) {
                    System.out.println("Δημιουργηθηκε ο Φακελος Αποδείξεις");
                }
            } else {
                System.out.println("Ο φακελος Αποδείξεις υπαρχει ηδη.");
            }

            File folder1 = new File("Αποδείξεις\\Πολυκατοικία " + bid);
            if (!folder1.exists()) {
                if (folder1.mkdir()) {
                    System.out.println("Δημιουργηθηκε ο Φακελος της πολυκατοικιας");
                }
            } else {
                System.out.println("Ο φακελος της πολυκατοικιας υπαρχει ηδη.");
            }

            String[] months = {"Ιανουάριος", "Φεβρουάριος", "Μάρτιος", "Απρίλιος", "Μάιος", "Ιούνιος",
                "Ιούλιος", "Αύγουστος", "Σεμπτέμβριος", "Οκτώμβριος", "Νοέμβριος", "Δεκέμβριος"};

            String full_month = months[Integer.parseInt(month) - 1];

            path = "Αποδείξεις\\Πολυκατοικία " + bid + "\\" + full_month + " , " + year;

            File folder2 = new File(path);
            if (!folder2.exists()) {
                if (folder2.mkdir()) {
                    System.out.println("Δημιουργηθηκε ο Φακελος της ημερομηνιας");
                }
            } else {
                System.out.println("Ο φακελος της ημερομηνιας υπαρχει ηδη.");
            }

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Expenses where bid = " + bid + " AND emonth = '" + month
                    + "' AND eyear = '" + year + "'");

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

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\Συνολικά Κοινόχρηστα.pdf"));

            doc.open();

            BaseFont bf = BaseFont.createFont("fonts\\LiberationSans-Bold.ttf", "CP1253", BaseFont.EMBEDDED);
            Font font = new Font(bf, 18, Font.BOLD);
            Paragraph par = new Paragraph("", font);
            par.setAlignment(Paragraph.ALIGN_CENTER);
            par.add("\nΣυνολικά Κοινόχρηστα\n");
            par.add("Πολυκατοικία " + fixLetters(bid + ", " + full_month + ", " + year) + "\n");
            doc.add(par);

            // copy µ D Ώ
            // προβλημμα με γραμματα μ Δ Ω
            font = new Font(bf, 15, Font.NORMAL);
            par = new Paragraph("", font);
            par.add("\n\n\n\n");
            par.add("Κοινόχρηστα: " + shared + "€\n\n");
            par.add(fixLetters("Θέρμανση: ") + heat + "€\n\n");
            par.add("Συνιδιοκτησία: " + jown + "€\n\n");
            par.add("Ανελκυστήρας: " + elevator + "€\n\n");
            par.add("\n");
            par.add("Συνολικό Ποσό: " + (shared + elevator + heat + jown) + "€\n\n");
            doc.add(par);

            doc.close();

            int a = 0, b = 0, a2 = 0, b2 = 0;

            rs = st.executeQuery("SELECT * FROM Apartments where bid = " + bid);

            double xiliosta = 0.0;
            int sqm = 0;

            while (rs.next()) {
                a = Integer.parseInt(rs.getString(9));
                b = Integer.parseInt(rs.getString(10));

                a2 = Integer.parseInt(month);
                b2 = Integer.parseInt(year);

                if (b > b2) {
                    break;
                } else if (b == b2 && a > a2) {
                    break;
                }

                sqm = rs.getInt(5);

                xiliosta = (double) Math.round(((double) sqm / gsm) * 1000) / 1000;

                Document doc2 = new Document();
                PdfWriter.getInstance(doc2, new FileOutputStream(path + "\\Κοινόχρηστα " + rs.getString(11) + ".pdf"));

                doc2.open();

                bf = BaseFont.createFont("fonts\\LiberationSans-Bold.ttf", "CP1253", BaseFont.EMBEDDED);
                font = new Font(bf, 18, Font.BOLD);
                par = new Paragraph("", font);
                par.setAlignment(Paragraph.ALIGN_CENTER);
                par.add("\nΚοινόχρηστα " + fixLetters(rs.getString(11)) + "\n");
                par.add("Πολυκατοικία " + fixLetters(bid + ", " + full_month + ", " + year) + "\n");
                doc2.add(par);

                // copy µ D Ώ
                // προβλημμα με γραμματα μ Δ Ω
                font = new Font(bf, 15, Font.NORMAL);
                par = new Paragraph("", font);
                par.add("\n\n\n\n");
                par.add("Κοινόχρηστα: " + ((double) Math.round((shared * xiliosta * 100)) / 100) + "€\n\n");
                par.add(fixLetters("Θέρμανση: ") + ((double) Math.round((heat * xiliosta * 100)) / 100) + "€\n\n");
                par.add("Συνιδιοκτησία: " + ((double) Math.round((jown * xiliosta * 100)) / 100) + "€\n\n");
                par.add("Ανελκυστήρας: " + ((double) Math.round((elevator * xiliosta * 100)) / 100) + "€\n\n");
                par.add("\n");
                par.add("Συνολικό Ποσό: " + ((double) Math.round(((shared + elevator + heat + jown) * xiliosta * 100)) / 100) + "€\n\n");
                par.add("\n\n\n\n");
                par.add("Ιδιοκτήτης: " + fixLetters(rs.getString(6) + ", " + rs.getString(7)));
                doc2.add(par);

                doc2.close();
            }

            st.close();
            conn.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
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
    }

    private static String fixLetters(String str) {
        String fixed_str = "";
        char[] cstr = str.toCharArray();

        for (int i = 0; i < cstr.length; i++) {
            if (cstr[i] == 'μ') {
                cstr[i] = 'µ';
            }

            if (cstr[i] == 'Δ') {
                cstr[i] = 'D';
            }

            if (cstr[i] == 'Ω') {
                cstr[i] = 'Ώ';
            }
        }

        for (int i = 0; i < cstr.length; i++) {
            fixed_str += cstr[i];
        }

        return fixed_str;
    }
}
