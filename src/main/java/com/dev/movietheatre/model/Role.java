package com.dev.movietheatre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    @Column(nullable = false, unique = true)
    private Roles roleName;

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{"
                + "id=" + id
                + ", roleName=" + roleName
                + '}';
    }

}
