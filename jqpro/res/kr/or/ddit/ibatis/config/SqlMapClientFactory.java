package kr.or.ddit.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	static SqlMapClient smc;
	static {
		try {
			// 1-1. xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8");//설정파일의 인코딩 설정
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml"); //.....오라클 드라이버 정보가 들어있는 걸 읽는다는 거야....
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성  .......config파일을 받는 객체를 만들어준느 거야
			 smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		}catch(Exception ex) {
			
		}
	}
	
	public static SqlMapClient getInstance() {
		return smc;
	}
}
