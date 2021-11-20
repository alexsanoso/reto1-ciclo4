package com.reto1.web;

import com.reto1.model.User;
import com.reto1.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/User/")

public class UserWeb {

    /**
     * atributo autowired machine
     */
    @Autowired
    private UserApi userApi;

    /**
     * Método para obtener a todos los usuarios de la base de datos
     * @return getAll retorna a todos los usuarios
     */
    @GetMapping("all")
    public List<User> getUsers() {
        return userApi.getAll();
    }

    /**
     * Método para guardar un usuario en base de datos
     * @param user
     * @return user Retorna al usuario actualizado
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userApi.save(user);
    }

    /**
     * Obtiene al usuario por su correo.
     * @param email
     * @return Boolean Retorna un valor booleano, si existe o no el correo.
     */
    @GetMapping("{email}")
    public boolean getEmail(@PathVariable("email") String email){
        return userApi.getByEmail(email);
    }

    /**
     * Obtiene una respuesta con su email y pass, de si existe en la base de datos
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User userEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userApi.getByEmailAndPass(email, pass);
    }
}
