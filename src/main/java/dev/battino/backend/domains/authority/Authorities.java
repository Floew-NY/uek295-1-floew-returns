package dev.battino.backend.domains.authority;
import java.util.Set;

import dev.battino.backend.domains.roles.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authorities {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "authorities_id")
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<Roles> roles;
}
