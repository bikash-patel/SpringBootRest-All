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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bikash.repository.product",
					   entityManagerFactoryRef ="mySqlEMF",
					   transactionManagerRef = "mySqlTrxMngr")
@Configuration
public class MySqlConfig {
	
	/*Why here we are going for manual DataSource configuration ?
	 Ans : DataSource coming from auto configuration is always pointing to 
	 single data base so we can bring that effect using manual setup*/
	
	@ConfigurationProperties(prefix = "mysql.datasource")
	@Bean
	 DataSource createMySqlData()
	{
	//return DataSource (Internally use HikariCP if we add spring-data-jpa starter)
		return DataSourceBuilder.create().build();
	}
	
	@Bean("mySqlEMF")
	 LocalContainerEntityManagerFactoryBean createMySqlEntityManagerFactoryBean(
															EntityManagerFactoryBuilder builder)
							//Here EntityManagerFactoryBuilder is AutoConfiguration object
	{
		//Map object having hibernate properties
		Map<String,Object> props=new HashMap<String,Object>();
		props.put("hibernate.hbm2ddl.auto","update");
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		
		
		//Create and return LocalContainerEntityManagerFactoryBean class object
		//which makes EntityManagerFactory as spring bean 
		return builder.dataSource(createMySqlData()) //DataSource
									.packages("com.bikash.entity.product") //Model class package
									.properties(props)  //hibernate properties
									.build();
	}

    @Bean("mySqlTrxMngr")
    PlatformTransactionManager createMySqlTransactionManager(@Qualifier("mySqlEMF")
    EntityManagerFactory factory)  
											//Qualifier to make container not to use auto 
											//configuration provided EntityManagerFactory object
											//and to use our EntityManagerFactory object
																									
	{
		return new JpaTransactionManager(factory);
		
	}
}
