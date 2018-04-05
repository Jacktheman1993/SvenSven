/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datbase;

/**
 *
 * @author simon
 */
public class Order {
    
    int orderID;
    int orderPrice;
    String ownerName;
    int forKeyIdBot;
    int forKeyIdTop;

    public Order(int orderID, int orderPrice, String ownerName, int forKeyIdBot, int forKeyIdTop) {
        this.orderID = orderID;
        this.orderPrice = orderPrice;
        this.ownerName = ownerName;
        this.forKeyIdBot = forKeyIdBot;
        this.forKeyIdTop = forKeyIdTop;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getForKeyIdBot() {
        return forKeyIdBot;
    }

    public void setForKeyIdBot(int forKeyIdBot) {
        this.forKeyIdBot = forKeyIdBot;
    }

    public int getForKeyIdTop() {
        return forKeyIdTop;
    }

    public void setForKeyIdTop(int forKeyIdTop) {
        this.forKeyIdTop = forKeyIdTop;
    }
    
    
    
    
    
    
}
