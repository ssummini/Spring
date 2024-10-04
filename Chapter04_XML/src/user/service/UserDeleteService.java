package user.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);	
		
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();

		List<UserDTO> list = userDAO.getUserList();
	
        int sw = 0;
        
        for(UserDTO userDTO : list) {
        	if(userDTO.getId().equals(id)) {
        		sw = 1;
        		
        		userDAO.delete(userDTO);
        		System.out.println(userDTO.getName() + "님의 데이터를 삭제하였습니다.");
        		break;
        	}
        }
        
        if (sw == 0) {
            System.out.println("해당 이름이 존재하지 않습니다.");
        }
	}

}
