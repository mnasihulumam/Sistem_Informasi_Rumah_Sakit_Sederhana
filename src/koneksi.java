/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author M. Nasihul Umam
 */
public class koneksi {
    Connection con;
    public koneksi(){
        String id, pass, driver, url;
        id = "root"; //User DBMS MySQL
        pass = ""; //Password DBMS MySQL
        driver="com.mysql.jdbc.Driver";//Driver MySQL
        url="jdbc:mysql://localhost:3306/db_rs"; //nama database : db_kasir
        try {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url,id,pass);
        } catch (Exception e) {
            System.out.println(""+e.getLocalizedMessage());
        }
    }
    public static void main(String [] args){
        koneksi k = new koneksi();
    }
}
