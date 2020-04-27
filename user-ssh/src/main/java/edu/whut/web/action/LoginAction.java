package edu.whut.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.VerifyCodeErrorException;
import edu.whut.web.service.UserService;

public class LoginAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7385827956912567303L;
	//瀹氫箟灏佽璇锋眰鍙傛暟鐨剈sername鍜宲assword灞炴�
	private String name;
	private String password;
	private String random;
//	private String message;
	
	private UserService userService;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	//瀹氫箟澶勭悊鐢ㄦ埛璇锋眰鐨別xecute鏂规硶
	public String execute() throws BaseException
	{
		String randomInSession = (String)ActionContext.getContext().getSession().get("randomCode");

		if (!random.equals(randomInSession)) {
			throw new VerifyCodeErrorException();
		}
		userService.valid(name, password);
		ActionContext.getContext().getSession().put("user", this.getName());
		return SUCCESS;
	}
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}