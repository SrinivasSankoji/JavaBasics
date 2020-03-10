package com.trigyn.configuration;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "yemenEntityManager", 
						transactionManagerRef = "yemenTransactionManager", 
						basePackages = {})
@Slf4j
public class DatabaseConfiguration 
{
	 @Autowired
	 private Environment environment;
	 
	@Value("${spring.datasource.driver-class-name}") String driverClassName;
    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;
    
    @Bean(name="yemenJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("yemenDataSource") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "yemenDataSource")
    public DataSource primaryDataSource() 
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    @Bean(name="yemenEntityManager")
    public LocalContainerEntityManagerFactoryBean yemenEntityManager() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    log.info("DatabaseConfiguration Before Calling Primary DataSource :");
    entityManagerFactoryBean.setDataSource( primaryDataSource());
    entityManagerFactoryBean.setPersistenceUnitName("yemen");
    entityManagerFactoryBean.setPackagesToScan();
    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
    entityManagerFactoryBean.setJpaProperties(additionalProperties());
    log.info("databaseEntityManager() in DatabaseConfiguration with DataSource : " + entityManagerFactoryBean.toString());
    return entityManagerFactoryBean;
    
    }
    
    @Primary
    @Bean(name="yemenTransactionManager")
    public PlatformTransactionManager yemenTransactionManager()
    {
    	JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(yemenEntityManager().getObject());
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
	 properties.setProperty("spring.jpa.hibernate.ddl-auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
	 properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
	 return properties;
    }
    
}
