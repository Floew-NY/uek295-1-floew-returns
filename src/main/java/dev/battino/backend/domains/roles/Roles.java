package dev.battino.backend.domains.roles;


import dev.battino.backend.domains.authority.Authorities;
import dev.battino.backend.domains.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import java.util.Set;

@Entity
@Getter
@Setter
public class Roles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roles_id")
    private Long id;

    @JoinTable(name = "roles_authorities"
            , joinColumns = @JoinColumn(name = "roles_id")
            , inverseJoinColumns = @JoinColumn(name = "authorities_id"))
    @ManyToMany
    private Set<Authorities> authorities;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}