/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 10:58 AM
 * Project Name : student-service
 */

package az.pashabank.controller;

import az.pashabank.model.StudentEntity;
import az.pashabank.repository.StudentRepository;
import az.pashabank.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentEntity studentEntity) {
        return studentService.save(studentEntity);
    }

    @GetMapping("/all")
    public Iterable<StudentEntity> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping(path = "/{id}") // update etmek ucundur
    public Optional<StudentEntity> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping(path = "/all")
    public void deleteAll() {
        studentService.deleteAll();
    }
}