/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import ui.UserInfo;


/**
 *
 * @author Jesper Larsson
 * 
 * Class that handles calls from UI layer to BO layer, related to users 
 */
public class UserHandler {

    /**
     *
     * returns UserInfo for User with given username and password  
     * 
     * @param userName
     * @param password
     * @return UserInfo if correct parameters, else null
     */
    public static UserInfo getUser(String userName, String password){
         User user = User.getUser(userName, password);
         if(user != null){
            return new UserInfo(user.getUserName());
         }
         return null;
    }
}
