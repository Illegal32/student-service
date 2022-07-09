/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:03 AM
 * Project Name : student-service
 */

package az.pashabank.service;

import az.pashabank.model.dto.StudentDto;
import az.pashabank.model.dto.StudentRequestDto;
import az.pashabank.model.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    String generateStudentEmailAccount(Long id, String name, String surname);

    StudentEntity save(StudentRequestDto studentRequestDto);

    List<StudentDto> findAll();

    void deleteById(Long id);

    StudentDto findById(Long id);

    void deleteAll();

}
