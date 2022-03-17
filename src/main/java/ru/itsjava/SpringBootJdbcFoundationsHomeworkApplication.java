package ru.itsjava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.services.AppService;


@SpringBootApplication
public class SpringBootJdbcFoundationsHomeworkApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsHomeworkApplication.class, args);
        context.getBean(AppService.class).start();

    }
}
