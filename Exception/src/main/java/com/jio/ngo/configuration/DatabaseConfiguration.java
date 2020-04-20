<<<<<<< HEAD
package com.jio.ngo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Srinivas Chary
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "databaseEntityManager", 
						transactionManagerRef = "databaseTransactionManager", 
						basePackages = {"com.jio.ngo.exception.repository",
								"com.jio.ngo.exception.dao"})
@Slf4j
public class DatabaseConfiguration 
{
	    @Autowired
	    private Environment environment;
	    
	    @Value("${spring.primary.driver-class-name}") String driverClassName;
	    @Value("${spring.primary.url}") String url;
	    @Value("${spring.primary.username}") String username;
	    @Value("${spring.primary.password}") String password;
	    
	    @Bean(name="primaryJdbcTemplate")
	    public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource)
	    {
	        return new JdbcTemplate(dataSource);
	    }
	    
	    @Bean(name = "primaryDataSource")
	    public DataSource primaryDataSource() 
	    {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	    
	    @Bean(name="databaseEntityManager")
	    public LocalContainerEntityManagerFactoryBean databaseEntityManager() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    log.info("DatabaseConfiguration Before Calling Primary DataSource :");
	    entityManagerFactoryBean.setDataSource( primaryDataSource());
	    entityManagerFactoryBean.setPersistenceUnitName("primary");
	    log.info("DatabaseConfiguration Before Calling Primary DataSource :");
	    entityManagerFactoryBean.setPackagesToScan( new String[] {"com.jio.ngo.exception.model"});
	    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
	    entityManagerFactoryBean.setJpaProperties(additionalProperties());
	    log.info("databaseEntityManager() in DatabaseConfiguration with DataSource : " + entityManagerFactoryBean.toString());
	    return entityManagerFactoryBean;
	    
	    }
	    
	    @Primary
	    @Bean(name="databaseTransactionManager")
	    public PlatformTransactionManager databaseTransactionManager()
	    {
	    	JpaTransactionManager transactionManager= new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(databaseEntityManager().getObject());
	        return transactionManager;
	    }
	    
	    private HibernateJpaVendorAdapter vendorAdaptor() 
	    {
	         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	         vendorAdapter.setShowSql(true);
	         return vendorAdapter;
	    }
	    
	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	    }
	   
	    Properties additionalProperties() 
	    {
    	 Properties properties = new Properties();
    	 properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
    	 properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    	 properties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));
    	 return properties;
	    }

}
=======
package com.jio.ngo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Srinivas Chary
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "databaseEntityManager", 
						transactionManagerRef = "databaseTransactionManager", 
						basePackages = {"com.jio.ngo.exception.repository",
								"com.jio.ngo.exception.dao"})
@Slf4j
public class DatabaseConfiguration 
{
	    @Autowired
	    private Environment environment;
	    
	    @Value("${spring.primary.driver-class-name}") String driverClassName;
	    @Value("${spring.primary.url}") String url;
	    @Value("${spring.primary.username}") String username;
	    @Value("${spring.primary.password}") String password;
	    
	    @Bean(name="primaryJdbcTemplate")
	    public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource)
	    {
	        return new JdbcTemplate(dataSource);
	    }
	    
	    @Bean(name = "primaryDataSource")
	    public DataSource primaryDataSource() 
	    {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	    
	    @Bean(name="databaseEntityManager")
	    public LocalContainerEntityManagerFactoryBean databaseEntityManager() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    log.info("DatabaseConfiguration Before Calling Primary DataSource :");
	    entityManagerFactoryBean.setDataSource( primaryDataSource());
	    entityManagerFactoryBean.setPersistenceUnitName("primary");
	    log.info("DatabaseConfiguration Before Calling Primary DataSource :");
	    entityManagerFactoryBean.setPackagesToScan( new String[] {"com.jio.ngo.exception.model"});
	    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
	    entityManagerFactoryBean.setJpaProperties(additionalProperties());
	    log.info("databaseEntityManager() in DatabaseConfiguration with DataSource : " + entityManagerFactoryBean.toString());
	    return entityManagerFactoryBean;
	    
	    }
	    
	    @Primary
	    @Bean(name="databaseTransactionManager")
	    public PlatformTransactionManager databaseTransactionManager()
	    {
	    	JpaTransactionManager transactionManager= new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(databaseEntityManager().getObject());
	        return transactionManager;
	    }
	    
	    private HibernateJpaVendorAdapter vendorAdaptor() 
	    {
	         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	         vendorAdapter.setShowSql(true);
	         return vendorAdapter;
	    }
	    
	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	    }
	   
	    Properties additionalProperties() 
	    {
    	 Properties properties = new Properties();
    	 properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
    	 properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    	 properties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));
    	 return properties;
	    }

}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
