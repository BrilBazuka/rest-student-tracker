package by.bryl.reststudenttracker;

import by.bryl.reststudenttracker.util.StringTrim;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class RestStudentTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestStudentTrackerApplication.class, args);
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
