package com.example.mingyang.exception;

/**
 * ServiceException
 *
 * @author XuYang
 * @since 2024/6/26 14:17
 */
public class ServiceException extends RuntimeException {

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public static void cast(String message) {
		throw new ServiceException(message);
	}
}
