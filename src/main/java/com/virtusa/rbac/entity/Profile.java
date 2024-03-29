package com.virtusa.rbac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long profileId;
    String profileName;
    String profileDescription;
    /* many profiles can have one role*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ProfileRoleTable",
            joinColumns = @JoinColumn(name = "profileId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    List<Role> roles ;


}
