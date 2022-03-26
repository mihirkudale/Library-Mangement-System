package dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IssueBookDao {

    public static boolean checkBook(String bookcallno) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from books where callno=?");
            ps.setString(1, bookcallno);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    

    public static int checkQuantity(String studentid) {
        int quantity = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from issuequantity where studentid=?");
            ps.setString(1, studentid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("quantity");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantity;
    }

    public static ArrayList checkStudent(String id) {
        ArrayList<String> studentDetails = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select fname, lname, contact from registrationtbl where id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fName = rs.getString(1);
                String LName = rs.getString(2);
                String contact = rs.getString(3);
                studentDetails.add(fName + " " + LName);
                studentDetails.add(contact);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentDetails;

    }

    public static String getCell(String bookName) {
        String getCellFrmDB = "";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select callno from books where name=?");
            ps.setString(1, bookName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getCellFrmDB = rs.getString(1);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return getCellFrmDB;
    }

    public static int save(String bookcallno, String studentid, String studentname, String studentcontact) {
        int status = 0;
        try {
            Connection con = DB.getConnection();

            status = updatebook(bookcallno);//updating quantity and issue
            Date datee = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
            String curdate = dt.format(datee);
            if (status > 0) {
                PreparedStatement ps = con.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact,issueddate,currentdate,latefine) values(?,?,?,?,?,?,?)");
                ps.setString(1, bookcallno);
                ps.setString(2, studentid);
                ps.setString(3, studentname);
                ps.setString(4, studentcontact);
                ps.setString(5, curdate);
                ps.setString(6, curdate);
                ps.setInt(7, 0);
                status = ps.executeUpdate();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int saveQuantity(String studentid, int quantity) {
        int status = 0;
        System.out.println("Quantity : " + quantity);
        try {
            Connection con = DB.getConnection();

//            status = updatebook(bookcallno);//updating quantity and issue
//            if (status > 0) {
            PreparedStatement ps = con.prepareStatement("insert into issuequantity(studentid,quantity) values(?,?)");
            ps.setString(1, studentid);
            ps.setInt(2, quantity);

            status = ps.executeUpdate();
//            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updateDateAndFine(String studentid, String bookcellNo) {
        int lateFine = 0;
        Date datee = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        String curdate = dt.format(datee);

        try {
            Connection con = DB.getConnection();

//            status = updatebook(bookcallno);//updating quantity and issue
//            if (status > 0) {
            PreparedStatement ps = con.prepareStatement("select issueddate from issuebooks where studentid=? AND bookcallno = ?");
            ps.setString(1, studentid);
            ps.setString(2, bookcellNo);
            ResultSet rs = ps.executeQuery();
            String issueBookDate = "";
            while (rs.next()) {
                issueBookDate = rs.getString(1);
            }
            System.out.println("issueBookDate : " + issueBookDate);
            if (!"".equals(issueBookDate)) {
                Date d1 = null;
                Date d2 = null;
                try {
                    d1 = dt.parse(issueBookDate);
                    d2 = dt.parse(curdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Get msec from each, and subtract.
                long diff = d2.getTime() - d1.getTime();
                long days = diff / (60 * 60 * 1000 * 24);
                System.out.println("Time in Days: " + days + " day.");

                if (days > 15) {
                    lateFine = Integer.parseInt((days - 15) + "");
//                    lateFine= lateFine*10;
                    PreparedStatement ps2 = con.prepareStatement("update issuebooks set currentdate=?, latefine = ? where studentid=? AND bookcallno = ?");
                    ps2.setString(1, curdate);
                    ps2.setString(2, lateFine + "");
                    ps2.setString(3, studentid);
                    ps2.setString(4, bookcellNo);
                    ps2.executeUpdate();
                    con.close();
                }
            }
        } catch (Exception e) {
//            System.out.println(e);
            e.printStackTrace();
        }
        return lateFine;
    }

    public static int getFine(String studentid) {
        int lateFine = 0;
        Date datee = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        String curdate = dt.format(datee);

        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select issueddate from issuebooks where studentid=?");
            ps.setString(1, studentid);
            ResultSet rs = ps.executeQuery();
            String issueBookDate = "";
            while (rs.next()) {
                issueBookDate = rs.getString(1);
            }
            System.out.println("issueBookDate : " + issueBookDate);
            if (!"".equals(issueBookDate)) {
                Date d1 = null;
                Date d2 = null;
                try {
                    d1 = dt.parse(issueBookDate);
                    d2 = dt.parse(curdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Get msec from each, and subtract.
                long diff = d2.getTime() - d1.getTime();
                long days = diff / (60 * 60 * 1000 * 24);
                System.out.println("Time in Days: " + days + " day.");

                if (days > 15) {
                    lateFine = Integer.parseInt((days - 15) + "");
                }
                con.close();
            } else {
                lateFine = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lateFine;
    }

    public static int payFine(String studentid) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps2 = con.prepareStatement("update issuebooks set latefine = 0 where studentid=?");
            ps2.setString(1, studentid);
            status = ps2.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updateQuantity(String studentid, int quantity) {
        int status = 0;
        try {
            Connection con = DB.getConnection();

//            status = updatebook(bookcallno);//updating quantity and issue
//            if (status > 0) {
            PreparedStatement ps2 = con.prepareStatement("update issuequantity set quantity=? where studentid=?");
            ps2.setInt(1, quantity);
            ps2.setString(2, studentid);
            status = ps2.executeUpdate();
//            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updatebook(String bookcallno) {
        int status = 0;
        int quantity = 0, issued = 0;
        try {
            Connection con = DB.getConnection();

            PreparedStatement ps = con.prepareStatement("select quantity,issued from books where callno=?");
            ps.setString(1, bookcallno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                issued = rs.getInt("issued");
            }

            if (quantity > 0) {
                PreparedStatement ps2 = con.prepareStatement("update books set quantity=?,issued=? where callno=?");
                ps2.setInt(1, quantity - 1);
                ps2.setInt(2, issued + 1);
                ps2.setString(3, bookcallno);

                status = ps2.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
