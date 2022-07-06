/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:00 AM
 * Project Name : student-service
 */

package az.pashabank.repository;

import az.pashabank.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    StudentEntity findStudentEntityByIdOrNameOrSurname(Long id, String name, String surname);

    List<StudentEntity> findAll();

}
