package az.pashabank.impl


import az.pashabank.mapper.StudentMapper
import az.pashabank.model.dto.StudentRequestDto
import az.pashabank.model.entity.StudentEntity
import az.pashabank.repository.StudentRepository
import az.pashabank.service.impl.StudentServiceImpl
import spock.lang.Specification

class StudentServiceImplTest extends Specification {

    StudentRepository studentRepository

    StudentServiceImpl studentService

    StudentEntity studentEntityAfter

    StudentEntity studentEntityBefore

    StudentMapper studentMapper

    void setup() {
        studentRepository = Mock()

        studentService = new StudentServiceImpl(studentRepository)

        studentMapper = StudentMapper.INSTANCE
    }

    def "Save"() {
        given:
        Long id = 1L
        def name = "Nadir"
        def surname = "Jabbarli"
        def email = "NJabbarlinull@pashabank.az"

        StudentRequestDto studentRequestDto = StudentRequestDto.builder().name(name).surname(surname).email(email).build()

        studentEntityBefore = new StudentEntity(null, name, surname, email)
        studentEntityAfter = new StudentEntity(id, name, surname, email)

        when:
        studentService.save(studentRequestDto)

        then:
//        1 * studentMapper.dtoToStudentEntity(studentRequestDto)
        1 * studentRepository.save(studentEntityBefore) >> studentEntityAfter
        noExceptionThrown()
    }


    def "FindAll"() {

        given:
        var name = "Nadir"
        var surname = "Jabbarli"
        var email = "NJabbarli1@pashabank.az"

        StudentRequestDto studentRequestDto1 = new StudentRequestDto(name, surname, email)

        when:
        def result = studentService.findAll()

        then:
        1 * studentRepository.findAll() >> List.of(studentMapper.dtoToStudentEntity(studentRequestDto1))
        result.size() == 1
        noExceptionThrown()
    }

    def "DeleteById"() {
        given:
        Long id = 1
        when:
        studentService.deleteById(id)
        then:
        1 * studentRepository.deleteById(id)
        noExceptionThrown()
    }

    def "FindById"() {
        given:
        Long id = 1L
        studentEntityAfter = StudentEntity.builder().id(id).build()

        when:
        studentService.findById(id)
        then:
        1 * studentRepository.findById(id) >> Optional.of(studentEntityAfter)
        noExceptionThrown()
    }

    def "DeleteAll"() {
        when:
        studentService.deleteAll()

        then:
        1 * studentRepository.deleteAll()

    }
}
