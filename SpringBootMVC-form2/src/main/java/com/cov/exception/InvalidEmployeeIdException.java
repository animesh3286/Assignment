package com.cov.exception;

import com.cov.beans.Employee;

public class InvalidEmployeeIdException extends Exception{
	public InvalidEmployeeIdException() {
		super();
	}
	public InvalidEmployeeIdException(String message, Throwable cause)
	{
		super(message, cause);
	}
	public InvalidEmployeeIdException(String message)
	{
		super(message);
	}
	public InvalidEmployeeIdException(Throwable cause)
	{
		super(cause);
	}
	public Employee update(Employee employee) throws InvalidEmployeeIdException{
		return null;
	}
	public Employee delete(int id) throws InvalidEmployeeIdException{
		return null;
	}
}
