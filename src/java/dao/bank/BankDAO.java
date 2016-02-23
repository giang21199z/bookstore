/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bank;

import dao.connection.ConnectionDB;
import entity.bank.Bank;
import entity.bank.KcoinBank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class BankDAO {
    
    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";
    
    public BankDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }
    
    public BankDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }
    
    public void addBank(Bank bank) {
        String sql = "INSERT INTO bank(idbank,balance,part) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, bank.getIdbank());
            ps.setFloat(2, bank.getBalance());
            ps.setString(3, bank.getPart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Bank getBankStore(String part) {
        String sql = "SELECT * FROM bank WHERE part = ?";
        Bank bank = new Bank();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, part);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idbank");
                float balance = rs.getFloat("balance");
                bank.setIdbank(id);
                bank.setBalance(balance);
                bank.setPart(part);
                return bank;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bank;
    }
}
