package com.bezkoder.spring.jpa.h2.model.emp;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String type;
    private String number;


    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="employee_id")
    private Employee employee;

}