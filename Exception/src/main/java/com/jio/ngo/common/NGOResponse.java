<<<<<<< HEAD
package com.jio.ngo.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class NGOResponse implements Serializable
{
	private static final long serialVersionUID = 3683617477370152234L;
	
	private ResponseHeader responseHeader = new ResponseHeader();
	private Object responsePayload;
	
}
=======
package com.jio.ngo.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class NGOResponse implements Serializable
{
	private static final long serialVersionUID = 3683617477370152234L;
	
	private ResponseHeader responseHeader = new ResponseHeader();
	private Object responsePayload;
	
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
