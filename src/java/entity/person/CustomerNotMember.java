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
public class CustomerNotMember extends Customer implements Serializable {

    public CustomerNotMember() {
        super();
    }

    public CustomerNotMember(String phone, String email, int idperson, Fullname fullname, Address address, String part) {
        super(phone, email, idperson, fullname, address, part);
    }

    public CustomerNotMember(String phone, String email) {
        super(phone, email);
    }

}
