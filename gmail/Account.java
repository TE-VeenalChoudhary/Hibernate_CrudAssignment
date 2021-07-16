package com.te.gmail;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table
public class Account {
	
	@Id
	private int user_id; 
	private String user_name; 
	private String password; 
	private String email;
	
	@Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<Inbox> inbox;

}
