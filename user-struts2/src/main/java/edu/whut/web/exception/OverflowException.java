package edu.whut.web.exception;

public class OverflowException extends BaseException {

	/**
	 * �û���Ŀ������֯�������ʱ�׳��쳣
	 */
	private static final long serialVersionUID = 6652098398262607292L;
	
	
	public OverflowException(String userName){
		super.message = userName + USER_OVERFLOW;
	}
	
	public static String USER_OVERFLOW = "�Ѿ����ޣ���";
	
}
