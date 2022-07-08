package az.pashabank.controller


import az.pashabank.model.dto.StudentRequestDto
import az.pashabank.service.impl.StudentServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import org.skyscreamer.jsonassert.JSONAssert
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

import az.pashabank.service.impl.StudentServiceImpl
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class StudentControllerTest extends Specification {

    private StudentController studentController

    private StudentServiceImpl studentService

    MockMvc mockMvc

    void setup() {
        studentService = Mock()

        studentController = new StudentController(studentService)

        mockMvc = MockMvcBuilders.standaloneSetup(studentController)
                .build()
    }

    def "test save"() {
        given:

        given:
        var name = "Nadir"
        var surname = "Jabbarli"
        var email = "NJabbarli1@pashabank.az"

        def exceptedRequest = '''
                                {
                                    "name": "Nadir",
                                    "surname": "Jabbarli"
                                }
        '''

        def exceptedResponse = '''
                                {
                                    "name": "Nadir",
                                    "surname": "Jabbarli"
                                }
        '''

        def studentRequestDtoBefore = StudentRequestDto.builder().name(name).surname(surname).build()
        def studentRequestDtoAfter = StudentRequestDto.builder().name(name).surname(surname).email(email).build()

        def url = "/students"

        when:
        def result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).
                content(exceptedRequest)).andReturn()

        then:
        1 * studentService.save(studentRequestDtoBefore) >> studentRequestDtoAfter
        def response = result.response
        response.getStatus() == 200
        JSONAssert.assertEquals(exceptedResponse, response.getContentAsString(), false)
    }

    def "deleteById"() {
        given:
        Long id = 1
        def url = "/students/{id}"
        when:
        def result = mockMvc.perform(delete(url, id).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn()
        then:
        1 * studentService.deleteById(id)
        def response = result.response
        response.getStatus() == 200

    }

    def "findById"() {
        given:
        Long id = 1
        def url = "/students/{id}"
        when:
        def result = mockMvc.perform(get(url, id).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn()
        then:
        1 * studentService.findById(id)
        def response = result.response
        response.getStatus() == 200
    }

    def "deleteAll"() {
        given:
        def url = "/students/all"
        when:
        def result = mockMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn()
        then:
        1 * studentService.deleteAll()
        def response = result.response
        response.getStatus() == 200

    }
}
