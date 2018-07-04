package com.n26.api.exceptions;

import com.n26.api.utils.n26Utility;

public class InvalidEpochException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406653236989298331L;
	
	public InvalidEpochException(){
		super(n26Utility.InvalidTimeMessage);
	}

}
