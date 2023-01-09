package com.Student.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @Column(name = "studentId")
    private String id;
    private String name;
    private String section;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    private String role;

}
