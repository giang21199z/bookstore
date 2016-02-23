/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.orders;

import entity.bank.Bank;

/**
 *
 * @author GIANGND-SVMC
 */
public class Payment {

    private int id;
    private Bank bank;
    private Cart cart;
    private int type;

    public Payment() {
    }

    public Payment(int id, Bank bank, Cart cart, int type) {
        this.id = id;
        this.bank = bank;
        this.cart = cart;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
