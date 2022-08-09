/**
 * Created By Nadir Jabbarli
 * Date : 7/7/2022
 * Time : 2:29 PM
 * Project Name : student-service
 */

package az.pashabank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String name;
    private String surname;

}
