package user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;
import user.dao.UserDAO;

/*
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); //insert, update, delete
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=?, pwd=? where id=?";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getPwd(), userDTO.getId());
		
	}

	@Override
	public void delete(UserDTO userDTO) {
		String sql = "delete from usertable where id=?";
		jdbcTemplate.update(sql, userDTO.getId());
	}
	
}
*/

/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); //insert, update, delete
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=?, pwd=? where id=?";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getPwd(), userDTO.getId());
		
	}

	@Override
	public void delete(UserDTO userDTO) {
		String sql = "delete from usertable where id=?";
		getJdbcTemplate().update(sql, userDTO.getId());
	}
	
}
*/

//@Component
@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql = "insert into usertable values(:name, :id, :pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	@Override
	public UserDTO getExistId(String id) {
		String sql = "select * from usertable where id = ?";
		try {
		return getJdbcTemplate().queryForObject(
				sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class), 
				id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=?, pwd=? where id=?";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getPwd(), userDTO.getId());
		
	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=?";
		getJdbcTemplate().update(sql, id);
	}
	
}
