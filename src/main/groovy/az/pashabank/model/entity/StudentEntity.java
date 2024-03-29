/**
 * Created By Nadir Jabbarli
 * Date : 7/5/2022
 * Time : 10:17 AM
 * Project Name : student-service
 */

package az.pashabank.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "student")
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
