package <%= packageName %>;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class <%= pascalCase(projectName) %>Application {

    public static void main(String[] args) {
        SpringApplication.run(<%= pascalCase(projectName) %>Application.class, args);
    }
}
