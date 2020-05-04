package com.jio.ngo.relationship.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Table(name = "users_contact")
@Data
public class UsersContact 
{
	
	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="userRelationship"))
	@Column(name = "contact_id", unique = true, nullable = false)
	private Long contactId;
	
	private Integer phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id",referencedColumnName = "user_id")
	private UserRelationship userRelationship;

}
