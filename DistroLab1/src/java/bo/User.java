/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.UserDB;

/**
 *
 * @author Jesper Larsson
 * 
 * Class that represents a User
 */
public class User {
    private String userName;

    /**
     *
     * 
     * Tells DB layer to get user with given username and password 
     * 
     * @param userName
     * @param password
     * @return User
     */
    public static User getUser(String userName, String password){
            return (User)(UserDB.getUser(userName, password));
    }
    

    public User(String userName){
        this.userName = userName;
    }
    

    public String getUserName(){
        return userName;
    }
}
