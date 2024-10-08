package user.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Repository
@Transactional
public class UserMybatisDAO implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}
	
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}
	
	@Override
	public UserDTO getExistId(String id) {
		return sqlSession.selectOne("userSQL.getExistId", id);
	}
	
	@Override
	public void update(UserDTO userDTO) {	
		sqlSession.update("userSQL.update", userDTO);	
	}
	
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}
}
