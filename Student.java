package com.te.StudentManagemnetSystem.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_info")
public class Student implements Serializable {
	
	@Id
	@Column(name="RollNo")
	private int rollNo;
	@Column(name="Name")
	private String name;
	@Column(name="PhoneNo")
	private long phNo;
	@Column(name="DateOfBirth")
	private String dob;
	
	public Student() {
		
	}

	@Override
	public String toString() {
		return "Roll No: " + rollNo + "\nName: " + name + "\nPhone No: " + phNo + "\nDate of Birth: " + dob+"\n------------------"  ;
	}
	
	
    
}
