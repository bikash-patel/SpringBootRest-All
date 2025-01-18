package com.bikash.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bikash.repository.offeres",
					   entityManagerFactoryRef ="oracleTMF",
					   transactionManagerRef = "oracleTrxMngr")
public class OracleConfig {
	
	/*Why here we are going for manual DataSource configuration ?
	 Ans : DataSource coming from auto configuration is always pointing to 
	 single data base so we can bring that effect using manual setup*/
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "oracle.datasource")
	DataSource createOracleDataSource()
	{
	//return DataSource (Internally use HikariCP if we add spring-data-jpa starter)
		return DataSourceBuilder.create().build(); 
	}
	
	@Bean("oracleTMF")
	@Primary
	LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
	{
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl.auto","update");  //HIbernate properties
		properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		
		//Create & Return LocalContainerEntityManagerFactoryBean class object
		//which makes EntityManagerFactory as spring bean 
		return builder.dataSource(createOracleDataSource())
				.packages("com.bikash.entity.offeres")
				.properties(properties)
				.build();
	}
	@Bean("oracleTrxMngr")
	@Primary
	//Here primary to  make our container to use our TranscationManager not which coming from 
		//auto conguration TranscationManager 
	PlatformTransactionManager createMySqlTransactionManager(@Qualifier("oracleTMF") EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}
}
