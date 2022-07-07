/**
 * Created By Nadir Jabbarli
 * Date : 7/7/2022
 * Time : 2:29 PM
 * Project Name : student-service
 */

package az.pashabank.model.dto;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private String email;

}
