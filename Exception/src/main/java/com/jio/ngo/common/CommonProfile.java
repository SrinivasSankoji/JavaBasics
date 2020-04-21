

package com.jio.ngo.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class CommonProfile {
	
	
	private String status;
	@Column
	private Date modifiedDt;
	@Column
	private Date createdDt;
	@Transient
	private String responseStatusMsg;
	

/*********************************************************Getter Setter************************************************/	
	
	
	
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Date getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	@Transient
	public String getResponseStatusMsg() {
		return responseStatusMsg;
	}
	public void setResponseStatusMsg(String responseStatusMsg) {
		this.responseStatusMsg = responseStatusMsg;
	}
	
	
	
}
