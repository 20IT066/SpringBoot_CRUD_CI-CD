package in.ac.charusat.studentmgmtsystem;

import in.ac.charusat.studentmgmtsystem.model.User;
import in.ac.charusat.studentmgmtsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentMgmtSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner addAdmin(UserRepository repo) {
        return args -> {

            repo.save(new User(
                    1L, "admin", new BCryptPasswordEncoder().encode("admin"), null, null, true, "null", 123456, null
            ));
        };
    }

}
