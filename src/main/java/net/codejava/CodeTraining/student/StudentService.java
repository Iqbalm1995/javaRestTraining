/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import net.codejava.CodeTraining.responseTemplate.ResponseService;
import net.codejava.CodeTraining.responseTemplate.ResponseTemplate;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iqbal
 */
@Service
public class StudentService {
    
    private final StudentRepository studentRepository;
    private final ResponseService responseService;

    @Autowired
    public StudentService(StudentRepository studentRepository, ResponseService responseService) {
        this.studentRepository = studentRepository;
        this.responseService = responseService;
    }
    
    public ResponseTemplate<List<Student>> getStrudents() {
        return responseService.apiSuccess(studentRepository.findAll()) ;
    }
    
    public ResponseTemplate<Student> addNewStudent(Student student) {
        
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email is already taken");
        }
        
        studentRepository.save(student);
        
        Student studentAvail = studentRepository.findById(student.getId())
                .orElseThrow(() -> new IllegalStateException(
                "student does not exists"));
        
        return responseService.apiSuccess(studentAvail);
        
    }

    public ResponseTemplate<?> deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
        
        return responseService.apiSuccess(null);
    }

    @Transactional
    public ResponseTemplate<Student> updateStudent(Long studentId, Student student) {
        
        Student studentAvail = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exists"));
        
        if(student.getName() != null && student.getName().length() > 0 && !Objects.equals(studentAvail.getName(), student.getName())) {
            studentAvail.setName(student.getName());
        }
        
        if(student.getEmail() != null && student.getEmail().length() > 0 && !Objects.equals(studentAvail.getEmail(), student.getEmail())) {
            
            Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email is already taken");
            }
            studentAvail.setEmail(student.getEmail());
        }
        
        studentRepository.save(studentAvail);
        
        return responseService.apiSuccess(studentAvail);
    }
    
}
