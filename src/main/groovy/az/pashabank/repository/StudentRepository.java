/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 11:00 AM
 * Project Name : student-service
 */

package az.pashabank.repository;

import az.pashabank.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findStudentEntityByIdOrNameOrSurname(Long id, String name, String surname);

    List<StudentEntity> findAll();

}
