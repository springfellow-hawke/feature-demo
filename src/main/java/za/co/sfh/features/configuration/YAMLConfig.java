package za.co.sfh.features.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "valid", ignoreUnknownFields = false)
public class YAMLConfig {

     private final SupportedHeaders supportedHeaders = new SupportedHeaders();

     public SupportedHeaders getSupportedHeaders() {
          return supportedHeaders;
     }

     /**
      * Class containing the configured list of valid headers
      */
     public static class SupportedHeaders {
          private List<String> headersNames = new ArrayList<>();

          public void setHeaderNames(List<String> headersNames) {
               this.headersNames = headersNames;
          }

          public List<String> getHeaderNames() {
               return headersNames;
          }
     }

}