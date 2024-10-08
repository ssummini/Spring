package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);	
		
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.getExistId(id);
		
		if(userDTO == null) {
			System.out.println("해당 아이디가 존재하지 않습니다.");
			return;
		}

		System.out.println("이름\t아이디\t비밀번호\t");
		System.out.println(userDTO);
		
		System.out.print("수정할 이름 입력: ");
		String name = scan.next();
		
		System.out.print("수정할 비밀번호 입력: ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		
		userDAO.update(userDTO);
		System.out.println(name + "님의 데이터를 수정하였습니다.");				
	}

}
