package com.mab.springrestapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne doit être renseigné pas vide blanc")
    private String name;

    private Long age = 0L;

    private String location;

    @Email(message = "Vous devez saisir une adresse email valide !")
    private String email;

    @NotBlank(message = "Le département doit être renseigné pas videcblanc")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;



}
