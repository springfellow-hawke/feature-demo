package za.co.sfh.features.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import za.co.sfh.features.configuration.YAMLConfig;
import za.co.sfh.features.exceptions.InvalidHeaderException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@Slf4j
public class HeaderFilter extends OncePerRequestFilter {

     private List<String> validHeaderNamesList;

     public HeaderFilter(YAMLConfig yamlConfig) {
          this.validHeaderNamesList = yamlConfig.getSupportedHeaders().getHeaderNames();
     }

     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          try {
               filterUnwantedHeaders(request);
               super.doFilter(request, response, filterChain);
          } catch (InvalidHeaderException iv) {
               response.setStatus(HttpStatus.BAD_REQUEST.value());
               response.setContentType("application/text");
               PrintWriter writer = response.getWriter();
               writer.print(iv.getMessage());
               writer.flush();
               return;
          }
     }

     void filterUnwantedHeaders(HttpServletRequest request) {

          Enumeration<String> headerNames = request.getHeaderNames();

          while (headerNames.hasMoreElements()) {
               String headerName = headerNames.nextElement();
               if (!validHeaderNamesList.contains(headerName)) {
                    log.info("Received invalid header : {} ", headerName);
                    throw new InvalidHeaderException("Invalid header received :" + headerName);
               }
          }
     }

}
