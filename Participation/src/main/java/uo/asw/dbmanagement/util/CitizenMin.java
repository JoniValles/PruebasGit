package uo.asw.dbmanagement.util;

import uo.asw.dbmanagement.model.Citizen;
import uo.asw.participants.util.DateUtil;

import java.util.Date;

public class CitizenMin {

	private String firstName;
	private String lastName;
	private int age;
	private Long id;
	private String email;

	public CitizenMin(String firstName, String lastName, Date fechaNacimiento, Long id, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = DateUtil.getYears(fechaNacimiento);
		this.id = id;
		this.email = email;
	}

	public CitizenMin(Citizen c) {
		this.firstName = c.getName();
		this.lastName = c.getSurname();
		this.age = DateUtil.getYears(c.getBornDate());
		this.id = c.getId();
		this.email = c.getEmail();
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CitizenMin [firstName=" + firstName + ", lastName=" + lastName + ", edad=" + age + ", id=" + id
				+ ", email=" + email + "]";
	}

}
