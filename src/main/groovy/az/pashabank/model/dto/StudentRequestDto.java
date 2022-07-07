/**
 * Created By Nadir Jabbarli
 * Date : 7/7/2022
 * Time : 4:35 PM
 * Project Name : student-service
 */

package az.pashabank.model.dto;

import lombok.Data;

@Data
public class StudentRequestDto {

    private String name;
    private String surname;
    private String email;
}
