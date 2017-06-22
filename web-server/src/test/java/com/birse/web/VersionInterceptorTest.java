package com.birse.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
public class VersionInterceptorTest {

    @InjectMocks
    VersionInterceptor interceptor;
    @Mock
    ModelAndView modelAndView;
    @Mock
    ModelMap map;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNoModel() throws Exception {
        interceptor.postHandle(null, null, null, null);
    }

    @Test
    public void testVersionAdded() throws Exception {
        ReflectionTestUtils.setField(interceptor, "version", "testValue");
        when(modelAndView.getModelMap()).thenReturn(map);
        interceptor.postHandle(null, null, null, modelAndView);
        verify(map).addAttribute("version", "testValue");
    }

}
