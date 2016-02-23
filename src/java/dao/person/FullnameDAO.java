/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.person;

import dao.connection.ConnectionDB;
import entity.person.Fullname;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class FullnameDAO {
    Connection con = null;

    public FullnameDAO() {
    }
    public FullnameDAO(String dbusername, String dbpassword){
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbusername,dbpassword);
    }
    public void addFullname(Fullname fullname){
        String sqlFullname = "INSERT INTO fullname(idfullname,firstname,midname,lastname) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlFullname);
            ps.setInt(1, fullname.getId());
            ps.setString(2,fullname.getFname());
            ps.setString(3,fullname.getMname());
            ps.setString(4, fullname.getLname());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FullnameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
