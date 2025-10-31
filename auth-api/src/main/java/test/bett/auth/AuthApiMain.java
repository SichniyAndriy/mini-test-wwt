package test.bett.auth;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApiMain {

    public static void main(String[] args) {
        SpringApplication.run(AuthApiMain.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
