package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountHolderServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountHolderControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private AccountHolderServiceImp accountHolderServiceImp;

    @MockBean
    private Account account;


    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testDeleteAccountHolder() throws Exception {
        int idToDelete = 8789; //

        // Mock the service to handle the account holder deletion
        when(accountHolderServiceImp.deleteAccountHolder(idToDelete)).thenReturn("Account holder deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{id}", idToDelete)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Account holder deleted successfully"))
                .andReturn();
    }


    @Test
    public void testPartialUpdateAccountHolder() throws Exception {
        int id = 1009;
        String updatedName = "Roor"; // Update this to the expected response content

        // Mock the behavior of the service to return a success message
        when(accountHolderServiceImp.partialUpdate(eq(id), eq(updatedName)))
                .thenReturn("Account holder name updated successfully");

        // Perform the PATCH request with the updatedName as the request body
        mockMvc.perform(MockMvcRequestBuilders.patch("/AccountHolder/updatepatch/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedName)) // Set the request body
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Account holder name updated successfully"))
                .andReturn();
    }
}
