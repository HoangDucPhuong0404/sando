package com.cg.team_project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registers")
@Entity
@Accessors(chain = true)
public class Register extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "full_name")
    private String fullName;

//    @Column(name = "mobile")
    private String phone;

//    @Column(name = "email")
    private String email;

//    @Column(name = "user_name")
    private String userName;

//    @Column(name = "password")
    private String passWord;

    @OneToMany(mappedBy = "user")
    List<Order> orders;
}
