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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class KcoinBankDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public KcoinBankDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public KcoinBankDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void addKcoinBank(KcoinBank kcoinBank) {
        String sql = "INSERT INTO kcoin_bank (idbank) VALUES (?)";
        Bank b = (Bank) kcoinBank;
        BankDAO bankDao = new BankDAO();
        bankDao.addBank(b);
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, kcoinBank.getIdbank());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
