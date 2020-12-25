package com.example.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedStoredProcedureQueries
({
	@NamedStoredProcedureQuery
	(
			name = "in_only_test", procedureName = "test_pkg.in_only_test",
			parameters =
		{
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
		}
	),
	@NamedStoredProcedureQuery
	(
			name = "in_and_out_test", procedureName = "test_pkg.in_and_out_test",
			parameters =
		{
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
		}
	)
})
public class Person
{
  @Id
  @GeneratedValue
  private int id;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;
  private String address;  
  
  public Person()
  {
	super();
  }
  
  	public Person(int id, String firstName, String lastName, String address) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
}



	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return String.format("Person [id=%s, firstName=%s, lastName=%s, address=%s]", id, firstName, lastName, address);
	} 
  
}
