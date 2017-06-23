package com.birse.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@TestPropertySource(properties = { "eureka.client.enabled = false"})
@AutoConfigureRestDocs(outputDir = "build/snippets")
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService service;

    @Test
    public void shouldReturnList() throws Exception {
        when(service.getPeople()).thenReturn(new ResponseEntity<List<PersonResource>>(HttpStatus.OK));
        mockMvc.perform(get("/person")).andExpect(status().isOk()).andDo(document("person"));
    }
}




