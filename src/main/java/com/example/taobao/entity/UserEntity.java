package com.example.taobao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
