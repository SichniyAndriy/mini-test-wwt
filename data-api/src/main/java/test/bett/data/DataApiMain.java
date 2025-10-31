package test.bett.data;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataApiMain {

    public static void main(String[] args) {
        SpringApplication.run(DataApiMain.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
