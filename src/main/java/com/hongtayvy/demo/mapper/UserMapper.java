package com.hongtayvy.demo.mapper;

import com.hongtayvy.demo.dto.UserDTO;
import com.hongtayvy.demo.model.User;
import com.hongtayvy.demo.repository.entity.UserEntity;

public class UserMapper {
    public User toUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getDateOfBirth(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getActive()
        );
    }

    public User toUser(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getDateOfBirth(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getActive()
        );
    }

    public UserDTO toUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getUsername(),
                user.getEmail(),
                user.getActive()
        );
    }

    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getUsername(),
                user.getEmail(),
                user.getActive()
        );
    }
}
