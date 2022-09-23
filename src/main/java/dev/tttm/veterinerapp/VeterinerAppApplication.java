package dev.tttm.veterinerapp;

import dev.tttm.veterinerapp.api.entity.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinerAppApplication {
// git
    public static void main(String[] args) {
        SpringApplication.run(VeterinerAppApplication.class, args);
    }

    @Bean
    public Info info(){
        return new Info();
    }
}
