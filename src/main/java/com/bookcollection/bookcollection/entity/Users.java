package com.bookcollection.bookcollection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 100, unique = true)
    private String userName;

   @Column(nullable = false, unique = true, length = 100)
    private String email;

   @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "user_rol", nullable = false, length = 50)
    private String userRol;

    @ManyToMany
    @JoinTable(
            name = "user_rol",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false)
    private Boolean active = true;
    @Column(nullable = false)
    private LocalDateTime registration_date = LocalDateTime.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Collection> collections = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserComment> userComments = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new HashSet<>();
}
