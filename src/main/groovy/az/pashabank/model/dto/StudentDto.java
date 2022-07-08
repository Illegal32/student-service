/**
 * Created By Nadir Jabbarli
 * Date : 7/7/2022
 * Time : 2:29 PM
 * Project Name : student-service
 */

package az.pashabank.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class StudentDto {

    private Long id;
    private String name;
    private String surname;

}
