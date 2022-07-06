/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 10:17 AM
 * Project Name : student-service
 */

package az.pashabank.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "student_info")
@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;
}
