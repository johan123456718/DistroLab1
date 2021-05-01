/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Johan Challita
 * 
 * * Class that is used to present information for items in cart
 */
public class CartItemInfo {
    private String itemName;
    private int quantity;
    
    public CartItemInfo(String itemName, int quantity){
        this.itemName = itemName;
        this.quantity = quantity;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }


    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

}