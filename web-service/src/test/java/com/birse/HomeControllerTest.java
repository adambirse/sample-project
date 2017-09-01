package com.birse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created on 08/06/2017.
 */
@RunWith(SpringRunner.class)
public class HomeControllerTest {

    HomeController controller;

    @Before
    public void setup() {
        controller = new HomeController();
    }

    @Test
    public void checkCorrectPageReturned() {
        assertThat(controller.home(), is(equalTo("pages/home")));
    }

}
