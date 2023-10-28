package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.*;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

 @SpringBootTest
    class AccountControllerTest {

        @Autowired
        private WebApplicationContext webApplicationContext;
        private MockMvc mockMvc;
        private final ObjectMapper objectMapper=new ObjectMapper();


        //create object using notation MockBean
        @MockBean
        private AccountServiceImp accountServiceImp;


        @BeforeEach
        public void setup() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }


     @Test
     void getAllAccountTest() throws Exception {
      // Mock data to return when the service is called
      List<Account> accounts = Arrays.asList(
            new Account("Business" ,1290, 10000.0, AccountStatus.CheckingAccount),
            new Account("Business" ,6773, 9000.0, AccountStatus.SavingAccount)
    );
    // Mock the service to return the mock data
    when(accountServiceImp.getAllAccount()).thenReturn(accounts);
    MvcResult mvcResult = mockMvc.perform(get("/accounts"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    String responseContent = mvcResult.getResponse().getContentAsString();

    // Assert that the response content contains the account details
    assertTrue(responseContent.contains("Business"));
    assertTrue(responseContent.contains("Business"));
    assertTrue(responseContent.contains("10000.0"));
    assertTrue(responseContent.contains("9000.0"));

}

     @Test
     void addAccountTest() throws Exception {
         // Mock account data for the request
         Account accountToAdd = new Account("Vacation", 187348, 69900.0, AccountStatus.SavingAccount);
         // Mock the service to handle the account addition
         when(accountServiceImp.addAccount(accountToAdd)).thenReturn(accountToAdd);

         MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/add/account")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content("{\"id\":1,\"name\":\"Vacation\",\"accountNumber\":187348,\"balance\":69900.0,\"accountStatus\":\"SavingAccount\"}"))
                 .andExpect(status().isCreated())
                 .andExpect(content().string("Account added successfully"))
                 .andReturn();
     }


     @Test
     void depositTest() throws Exception {
         // Mock data for the request
         int accountNumber = 187348;
         double amount = 1000.0;
         // Mock the service to handle the deposit
         String message = "Deposit successful";
         when(accountServiceImp.deposit(accountNumber, amount)).thenReturn(message);
         MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/deposit/{accountNumber}", accountNumber)
                         .param("amount", String.valueOf(amount))
                         .contentType(MediaType.APPLICATION_JSON) )
                 .andExpect(status().isOk())
                 .andExpect(content().string("Deposit successful"))
                 .andReturn();
     }

     @Test
     void testShowBalance() throws Exception {
         int accountNumber = 1290;
         String balanceMessage = "Your balance is 10000.00";
         when(accountServiceImp.showBalance(accountNumber)).thenReturn(balanceMessage);
         mockMvc.perform(get("/balance/{accountNumber}", accountNumber)
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(content().string(balanceMessage));
     }
 }




