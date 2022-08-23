package com.emplyee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee 
{

		@Id 
		@GeneratedValue (strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="first_name")
		private String fistname;
		
		@Column(name="last_name")
		private String Lastname;
		
		
		public Employee(long id, String fistname, String lastname) {
			super();
			this.id = id;
			this.fistname = fistname;
			Lastname = lastname;
		}


		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getFistname() {
			return fistname;
		}


		public void setFistname(String fistname) {
			this.fistname = fistname;
		}


		public String getLastname() {
			return Lastname;
		}


		public void setLastname(String lastname) {
			Lastname = lastname;
		}
		
		
		

}
