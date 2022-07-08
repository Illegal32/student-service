//package az.pashabank.impl
//
//import az.pashabank.model.dto.StudentDto
//import az.pashabank.model.dto.StudentRequestDto
//import az.pashabank.model.entity.StudentEntity
//import az.pashabank.repository.StudentRepository
//import az.pashabank.service.impl.StudentServiceImpl
//import org.junit.jupiter.api.BeforeEach
//import spock.lang.Specification
//
//class StudentServiceImplTestOld extends Specification {
//
//    final String DOMAIN = "@pashabank.az";
//
//    Long id = 1
//    String name = "Nadir"
//    String surname = "Jabbarli"
//
//    StudentRepository studentRepository
//
//    StudentServiceImpl studentService
//
//    StudentRequestDto studentRequestDto;
//
//    StudentDto studentDto;
//
//    @BeforeEach
//    void setup() {
//        studentRepository = Mock()
//
//        studentRequestDto = new StudentEntity()
//
//        studentService = new StudentServiceImpl(studentRepository)
//
//    }
//
//    def "test save"() {
//        given:
//        def name = "Nadir"
//        def surname = "Jabbarli"
//        def email = "NJabbarli1@pashabank.az"
//        studentRequestDto.setName(name)
//        studentRequestDto.setSurname(surname)
//        studentRequestDto.setEmail(email)
//
//        when:
//        def result = studentService.save(studentRequestDto)
//
//        then:
//        2 * studentRepository.save(studentRequestDto) >> studentRequestDto
//        result == studentRequestDto
//        noExceptionThrown()
//    }
//
//    def "test findAll"() {
//        given:
//
//        def id = 1
//        def name = "Nadir"
//        def surname = "Jabbarli"
//        def email = "NJabbarli1@pashabank.az"
//        StudentEntity studentEntity1 = new StudentEntity(id, name, surname, email)
//
//        when:
//        def result = studentService.findAll()
//
//        then:
//        1 * studentRepository.findAll() >> List.of(studentEntity1)
//        noExceptionThrown()
//        result.size()
//    }
//
//    def "test deleteById"() {
//        given:
//        Long id = 1
//        when:
//        studentService.deleteById(id)
//        then:
//        1 * studentRepository.deleteById(id)
//        noExceptionThrown()
//    }
//
//    def "test findById"() {
//        given:
//        Long id = 1
//
//        when:
//        studentService.findById(id)
//        then:
//        1 * studentRepository.findById(id)
//        noExceptionThrown()
//    }
//
//    def "test deleteAll"() {
//        when:
//        studentService.deleteAll()
//
//        then:
//        1 * studentRepository.deleteAll()
//    }
//}
