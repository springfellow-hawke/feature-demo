package za.co.sfh.features.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

     @Bean
     public ObjectMapper getObjectMapper() {
          ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
          JavaTimeModule module = new JavaTimeModule();
          objectMapper.registerModule(module);
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
          objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
          objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
          return objectMapper;
     }
}
