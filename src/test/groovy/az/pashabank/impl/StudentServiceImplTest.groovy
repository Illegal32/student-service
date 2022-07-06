package az.pashabank.impl

import az.pashabank.model.StudentEntity
import az.pashabank.repository.StudentRepository
import az.pashabank.service.impl.StudentServiceImpl
import org.junit.jupiter.api.BeforeEach
import spock.lang.Specification

class StudentServiceImplTest extends Specification {

    final String DOMAIN = "@pashabank.az";

    Long id = 1
    String name = "Nadir"
    String surname = "Jabbarli"

    StudentRepository studentRepository

    StudentServiceImpl studentService

    StudentEntity studentEntity;

    @BeforeEach
    void setup() {
        studentRepository = Mock()

        studentEntity = new StudentEntity()

        studentService = new StudentServiceImpl(studentRepository)

    }

    def "test generateStudentEmailAccount"() {
        given:
        String firstLetter = String.valueOf(name.charAt(0));
        String email = firstLetter.concat(surname).concat(String.valueOf(id));
        String lastVersionEmail = email.concat(DOMAIN);
        StudentEntity studentEntity = StudentEntity.builder().id(id)
                .name(name).surname(surname).email(lastVersionEmail).build()

        when:
        def result = studentService.generateStudentEmailAccount(id, name, surname)

        then:
        1 * studentRepository.save(studentEntity) >> studentEntity
        result == studentEntity
        noExceptionThrown()
    }

    def "test save"() {
        given:
        def id = 1
        def name = "Nadir"
        def surname = "Jabbarli"
        def email = "NJabbarli1@pashabank.az"
        studentEntity.setName(name)
        studentEntity.setSurname(surname)
        studentEntity.setId(id)
        studentEntity.setEmail(email)

        when:
        def result = studentService.save(studentEntity)

        then:
        2 * studentRepository.save(studentEntity) >> studentEntity
        result == studentEntity
        noExceptionThrown()
    }

    def "test findAll"() {
        given:

        def id = 1
        def name = "Nadir"
        def surname = "Jabbarli"
        def email = "NJabbarli1@pashabank.az"
        StudentEntity studentEntity1 = new StudentEntity(id, name, surname, email)

        when:
        def result = studentService.findAll()

        then:
        1 * studentRepository.findAll() >> List.of(studentEntity1)
        noExceptionThrown()
        result.size()
    }

    def "test deleteById"() {
        given:
        Long id = 1
        when:
        studentService.deleteById(id)
        then:
        1 * studentRepository.deleteById(id)
        noExceptionThrown()
    }

    def "test findById"() {
        given:
        Long id = 1

        when:
        studentService.findById(id)
        then:
        1 * studentRepository.findById(id)
        noExceptionThrown()
    }

    def "test deleteAll"() {
        when:
        studentService.deleteAll()

        then:
        1 * studentRepository.deleteAll()
    }
}
