package com.hongtayvy.demo.repository;

import com.hongtayvy.demo.exception.DemoNotFoundException;
import com.hongtayvy.demo.repository.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<UserEntity> findAll(){
        TypedQuery<UserEntity> query = entityManager.createQuery("from UserEntity", UserEntity.class);
        return query.getResultList();
    }

    @Override
    public UserEntity findById(int id) {
        TypedQuery<UserEntity> query = entityManager.createQuery("from UserEntity where id=:id", UserEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public UserEntity update(int id, boolean active) {
        UserEntity foundUserEntity = entityManager.find(UserEntity.class, id);
        foundUserEntity.setActive(active);
        return entityManager.merge(foundUserEntity);
    }
    @Override
    public UserEntity save(UserEntity userEntity) {
        return entityManager.merge(userEntity);
    }

    @Override
    public void deleteById(int id) {
        UserEntity foundUserEntity = entityManager.find(UserEntity.class, id);
        entityManager.remove(foundUserEntity);
    }
}
