package vn.iostar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor())
                .addPathPatterns("/user/**", "/admin/**")
                .excludePathPatterns("/login", "/register", "/user/activate.htm", "/user/forgot-password.htm");
    }
}
