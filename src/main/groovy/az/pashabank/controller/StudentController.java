/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 10:58 AM
 * Project Name : student-service
 */

package az.pashabank.controller;

import az.pashabank.model.dto.StudentDto;
import az.pashabank.model.dto.StudentRequestDto;
import az.pashabank.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StudentRequestDto> save(@RequestBody StudentRequestDto studentRequestDto) {
        var result = studentService.save(studentRequestDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping(path = "/{id}") // update etmek ucundur
    public StudentDto findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping(path = "/all")
    public void deleteAll() {
        studentService.deleteAll();
    }
}
