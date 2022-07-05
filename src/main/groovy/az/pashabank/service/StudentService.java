/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:03 AM
 * Project Name : student-service
 */

package az.pashabank.service;

import az.pashabank.model.StudentEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface StudentService {

    StudentEntity generateStudentEmailAccount(Long id, String name, String surname);

    StudentEntity save(StudentEntity studentEntity);

    Iterable<StudentEntity> findAll();

    void deleteById(Long id);

    Optional<StudentEntity> findById(Long id);

    void deleteAll();

}
