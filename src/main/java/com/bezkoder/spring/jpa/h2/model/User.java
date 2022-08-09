package com.bezkoder.spring.jpa.h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
@Entity
public class User {
@Id	
@GeneratedValue
private int id;
private String name;
private String address;
}
