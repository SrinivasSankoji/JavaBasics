package com.jio.ngo.relationship.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "User_Relationship")
public class UserRelationship implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "team_Name")
	private String teamName;
	
	@Column(name = "salary")
	private Integer salary;
	
	/**
	 * name and Referenced Column Name
	 * should be the Same as Parent Table.
	 * name Parent Table Primary Key
	 * referencedColumnName Foreign Key
	 * of Child Table which is Primary Key 
	 * in Parent Table
	 */
	/**@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<UserLog> userLogList;**/
	
	
	
	
}
