package es.flaviojmend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.DataInputStream;
import java.io.IOException;

import static java.lang.Thread.sleep;

@SpringBootApplication
@EnableMongoRepositories("es.flaviojmend.persistence.repo")
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run() {
    }
}
