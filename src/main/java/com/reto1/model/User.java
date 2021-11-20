package com.reto1.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name ="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class User implements Serializable {

    /**
     * Atributo id para usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * atributo para correo de usuario
     */
    @Column(name = "email", unique = true,length = 50)
    private String email;

    /**
     * atributo para contraseña de usuario
     */
    @Column(name = "password", length = 50, nullable = false)
    private String password;

    /**
     * atributo para nombre de usuario
     */
    @Column(name = "name", length = 80, nullable = false)
    private String name;
}
