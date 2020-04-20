package com.Course.RegisterationProgram.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;


@JsonIgnoreProperties//(ignoreUnknown=true,value= {"name","contact"}) -> these prop will not be part of json response
@ApiModel(description = "User Details") 
@Entity
@Table
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters") // implementing validation
	private String name;
	private String contact;
	
	/*@JsonIgnoreProperties
	private String selfUrl;*/
	
	@Past
	@JsonIgnoreProperties
	//@DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSZ", iso = ISO.DATE_TIME)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy'T'HH:mm:ss.SSSZ")
	@ApiModelProperty(notes = "Birth Date should be in the past") // for swagger documentation
	private LocalDateTime dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/*public String getSelfUrl() {
		return selfUrl;
	}
	public void setSelfUrl(String location) {
		this.selfUrl = location;
	}*/
	public User(Integer id, String name, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	
	
}