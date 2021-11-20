package com.reto1.repository.crud;

import com.reto1.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexander Sánchez Osorio
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
