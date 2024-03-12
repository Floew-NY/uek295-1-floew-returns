package dev.battino.backend.domains.user;


import org.hibernate.mapping.Set;
import org.hibernate.validator.constraints.Length;

import dev.battino.backend.domains.roles.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Length(min = 3, max = 20)
    private String name;
    
    @NotNull
    private String password;

    @ManyToOne
    @NotNull
    private Roles role;
}