package user.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.dao.UserDAO;

@Repository 
public class UserMybatisDAO implements UserDAO {
    @Autowired
    private SqlSession sqlSession;  // MyBatis SQL 세션 주입

	@Override
	public int idCheck(String id) {
		int count = sqlSession.selectOne("userSQL.idCheck", id);
		System.out.println("count = " + count);
		return count;
	}

}
