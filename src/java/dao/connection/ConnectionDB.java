/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GIANGND-SVMC
 */
public class ConnectionDB {

    Connection con;
    public ConnectionDB() {
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/tkpm?characterEncoding=utf-8";
        try {
            Class.forName(className);
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("ket noi thanh con csdl");
        } catch (Exception e) {
            System.err.println("Khong ket noi duoc" + e.toString());
        }
    }

    public Connection getConnect(String dbusername, String dbpassword) {
        return con;
    }
    
}
