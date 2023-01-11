/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.student;

import java.util.List;
import net.codejava.CodeTraining.responseTemplate.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author iqbal
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public ResponseTemplate<List<Student>> getStrudents() {
        return studentService.getStrudents();
    }
    
    @PostMapping
    public ResponseTemplate<Student> registerNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }
    
    @DeleteMapping(path = "{studentId}")
    public ResponseTemplate<?> deleteStudent(@PathVariable("studentId") Long studentId) {
        return studentService.deleteStudent(studentId);
    }
    
    @PutMapping(path = "{studentId}")
    public ResponseTemplate<Student> updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }
    
}
