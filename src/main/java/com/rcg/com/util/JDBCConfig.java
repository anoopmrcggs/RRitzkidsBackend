package com.rcg.com.util;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JDBCConfig 
{

private String dataBaseUserName =Crypt.decrypt(System.getenv("DB_USER_NAME"));

private String dataBasePass =Crypt.decrypt(System.getenv("DB_USER_PASS"));

private String dataBaseUrl =Crypt.decrypt(System.getenv("DB_URL"));

	@Bean
	public DataSource dataSource() 
	{
		BasicDataSource ds = new BasicDataSource();
        ds.setUsername(dataBaseUserName);
        ds.setPassword(dataBasePass);
        ds.setUrl(dataBaseUrl);
        return ds;

	}

}
