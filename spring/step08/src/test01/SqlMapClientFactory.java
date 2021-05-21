package test01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory {

	private static SqlSessionFactory factory= null;
	
	//static 초기화 : 한줄로 초기화 하기 힘들 때 쓰는 방법.
	//static 변수들 초기화 : xml 파일을 읽어와서 초기화 시킴
	static {
		String resource = "mybatis-config.xml";
		Reader reader;
		try {
			//아래 코드는 try-catch로 만 사용할 수 있어서 코드를 1줄에 완성할 수 없음.
			reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlMapClientInstance() {
		SqlSession sqlSession = factory.openSession();
		System.out.println("겟 함수에서 sqlSession 값은?"+sqlSession);
		System.out.println("겟 함수에서 factory.openSession() : "+factory.openSession());
		return sqlSession;
	}
	
}
