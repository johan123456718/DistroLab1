/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Jesper Larsson
 * 
 * Class that is used to present user information
 */
public class UserInfo {
    private String userName;
    
    public UserInfo(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
}
