package guru.springframework.msscbrewery.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CustomerService customerService;

    @Test
    void getCustomer() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL + "/" + UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void handleCreate() throws Exception {

        BDDMockito.given(customerService.create(any()))
                .willReturn(CustomerDto.builder()
                        .id(UUID.randomUUID())
                        .build());

        mockMvc.perform(post(CustomerController.BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(CustomerDto.builder()
                            .name("hhh")
                            .build())))
                .andExpect(status().isCreated());
    }

    @Test
    void handleConstraintViolationCreate() throws Exception {

        BDDMockito.given(customerService.create(any()))
                .willReturn(CustomerDto.builder()
                        .id(UUID.randomUUID())
                        .build());

            mockMvc.perform(post(CustomerController.BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(CustomerDto.builder()
                            .name("hh")
                            .build())))
                    .andExpect(status().isBadRequest());

    }

    @Test
    void handleUpdate() throws Exception {

        mockMvc.perform(put(CustomerController.BASE_URL + "/" + UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(CustomerDto.builder().name("hhd").build())))
                .andExpect(status().isNoContent());
    }

    @Test
    void handleDelete() throws Exception {

        mockMvc.perform(delete(CustomerController.BASE_URL + "/" + UUID.randomUUID())
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}