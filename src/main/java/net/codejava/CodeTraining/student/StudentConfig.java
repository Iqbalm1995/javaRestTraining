/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.student;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author iqbal
 */
@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repo) {
        return args -> {
            Student iqbal = new Student(
                    "Iqbal",
                    "iqbalm1995@gmail.com",
                    LocalDate.of(1995, Month.NOVEMBER, 23)
            );
            
            Student alek = new Student(
                    "alex",
                    "alex2077@gmail.com",
                    LocalDate.of(1992, Month.DECEMBER, 10)
            );
            
            repo.saveAll(List.of(iqbal, alek));
        };
    }
}
