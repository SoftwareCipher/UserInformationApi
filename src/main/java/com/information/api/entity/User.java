package com.information.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "url_image")
    private String urlImage;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private boolean status;
    @Column(name = "date")
    private LocalDateTime date;

}
