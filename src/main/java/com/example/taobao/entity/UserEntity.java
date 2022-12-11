package com.example.taobao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "`user`")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -1822337859927111804L;

    @Id
    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "password", length = 60)
    private String password;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

}
