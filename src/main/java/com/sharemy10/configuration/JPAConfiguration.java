package com.sharemy10.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.sharemy10.repository"})
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource((javax.sql.DataSource) dataSource());
		em.setPersistenceUnitName("persistenceunit");
		em.setPackagesToScan("com.sharemy10.domain");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties jpaProperties = hibernateProperties();
		em.setJpaProperties(jpaProperties);
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://ec2-34-198-243-120.compute-1.amazonaws.com:5432/d344lt5sslie7b?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
		dataSource.setUsername("zqnzetavjepfyg");
		dataSource.setPassword("d0ca876a20dff5113ab0686390f6b7d862d9d6e657fb584b211cec9f5737d16e");
		return (DataSource) dataSource;
	}
	
	Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");            
		return properties;
	}
}
