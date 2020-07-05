package za.co.sfh.features.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import za.co.sfh.features.filters.HeaderFilter;

import javax.servlet.Filter;
import java.util.Arrays;

@Configuration
public class FilterConfiguration {

     @Autowired
     private YAMLConfig yamlConfig;

     @Bean
     public Filter headerFilter() {
          return new HeaderFilter(yamlConfig);
     }

     @Bean
     public FilterRegistrationBean headerFilterRegistration() {

          FilterRegistrationBean result = new FilterRegistrationBean();
          result.setFilter(this.headerFilter());
          result.setUrlPatterns(Arrays.asList("/*"));
          result.setName("Header Filter");
          result.setOrder(Ordered.HIGHEST_PRECEDENCE);
          return result;
     }
}
