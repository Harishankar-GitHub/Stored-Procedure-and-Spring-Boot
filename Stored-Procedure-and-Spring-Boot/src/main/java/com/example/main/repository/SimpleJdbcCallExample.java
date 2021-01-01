package com.example.main.repository;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.example.main.utils.Constants;

@Repository
public class SimpleJdbcCallExample
{
	@Autowired
	private Environment env;
	
	public String callStoredProcedure(String inParam)
	{
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.dataSource())
				.withCatalogName(Constants.PACKAGE_NAME)		// If SP is inside a Package, then Package name must be given here. 
				.withProcedureName(Constants.INOUT_SP_WITHOUT_PKG_NAME);
		
		SqlParameterSource inParameters = new MapSqlParameterSource()
				.addValue("inParam1", inParam);
		
		Map<String, Object> storedProcedureResult = simpleJdbcCall.execute(inParameters);
		String result = (String) storedProcedureResult.get("OUTPARAM1");	// Out Parameter works only when given in Upper Case.
		return result;
	}
	
//	@Bean
	// @Bean can be used to inject this DataSource bean in some other place.
	// In this case, dataSource() method is called in this class itself. So, @Bean is not mandatory.
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		
		return dataSource;
	}
}
