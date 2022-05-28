package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.GenderEnum;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4823913062175271318L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private Date birthday ;
	private String gender;
	private Long cellphone ;
	private Long homephone ;
	private String addresshome;
	private String profession;
	private Long incomes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getCellphone() {
		return cellphone;
	}
	public void setCellphone(Long cellphone) {
		this.cellphone = cellphone;
	}
	public Long getHomephone() {
		return homephone;
	}
	public void setHomephone(Long homephone) {
		this.homephone = homephone;
	}
	public String getAddresshome() {
		return addresshome;
	}
	public void setAddresshome(String addresshome) {
		this.addresshome = addresshome;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Long getIncomes() {
		return incomes;
	}
	public void setIncomes(Long incomes) {
		this.incomes = incomes;
	}

	
}
