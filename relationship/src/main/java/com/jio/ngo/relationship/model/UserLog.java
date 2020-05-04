package com.jio.ngo.relationship.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_log")
@Data
public class UserLog implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private Long logId;
	
	private String log;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id" ,referencedColumnName = "user_id")
	private UserRelationship userRelationship;
	
	/**@Column(name = "user_id")
	private Integer userId;**/
	
}
