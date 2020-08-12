package by.bryl.reststudenttracker;

import by.bryl.reststudenttracker.util.StringTrim;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RestStudentTrackerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RestStudentTrackerApplication.class, args);

        //for throwing exception if handler not found
        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }

    // Method that helps to trim leading and trailing whitespaces from JSON string
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new StringTrim());
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }


}
