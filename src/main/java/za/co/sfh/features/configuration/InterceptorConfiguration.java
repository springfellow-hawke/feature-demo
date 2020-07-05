package za.co.sfh.features.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import za.co.sfh.features.interceptors.InterceptorDemo;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

     private InterceptorDemo interceptorDemo = new InterceptorDemo();

     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(interceptorDemo);
     }
}
