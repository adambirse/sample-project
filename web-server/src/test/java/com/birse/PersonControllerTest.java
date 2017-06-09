package com.birse;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created on 08/06/2017.
 */
public class PersonControllerTest {

    PersonController controller;

    @Before
    public void setup() {controller = new PersonController();}

    @Test
    public void checkCorrectPageReturned() {
        assertThat(controller.person(), is(equalTo("pages/person")));
    }

}
