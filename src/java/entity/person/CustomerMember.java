/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.person;

import entity.bank.KcoinBank;
import java.io.Serializable;

/**
 *
 * @author GIANGND-SVMC
 */
public class CustomerMember extends Customer implements Serializable {

    public CustomerMember() {
    }

    public CustomerMember(String username, String password, KcoinBank coinBank, String phone, String email, int idperson, Fullname fullname, Address address, String part) {
        super(phone, email, idperson, fullname, address, part);
        this.username = username;
        this.password = password;
        this.coinBank = coinBank;
    }

    private String username;
    private String password;
    private KcoinBank coinBank;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public KcoinBank getCoinBank() {
        return coinBank;
    }

    public void setCoinBank(KcoinBank coinBank) {
        this.coinBank = coinBank;
    }

}
