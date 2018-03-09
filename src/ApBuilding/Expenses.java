package ApBuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Expenses {

    private int electric;
    private int water;
    private int cleaning;
    private int other_shared_expenses;
    private int gus;
    private int boiler_maintenance;
    private int joint_ownership;
    private int elevator_maintenace;
    private int elevator_spare_parts;
    private int elevator_technician;

    private int eid;

    private String emonth;
    private String eyear;

    private int bid;

    private Connection conn;

    public Expenses(int bid, String emonth, String eyear) {
        this.bid = bid;
        this.emonth = emonth;
        this.eyear = eyear;

        this.init();
    }

    public Expenses(int bid, String emonth, String eyear, int electric, int water, int cleaning,
            int other_shared_expenses, int gus, int boiler_maintenance, int joint_ownership,
            int elevator_maintenace, int elevator_spare_parts, int elevator_technician) {

        this.bid = bid;
        this.emonth = emonth;
        this.eyear = eyear;

        this.electric = electric;
        this.water = water;
        this.cleaning = cleaning;
        this.other_shared_expenses = other_shared_expenses;
        this.gus = gus;
        this.boiler_maintenance = boiler_maintenance;
        this.joint_ownership = joint_ownership;
        this.elevator_maintenace = elevator_maintenace;
        this.elevator_spare_parts = elevator_spare_parts;
        this.elevator_technician = elevator_technician;

        this.init();
    }

    private void init() {
        this.electric = 0;
        this.water = 0;
        this.cleaning = 0;
        this.other_shared_expenses = 0;
        this.gus = 0;
        this.boiler_maintenance = 0;
        this.joint_ownership = 0;
        this.elevator_maintenace = 0;
        this.elevator_spare_parts = 0;
        this.elevator_technician = 0;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            st.executeUpdate("insert into Expenses(bid, eyear, emonth, electric, water, cleaning, other_shared_expenses, gus, "
                    + "boiler_maintenance, joint_ownership, elevator_maintenance, elevator_spare_parts, "
                    + "elevator_technician) values('" + bid + "', '" + eyear + "', '" + emonth + "', '" + electric + "', '" + water + "', '"
                    + +cleaning + "', '" + other_shared_expenses + "', '" + gus + "', '" + boiler_maintenance + "', '" + joint_ownership
                    + "', '" + elevator_maintenace + "', '" + elevator_spare_parts + "', '" + elevator_technician + " ')");

            ResultSet rs = st.executeQuery("SELECT * FROM Expenses ORDER BY eid DESC");

            if (rs.next()) {
                eid = rs.getInt(1);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setElectric(int electric) {
        this.electric = electric;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET electric = '" + electric + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setWater(int water) {
        this.water = water;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET water = '" + water + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET cleaning = '" + cleaning + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOther_shared_expenses(int other_shared_expenses) {
        this.other_shared_expenses = other_shared_expenses;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET other_shared_expenses = '"
                    + other_shared_expenses + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setGus(int gus) {
        this.gus = gus;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET gus = '" + gus + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBoiler_maintenance(int boiler_maintenance) {
        this.boiler_maintenance = boiler_maintenance;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET boiler_maintenance = '" + boiler_maintenance
                    + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setJoint_ownership(int joint_ownership) {
        this.joint_ownership = joint_ownership;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET joint_ownership = '"
                    + joint_ownership + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setElevator_maintenace(int elevator_maintenace) {
        this.elevator_maintenace = elevator_maintenace;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET elevator_maintenance = '"
                    + elevator_maintenace + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setElevator_spare_parts(int elevator_spare_parts) {
        this.elevator_spare_parts = elevator_spare_parts;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET elevator_spare_parts = '"
                    + elevator_spare_parts + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setElevator_technician(int elevator_technician) {
        this.elevator_technician = elevator_technician;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Expenses SET elevator_technician = '"
                    + elevator_technician + "' WHERE eid = '" + eid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getElectric() {
        return this.electric;
    }

    public int getWater() {
        return this.water;
    }

    public int getCleaning() {
        return this.cleaning;
    }

    public int getOther_shared_expenses() {
        return this.other_shared_expenses;
    }

    public int getGus() {
        return this.gus;
    }

    public int getBoiler_maintenance() {
        return this.boiler_maintenance;
    }

    public int getJoint_ownership() {
        return this.joint_ownership;
    }

    public int getElevator_maintenace() {
        return this.elevator_maintenace;
    }

    public int getElevator_spare_parts() {
        return this.elevator_spare_parts;
    }

    public int getElevator_technician() {
        return this.elevator_technician;
    }

    public int getEid() {
        return this.eid;
    }

    public String getEmonth() {
        return this.emonth;
    }

    public String getEyear() {
        return this.eyear;
    }

    public int getBid() {
        return this.bid;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
