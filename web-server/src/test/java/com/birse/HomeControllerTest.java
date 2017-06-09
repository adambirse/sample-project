package com.birse;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created on 08/06/2017.
 */
public class HomeControllerTest {

    HomeController controller;

    @Before
    public void setup() {controller = new HomeController();}

    @Test
    public void checkCorrectPageReturned() {
        assertThat(controller.home(), is(equalTo("pages/home")));
    }

}
