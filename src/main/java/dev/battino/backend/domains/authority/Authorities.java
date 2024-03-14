package dev.battino.backend.domains.authority;

import java.util.Set;

import dev.battino.backend.domains.roles.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "authorities_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "authority_name")
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<Roles> roles;
}