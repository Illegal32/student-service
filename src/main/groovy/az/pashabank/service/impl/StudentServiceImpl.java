/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:04 AM
 * Project Name : student-service
 */

package az.pashabank.service.impl;

import az.pashabank.model.StudentEntity;
import az.pashabank.repository.StudentRepository;
import az.pashabank.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    StudentService studentService;

    final String DOMAIN = "@pashabank.az";

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity generateStudentEmailAccount(Long id, String name, String surname) {
        String firstLetter = String.valueOf(name.charAt(0));
        String email = firstLetter.concat(surname).concat(String.valueOf(id));
        String lastVersionEmail = email.concat(DOMAIN);

        System.out.println(lastVersionEmail);

        return studentRepository.save(StudentEntity.builder().
                name(name).surname(surname).email(lastVersionEmail).build());

    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        studentEntity.setName(studentEntity.getName());
        studentEntity.setSurname(studentEntity.getSurname());

        studentEntity = studentRepository.save(studentEntity);

        return studentService.generateStudentEmailAccount(studentEntity.getId(),
                studentEntity.getName(),
                studentEntity.getSurname());
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        studentService.deleteAll();
    }
}

