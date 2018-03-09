package ApBuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Building {

    private String address;
    private String city;
    private String addr_code;
    private String building_admin_fname;
    private String building_admin_lname;
    private int num_of_floors;
    private int sq_meters_per_floor;
    private int num_of_apartments;

    private int bid;

    private String bmonth; // eg: "01", "02", ...
    private String byear; // eg: "2017", "2018", ...

    private Connection conn; // για την sql συνδεση, παιρνει τιμη πιο κατω στην συναρτιση init()

    public Building() {
        this.init();
    }

    public Building(String address, String city, String addr_code, String building_admin_fname,
            String building_admin_lname, int num_of_floors, int sq_meters_per_floor, int num_of_apartments) {
        this.address = address;
        this.city = city;
        this.addr_code = addr_code;
        this.building_admin_fname = building_admin_fname;
        this.building_admin_lname = building_admin_lname;
        this.num_of_floors = num_of_floors;
        this.sq_meters_per_floor = sq_meters_per_floor;
        this.num_of_apartments = num_of_apartments;

        this.init();

        this.setAddress(address);
        this.setCity(city);
        this.setAddr_code(addr_code);
        this.setBuilding_admin_fname(building_admin_fname);
        this.setBuilding_admin_lname(building_admin_lname);
        this.setNum_of_floors(num_of_floors);
        this.setSq_meters_per_floor(sq_meters_per_floor);
        this.setNum_of_apartments(num_of_apartments);
    }

    private void init() {
        this.address = "-";
        this.city = "-";
        this.addr_code = "-";
        this.building_admin_fname = "-";
        this.building_admin_lname = "-";
        this.num_of_floors = 0;
        this.sq_meters_per_floor = 0;
        this.num_of_apartments = 0;
        this.byear = "-";
        this.bmonth = "-";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ExpensesCalculatorLiteDB.db");

            Statement st = conn.createStatement();

            st.executeUpdate("insert into ApBuildings(address, city, addr_code, building_admin_fname, "
                    + "building_admin_lname, num_of_floors, sq_meters_per_floor, num_of_apartments, bmonth, byear) values( '"
                    + address + "', '" + city + "', '" + addr_code + "', '" + building_admin_fname + "', '"
                    + building_admin_lname + "', '" + num_of_floors + "', '" + sq_meters_per_floor + "', '"
                    + num_of_apartments + "', '" + bmonth + "', '" + byear + "')");

            ResultSet rs = st.executeQuery("SELECT * FROM ApBuildings ORDER BY bid DESC");

            if (rs.next()) {
                bid = rs.getInt(1);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAddress(String address) {
        this.address = address;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET address = '" + address + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setCity(String city) {
        this.city = city;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET city = '" + city + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAddr_code(String addr_code) {
        this.addr_code = addr_code;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET addr_code = '" + addr_code + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBuilding_admin_fname(String building_admin_fname) {
        this.building_admin_fname = building_admin_fname;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET building_admin_fname = '" + building_admin_fname
                    + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBuilding_admin_lname(String building_admin_lname) {
        this.building_admin_lname = building_admin_lname;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET building_admin_lname = '" + building_admin_lname
                    + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setNum_of_floors(int num_of_floors) {
        this.num_of_floors = num_of_floors;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET num_of_floors = '" + num_of_floors
                    + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSq_meters_per_floor(int sq_meters_per_floor) {
        this.sq_meters_per_floor = sq_meters_per_floor;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET sq_meters_per_floor = '"
                    + sq_meters_per_floor + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setNum_of_apartments(int num_of_apartments) {
        this.num_of_apartments = num_of_apartments;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET num_of_apartments = '"
                    + num_of_apartments + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET bmonth = '" + bmonth + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setByear(String byear) {
        this.byear = byear;

        try {
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE ApBuildings SET byear = '" + byear + "' WHERE bid = '" + bid + "'");

            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddr_code() {
        return this.addr_code;
    }

    public String getBuilding_admin_fname() {
        return this.building_admin_fname;
    }

    public String getBuilding_admin_lname() {
        return this.building_admin_lname;
    }

    public int getNum_of_floors() {
        return this.num_of_floors;
    }

    public int getSq_meters_per_floor() {
        return this.sq_meters_per_floor;
    }

    public int getNum_of_apartments() {
        return this.num_of_apartments;
    }

    public int getBid() {
        return this.bid;
    }

    public String getMonth() {
        return this.bmonth;
    }

    public String getYear() {
        return this.byear;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
