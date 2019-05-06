package io.github.oldborn.pet.springtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCouchbaseRepositories
public class SpringTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTodoApplication.class, args);
    }

}
