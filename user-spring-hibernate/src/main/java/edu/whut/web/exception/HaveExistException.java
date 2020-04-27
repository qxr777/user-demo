package edu.whut.web.exception;

public class HaveExistException extends BaseException {

	/**
	 * 用户名已经被用时抛出异常
	 */
	private static final long serialVersionUID = 6652098398262607292L;
	
	
	public HaveExistException(String userName){
		super.message = userName + USER_NAME_HASEXIST;
	}
	
	public static String USER_NAME_HASEXIST = "已经存在！！";
	
}
