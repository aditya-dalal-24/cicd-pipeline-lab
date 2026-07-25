package com.handson.cicd.controller;

import com.handson.cicd.controller.GreetingController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.handson.cicd.service.GreetingService;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GreetingService greetingService;

    @Test
    void greetingExpected() throws Exception{
        Mockito.when(greetingService.greeting()).thenReturn("damn mocked pipeline output");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/greeting")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("damn mocked pipeline output"));
    }

}