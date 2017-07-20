package com.birse.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @InjectMocks
    private PersonController controller;
    @Mock
    private PersonService service;

    @Mock
    Model model;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void successCase() throws Exception {

        List<PersonResource> allEmployees = getPersonResources();
        when(service.getPeople()).thenReturn(ResponseEntity.ok(allEmployees));
        String page = controller.people(model);
        assertEquals("pages/person", page);
        verify(model, times(1)).addAttribute("persons", allEmployees);
    }

    private List<PersonResource> getPersonResources() {
        PersonResource alex = new PersonResource();
        alex.setFirstName("Alex");
        return Arrays.asList(alex);
    }

}
