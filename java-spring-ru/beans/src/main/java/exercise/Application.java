package exercise;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
import java.time.LocalTime;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    public Daytime getDaytime() {
        var time = LocalTime.now();
        var startTime = LocalTime.parse("06:00:00");
        var endTime = LocalTime.parse("21:59:59");

        if (time.isAfter(startTime) && time.isBefore(endTime)) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
