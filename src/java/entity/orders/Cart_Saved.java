/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.orders;

import entity.person.CustomerMember;

/**
 *
 * @author GIANGND-SVMC
 */
public class Cart_Saved {

    private int id;
    private Cart cart;
    private float totalPrice;
    private CustomerMember customerMember;

    public Cart_Saved() {
    }

    public Cart_Saved(int id, Cart cart, float totalPrice, CustomerMember customerMember) {
        this.id = id;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.customerMember = customerMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart_Saved(Cart cart, float totalPrice, CustomerMember customerMember) {
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.customerMember = customerMember;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerMember getCustomerMember() {
        return customerMember;
    }

    public void setCustomerMember(CustomerMember customerMember) {
        this.customerMember = customerMember;
    }

}
