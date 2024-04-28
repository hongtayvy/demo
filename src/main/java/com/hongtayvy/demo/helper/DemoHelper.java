package com.hongtayvy.demo.helper;

import com.hongtayvy.demo.dto.UserDTO;
import com.hongtayvy.demo.exception.DemoFormatException;

public class DemoHelper {
    public int sanitizedId(String id){
        try{
            return Integer.parseInt(id);
        } catch(Exception exception){
            throw new DemoFormatException("Unable to sanitize id");
        }
    }

    public boolean sanitizeActive(Boolean active){
        try{
            return active;
        } catch(Exception exception){
            throw new DemoFormatException("Unable to sanitize active");
        }
    }

    public UserDTO sanitizedRequestBody(UserDTO userDTO){
        if(userDTO.getId() == null || userDTO.getId() == 0){
            userDTO.setId(0);
            return userDTO;
        } else {
            throw new DemoFormatException("Unable to save passed in user");
        }
    }
}
