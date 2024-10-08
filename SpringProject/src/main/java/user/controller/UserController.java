package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	 
	@RequestMapping(value="user/writeForm", method = RequestMethod.GET)//value=>요청url
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@ResponseBody
	@RequestMapping(value="user/idCheck", method = RequestMethod.POST)
	public String idCheck(@RequestParam("id") String id) {
		System.out.println(id);
		int count = userDAO.idCheck(id);	
		return count+"";
	}
}
