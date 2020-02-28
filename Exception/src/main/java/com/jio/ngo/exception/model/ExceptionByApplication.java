package com.jio.ngo.exception.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionByApplication implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String domainOwner;
	private String journey;
	private String productionOwner;
	private String riskOwner;
	private long lessThan3Month;
	private long threeTo6Month;
	private long sixTo12Month;
	private long twelveTo24Month;
	private long greaterThan24Month;
	private String expired_OverDue;
	private long lessThan7Days;
	private long sevenTo15Days;
	private long fifteenTo30Days;
	private long greaterThan30Days;
	
}
