package ApBuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Apartment {

    private String atype;
    private int floor;
    private int sq_meters;
    private String owner_fname;
    private String owner_lname;
    private String owner_phone;
    private String aname;

    private int aid;

    private String amonth;
    private String ayear;

    private int bid;

    private Connection conn;

    public Apartment(int bid) {
        this.bid = bid;

        this.init();
    }

    public Apartment(int bid, String atype, int floor, int sq_meters, String owner_fname,
            String owner_lname, String owner_phone, String aname) {
        this.bid = bid;

        this.atype = atype;
        this.floor = floor;
        this.sq_meters = sq_meters;
        this.owner_fname = owner_fname;
        this.owner_lname = owner_lname;
        this.owner_phone = owner_phone;
        this.aname = aname;

        this.init();

        this.setAtype(atype);
        this.setFloor(floor);
        this.setSq_meters(sq_meters);
        this.setOwner_fname(owner_fname);
        this.setOwner_lname(owner_lname);
        this.setOwner_phone(owner_phone);
        this.setAname(aname);
    }

    private void init() {
        this.atype = "-";
        this.floor = 0;
        this.sq_meters = 0;
        this.owner_fname = "-";
        this.owner_lname = "-";
        this.owner_phone = "-";
        this.amonth = "-";
        this.ayear = "-";
        this.aname = "-";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            st.executeUpdate("insert into Apartments(bid, atype, floor, sq_meters, owner_fname, owner_lname, "
                    + "owner_phone, amonth, ayear, aname) values( '" + bid + "', '" + atype + "', '" + floor + "', '" + sq_meters + "', '" + owner_fname
                    + "', '" + owner_lname + "', '" + owner_phone + "', '" + amonth + "', '" + ayear + "', '" + aname + "')");

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments ORDER BY aid DESC");

            if (rs.next()) {
                aid = rs.getInt(1);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAtype(String atype) {
        this.atype = atype;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET atype = '" + atype + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setFloor(int floor) {
        this.floor = floor;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET floor = '" + floor + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSq_meters(int sq_meters) {
        this.sq_meters = sq_meters;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET sq_meters = '" + sq_meters + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOwner_fname(String owner_fname) {
        this.owner_fname = owner_fname;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET owner_fname = '" + owner_fname + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOwner_lname(String owner_lname) {
        this.owner_lname = owner_lname;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET owner_lname = '" + owner_lname + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET owner_phone = '" + owner_phone + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAmonth(String amonth) {
        this.amonth = amonth;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET amonth = '" + amonth + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAyear(String ayear) {
        this.ayear = ayear;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Apartments SET ayear = '" + ayear + "' WHERE aid = '" + aid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAname(String aname) {
        this.aname = aname;

        try {
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Apartments where bid = " +this.bid);

            int times = 1;

            while (rs.next()) {
                if (rs.getString(11).equals(aname)) {
                    times++;
                }
            }

            if(times > 1)
            {
                aname = aname + " (" + times + ")";
            }

            st.executeUpdate("UPDATE Apartments SET aname = '" + aname + "' WHERE aid = '" + aid + "' AND bid = " +this.bid);

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAtype() {
        return this.atype;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getSq_meters() {
        return this.sq_meters;
    }

    public String getOwner_fname() {
        return this.owner_fname;
    }

    public String getOwner_lname() {
        return this.owner_lname;
    }

    public String getOwner_phone() {
        return this.owner_phone;
    }

    public int getAid() {
        return this.aid;
    }

    public String getAmonth() {
        return this.amonth;
    }

    public String getAyear() {
        return this.ayear;
    }

    public String getAname() {
        return this.aname;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
