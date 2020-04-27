package edu.whut.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.whut.web.bean.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.NoUserException;
import edu.whut.web.exception.PasswordErrorException;
import edu.whut.web.exception.VerifyCodeErrorException;
import edu.whut.web.util.MD5;

public class LoginAction extends ActionSupport
{
	//定义封装请求参数的username和password属性
	private String name;
	private String password;
	private String random;
	private String message;
	
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
	//定义处理用户请求的execute方法
	public String execute() throws BaseException
	{
		String randomInSession = (String)ActionContext.getContext().getSession().get("randomCode");
		MD5 md5 = new MD5();

		if (!random.equals(randomInSession)) {
			throw new VerifyCodeErrorException();
		}
		User userInDB = new User();
		userInDB = userInDB.findByName(name);
		if (userInDB == null)
			throw new NoUserException();
		if (userInDB != null
				&& !userInDB.getPassword()
				.equals(md5.getMD5ofStr(password)))
			throw new PasswordErrorException();
		ActionContext.getContext().getSession().put("user", this.getName());
		return SUCCESS;
	}
}