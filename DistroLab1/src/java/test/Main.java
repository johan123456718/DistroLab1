/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import db.DBManager;
import db.ItemDB;

/**
 *
 * @author Johan C
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getName());
        System.out.println(p.getAge());
        
        System.out.println(DBManager.getConnection());
    }
    
}
