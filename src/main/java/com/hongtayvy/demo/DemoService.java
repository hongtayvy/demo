package com.hongtayvy.demo;

import com.hongtayvy.demo.dto.UserDTO;
import com.hongtayvy.demo.mapper.UserMapper;
import com.hongtayvy.demo.model.User;
import com.hongtayvy.demo.repository.UserDAOImpl;
import com.hongtayvy.demo.repository.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final UserDAOImpl userDAOImpl;
    private final UserMapper userMapper;

    @Autowired
    public DemoService(
            UserDAOImpl userDAOImpl,
            UserMapper userMapper
    ){
        this.userDAOImpl = userDAOImpl;
        this.userMapper = userMapper;

    }

    public UserDTO findUser(int id){
        UserEntity foundUserEntity = userDAOImpl.findById(id);
        User user = userMapper.toUser(foundUserEntity);
        return userMapper.toUserDTO(user);
    }

    public List<UserDTO> findUsers(){
        List<UserEntity> foundUserEntities = userDAOImpl.findAll();
        return foundUserEntities
                .stream()
                .map(userMapper::toUser)
                .map(userMapper::toUserDTO)
                .toList();
    }

    @Transactional
    public UserDTO updateUser(int id, boolean active){
        UserEntity updatedUserEntity = userDAOImpl.update(id, active);
        User user = userMapper.toUser(updatedUserEntity);
        return userMapper.toUserDTO(user);
    }

    @Transactional
    public UserDTO saveUser(UserDTO userDTO){
        User user = userMapper.toUser(userDTO);
        UserEntity userEntity = userMapper.toUserEntity(user);
        UserEntity savedUserentity = userDAOImpl.save(userEntity);
        user = userMapper.toUser(savedUserentity);
        return userMapper.toUserDTO(user);
    }

    @Transactional
    public void deleteUser(int id){
        userDAOImpl.deleteById(id);
    }
}
