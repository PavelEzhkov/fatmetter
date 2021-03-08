package ru.ezhkov.fatmetter.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.ezhkov.fatmetter.service.DishService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DishController.class)
class DishControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private ModelMapper modelMapper;

    @MockBean private DishService dishService;

    @Test
    @WithMockUser(username = "Username", password = "Password", roles = "USER")
    void getTotalCaloriesTest_200() throws Exception {
        mockMvc.perform(get("/dish/{id}/caloriestotal", 1L)
                .contentType("application/json")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "Username", password = "Password", roles = "USER")
    void getTotalCaloriesTest_400() throws Exception {
        mockMvc.perform(get("/dish/{id}/caloriestotal", "asd")
                .contentType("application/json")).andExpect(status().isBadRequest());
    }

    @Test
    void getTotalCaloriesTest_401() throws Exception {
        mockMvc.perform(get("/dish/{id}/caloriestotal", "asd")
                .contentType("application/json")).andExpect(status().isUnauthorized());
    }
}