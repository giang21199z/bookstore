/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.orders;

import dao.orders.Context;
import entity.shipping.ShippingInfor;
import java.sql.Date;

/**
 *
 * @author GIANGND-SVMC
 */
public class Order {

    private int id;
    private Payment payment;
    private ShippingInfor shippingInfor;
    private Date date;
    private Context context;

    public Order(int id, Payment payment, ShippingInfor shippingInfor, Date date) {
        this.id = id;
        this.payment = payment;
        this.shippingInfor = shippingInfor;
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order(int id, ShippingInfor shippingInfor, Date date) {
        this.id = id;
        this.shippingInfor = shippingInfor;
        this.date = date;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShippingInfor getShippingInfor() {
        return shippingInfor;
    }

    public void setShippingInfor(ShippingInfor shippingInfor) {
        this.shippingInfor = shippingInfor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
