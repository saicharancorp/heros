package com.bezkoder.spring.jpa.h2.model.emp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;

    @Column(name = "no_of_childrens")
    private int noOfChildrens;
    private boolean spouse;

    @JsonManagedReference
    @OneToOne(cascade = { 
        		CascadeType.MERGE,
   	    		CascadeType.PERSIST,
   	    		CascadeType.REMOVE
    })
    @JoinColumn(name="address")
    private Address address;


    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", 
	    cascade = { 
	    		CascadeType.MERGE,
	    		CascadeType.PERSIST,
	    		CascadeType.REMOVE
    })
    private List<PhoneNumber> phoneNumbers;



    @ElementCollection
    @CollectionTable(name="hobbies", joinColumns = @JoinColumn(name="id"))
    @Column(name="hobby")
    private List<String> hobbies = new ArrayList<>();

}

