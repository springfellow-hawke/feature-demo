package za.co.sfh.features.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class InterceptorDemo extends HandlerInterceptorAdapter implements HandlerInterceptor {
     public InterceptorDemo() {
          super();
     }

     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          log.info("Doing pre-handle");

          return super.preHandle(request, response, handler);
     }

     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
          log.info("Doing post-handle");
          super.postHandle(request, response, handler, modelAndView);
     }

     @Override
     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
          log.info("Doing afterCompletion");
          super.afterCompletion(request, response, handler, ex);
     }
}