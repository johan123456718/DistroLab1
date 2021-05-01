/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.ItemDB;
import java.util.Collection;

/**
 *
 * @author Johan C
 */
public class Item {
    private String name;
    private String descr;
    private int id;
   
    /**
     *
     * Tells DB layer to get all items 
     * 
     * @return Collection of items
     * 
     */
    static public Collection getAllItems(){
        return ItemDB.getItems();
    }
    
    protected Item(int id, String name, String desc){
        this.id = id;
        this.name = name;
        this.descr = desc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }
    
}
