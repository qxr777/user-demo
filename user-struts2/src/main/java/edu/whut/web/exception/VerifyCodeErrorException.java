package edu.whut.web.exception;

public class VerifyCodeErrorException extends BaseException {

	/**
	 * ͼ����֤�����ʱ�׳��쳣
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public VerifyCodeErrorException(){
		super.message = VERIFY_CODE_ERROR;
	}
	
	public static final String VERIFY_CODE_ERROR = "ͼ����֤�����";

	
}
