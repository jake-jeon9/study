package test.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory {

	private static SqlSessionFactory factory = null;
	
	static {
		String resource = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlSession getSqlMapClientInstance() {
		SqlSession sqlSession = factory.openSession();
		
		return sqlSession;
	}
	
}


