package com.jio.ngo.relationship.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users_contact")
@Data
public class UsersContact 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private Integer phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "id")
	private UserRelationship userRelationship;

}
