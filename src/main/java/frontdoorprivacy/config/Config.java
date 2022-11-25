package frontdoorprivacy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    private static String  path = "C:\\frontdoor";
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") .allowedOrigins("http://localhost:3000");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/gen/**")
                .addResourceLocations("file:///" + path + "/");
    }

}