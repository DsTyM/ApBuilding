/* 
    Το προγραμμα φτιαχνει αυτοματα 2 πολυκατοικιες.
    Στην 2η πολυκατοικια, φτιαχνει 4 διαμερισματα και
    εξοδα για 2 μηνες: τον Ιανουαριο και τον φευρουαριο 2018.
    Τα στοιχεια που δινει στα διαμερισματα (π.χ. ονοματα, διευθυνσεις κλπ)
    ειναι εντελως τυχαια.
*/

package ApBuilding;

import com.bulenkov.darcula.DarculaLaf;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class Main {

    public static void main(String[] args) {

        // starts Look and Feel code
        try {
            BasicLookAndFeel darcula = new DarculaLaf();

            javax.swing.UIManager.setLookAndFeel(darcula);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // ends Look and Feel code

        new MainFrame().setVisible(true);
    }
}
