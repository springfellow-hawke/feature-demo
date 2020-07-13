package za.co.sfh.features.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatasourceConfig {

     private final Logger log = LoggerFactory.getLogger(getClass());

     @Bean
     @Primary
     @ConfigurationProperties("spring.datasource")
     public DataSourceProperties dataSourceProperties() {
          return new DataSourceProperties();
     }

     @Bean
     public DataSource dataSource() throws SQLException {
          log.debug("Doing the datasource configuration setup");
          DataSourceProperties dataSourceProperties = dataSourceProperties();
          SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
          dataSource.setDriver(DriverManager.getDriver(dataSourceProperties.getUrl()));
          dataSource.setUrl(dataSourceProperties.getUrl());
          dataSource.setUsername(dataSourceProperties.getUsername());
          dataSource.setPassword(dataSourceProperties.getPassword());
          log.debug("Completed the datasource configuration setup");
          return dataSource;
     }
}