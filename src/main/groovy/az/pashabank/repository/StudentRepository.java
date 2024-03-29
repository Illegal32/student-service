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
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findAll();

    Optional<StudentEntity> findById(Long id);
}
