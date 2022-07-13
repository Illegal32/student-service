/**
 * Created By Nadir Jabbarli
 * Date : 7/7/2022
 * Time : 2:17 PM
 * Project Name : student-service
 */

package az.pashabank.mapper;

import az.pashabank.model.entity.StudentEntity;
import az.pashabank.model.dto.StudentDto;
import az.pashabank.model.dto.StudentRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class StudentMapper {
    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    public abstract StudentEntity studentDtoToStudentEntity(StudentDto studentDto);

    public abstract StudentEntity dtoToStudentEntity(StudentRequestDto studentRequestDto);

    public abstract StudentEntity dtoToStudentEntityWithId(StudentDto studentDto, Long id);

    public abstract StudentDto entityToStudentDto(StudentEntity studentEntity);

    public abstract StudentRequestDto entityToStudentRequestDto(StudentEntity studentEntity);

    public abstract void updateStudentFromDto(StudentDto studentDto, @MappingTarget StudentEntity studentEntity);

    public abstract StudentDto studentDto(Long id, StudentRequestDto studentRequestDto);

}
