package com.birse;

import com.birse.person.Person;
import com.birse.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:integrationtest.properties")
public class PersonControllerTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setup() {
        personRepository.deleteAll();
    }

    @Test
    public void testListPeople() throws Exception {
        Person p1 = createSamplePerson("George", "King");
        Person p2 = createSamplePerson("Mary", "Queen");

        this.mockMvc.perform(
                get("/person").accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(p1.getId().intValue())))
                .andExpect(jsonPath("$[0].firstName", is("George")))
                .andExpect(jsonPath("$[0].lastName", is("King")))
                .andExpect(jsonPath("$[1].id", is(p2.getId().intValue())))
                .andExpect(jsonPath("$[1].firstName", is("Mary")))
                .andExpect(jsonPath("$[1].lastName", is("Queen")));
    }

    @Test
    public void emptyList() throws Exception {

        this.mockMvc.perform(
                get("/person").accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testFindOne() throws Exception {
        Person p = createSamplePerson("George", "King");
        this.mockMvc.perform(
                get("/person/" +p.getId()).accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindOneDoesntExist() throws Exception {
        this.mockMvc.perform(
                get("/person/1").accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void testCreatePerson() throws Exception {
        this.mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Person("John", "Doe")))
        ).andExpect(status().isOk());

        assertEquals(1, personRepository.count());
    }

    @Test
    public void testUpdateDoesntExist() throws Exception {
        this.mockMvc.perform(
                put("/person/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Person("John", "Doe")))
        ).andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateSuccess() throws Exception {

        Person p = createSamplePerson("John", "Doe");
        this.mockMvc.perform(
                put("/person/"+p.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Person("John", "Doe")))
        ).andExpect(status().isOk());
    }

    @Test
    public void testDeleteDoesntExist() throws Exception {

        this.mockMvc.perform(
                delete("/person/1")
        ).andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteSuccess() throws Exception {

        Person p = createSamplePerson("John", "Doe");
        this.mockMvc.perform(
                delete("/person/"+p.getId())
        ).andExpect(status().isOk());
    }


    private Person createSamplePerson(String firstName, String lastName) {
        return personRepository.save(new Person(firstName, lastName));
    }

}
