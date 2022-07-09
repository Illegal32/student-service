/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:04 AM
 * Project Name : student-service
 */

package az.pashabank.service.impl;

import az.pashabank.mapper.StudentMapper;
import az.pashabank.model.entity.StudentEntity;
import az.pashabank.model.dto.StudentDto;
import az.pashabank.model.dto.StudentRequestDto;
import az.pashabank.repository.StudentRepository;
import az.pashabank.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    final String DOMAIN = "@pashabank.az";

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = StudentMapper.INSTANCE;
    }

    @Override
    public String generateStudentEmailAccount(Long id, String name, String surname) {
        return String.valueOf(name.charAt(0)).concat(surname).concat(String.valueOf(id)).concat(DOMAIN);
    }

    @Override
    public StudentEntity save(StudentRequestDto studentRequestDto) {
        StudentEntity student = StudentMapper.INSTANCE.dtoToStudentEntity(studentRequestDto);
        student.setEmail(generateStudentEmailAccount(student.getId(), student.getName(), student.getSurname()));

        return studentRepository.save(student);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().
                map(studentMapper::entityToStudentDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto findById(Long id) {
        return studentMapper.entityToStudentDto(studentRepository.
                findById(id).orElseThrow(() -> new RuntimeException("Not Found Person")));
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }


}

