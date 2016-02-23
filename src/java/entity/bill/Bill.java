/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.bill;

import entity.orders.Order;
import entity.staff.Seller;
import java.sql.Date;

/**
 *
 * @author GIANGND-SVMC
 */
public class Bill {

    private int id;
    private Order order;
    private Date date;
    private Seller seller;

    public Bill() {
    }

    public Bill(int id, Order order, Date date, Seller seller) {
        this.id = id;
        this.order = order;
        this.date = date;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}
