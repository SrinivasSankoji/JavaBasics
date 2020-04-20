<<<<<<< HEAD
package com.jio.ngo.exception.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder(toBuilder=true)
public class ExceptionCountDashBoaard implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private long closedException;
	private long activeException;
	private long overDueException;
	private long dueinNext7Days;
	private long dueinNext15Days;
	private long dueinNext30Days;
	private long openSince2Years;
	private long openSince1Year;
	private long openSince6Months;
	
	private int complianceScore;

}
=======
package com.jio.ngo.exception.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder(toBuilder=true)
public class ExceptionCountDashBoaard implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private long closedException;
	private long activeException;
	private long overDueException;
	private long dueinNext7Days;
	private long dueinNext15Days;
	private long dueinNext30Days;
	private long openSince2Years;
	private long openSince1Year;
	private long openSince6Months;
	
	private int complianceScore;

}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
