package dev.battino.backend.domains.user;

import org.hibernate.validator.constraints.Length;

import dev.battino.backend.domains.roles.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Length(min = 3, max = 25)
    @Column(name = "user_name")
    private String name;

    @NotNull
    @Length(min = 8, max = 60)
    @Column(name = "user_password")
    private String password;

    @ManyToOne
    @NotNull
    private Roles role;
}