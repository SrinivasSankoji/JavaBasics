<<<<<<< HEAD
package com.jio.ngo.common;

import lombok.Data;
import lombok.ToString;
/**
 * @author Klicktosearch
 * JSON Response Format
 * For all the Services.
 */
@Data
@ToString
public class ResponseHeader 
{
	private String timestamp;
	private String message="SUCCESS";
	private Integer status=1;
	private String path;
	
}
=======
package com.jio.ngo.common;

import lombok.Data;
import lombok.ToString;
/**
 * @author Klicktosearch
 * JSON Response Format
 * For all the Services.
 */
@Data
@ToString
public class ResponseHeader 
{
	private String timestamp;
	private String message="SUCCESS";
	private Integer status=1;
	private String path;
	
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
