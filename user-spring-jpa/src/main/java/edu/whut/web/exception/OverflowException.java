package edu.whut.web.exception;

public class OverflowException extends BaseException {

	/**
	 * 用户数目超过组织最大容量时抛出异常
	 */
	private static final long serialVersionUID = 6652098398262607292L;


	public OverflowException(String userName){
		super.message = userName + USER_OVERFLOW;
	}

	public static String USER_OVERFLOW = "已经超限！！";

}
