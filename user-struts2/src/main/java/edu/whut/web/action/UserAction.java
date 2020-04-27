package edu.whut.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.whut.web.bean.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.HaveExistException;
import edu.whut.web.exception.PasswordMatchException;
import edu.whut.web.util.MD5;

public class UserAction extends ActionSupport implements ModelDriven<User>
{
	private User user = new User();
	
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String deleteUser() throws BaseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idStr = request.getParameter("id");
		if(idStr!=null){
			user.setId(Integer.parseInt(idStr));
		}
		user.delete(user);
		return SUCCESS;
	}

	public String registerUser() throws BaseException {
		if(!user.getPassword().equals(user.getPassword2()))
			throw new PasswordMatchException();
		if (user.findByName(user.getName()) != null) {
			throw new HaveExistException(user.getName());
		}

		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		user.insert(user);
		return SUCCESS;
	}
	public void validateRegisterUser(){
		if(!user.getPassword().equals(user.getPassword2()))
			addFieldError("user","密码不匹配！");
	}

	public String updateUser() throws BaseException {
		user.update(user);
		return SUCCESS;
	}

	public String showAllUser() throws BaseException {
		User user = new User();
		List<User> users = user.findAllUsers();
		ActionContext.getContext().put("users", users);
		return SUCCESS;
	}

	public String showUser() throws BaseException {
		User userShow = user.findById(user.getId());
		ActionContext.getContext().getSession().put("editUser", userShow);
		return INPUT;
	}
	@Override
	public User getModel() {
		return user; 
	}
}