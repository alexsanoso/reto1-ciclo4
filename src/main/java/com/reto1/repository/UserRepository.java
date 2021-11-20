package com.reto1.repository;

import com.reto1.model.User;
import com.reto1.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class UserRepository {

    /**
     * atributo para user
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Método para obtener a todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Método para guardar un usuario
     * @param user
     * @return userCrudRepository.save(user)
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }
}
