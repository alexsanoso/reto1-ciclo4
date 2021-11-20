package com.reto1.service;

import com.reto1.model.User;
import com.reto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@Service
public class UserApi {

    /**
     * Atributo autowired para usuario
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Metodo para obtener todos los usuarios
     * @return userRepository
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     * Guardar un usuario en la base de datos
     * @param user
     * @return user Devuelve el usuario actualizado.
     */
    public User save(User user){

        List<User> users = userRepository.getAll();

        if (users.size() == 0){
            return userRepository.save(user);
        }else if (getByEmail(user.getEmail()) == false) {
            return userRepository.save(user);
        }
        return user;
    }

    /**
     * Validar si un usuario existe en la base de datos
     * @param email
     * @return flag Devuelve el valor booleano actualizado
     */
    public boolean getByEmail(String email){

        List<User> users = userRepository.getAll();
        boolean flag = false;

        for (User user: users) {
            if(email.equals(user.getEmail())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Autentificar si un usuario existe en la base de datos
     * @param email
     * @param pass
     * @return noExiste Devuelve el valor indefinido cuando el usuario no existe en la base de datos
     */
    public User getByEmailAndPass(String email, String pass){
        List<User> users = userRepository.getAll();
        User noExiste = new User(null, email, pass, "NO DEFINIDO");

        for (User user: users) {
            if(email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return noExiste;
    }
}