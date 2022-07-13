/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 10:58 AM
 * Project Name : student-service
 */

package az.pashabank.controller;

import az.pashabank.model.dto.StudentDto;
import az.pashabank.model.dto.StudentRequestDto;
import az.pashabank.model.entity.StudentEntity;
import az.pashabank.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @GetMapping("/all")
    public List<StudentRequestDto> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    public StudentDto findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping(path = "/all")
    public void deleteAll() {
        studentService.deleteAll();
    }

    @PutMapping(value = "/update/{id}")
    public StudentDto update(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.update(id, studentRequestDto);
    }
}
