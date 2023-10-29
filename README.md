# Mid-Project-Jwa (The Bank System)

</br>
</br>

## Project Description
This project is a simple based banking system that allows users to manage their accounts. 
It includes features like creating accounts, depositing and withdrawing funds, transferring money between accounts, 
and checking account balances.
</br>
</br>


Technology used: I will be using Java, MySQL Workbench, and the Spring framework for my work.

</br>
</br>

## Project Structure
</br>

**The project is organized into packages, each serving a specific purpose:**

-**Entity**: Contains entity classes representing the data model, including Account, AccountHolder, and AccountStatus.

-**Repository**: Provides repository interfaces for data access, including AccountRepository, AccountHolderRepository, and UserRepository.

-**Controller**: Contains REST controllers to handle HTTP requests, such as AccountController and AccountHolderController.

-**Services.Implementation:** Includes service implementations for business logic, such as AccountServiceImp` and AccountHolderServiceImp.

-**Services.Interface:** Provides service interfaces, like AccountInterface and AccountHolderInterface.

</br>


### The Classes
In Bank System project, there are several classes:

**1. Account**- Represents an entity class for bank accounts.</br>
**2. AccountHolder**- This represents an entity class for account holders.</br>
**3. AccountStatus** - An enum representing the status of bank accounts.</br>
**4. User** - Represents an entity class for users (this is used for inheritance in AccountHolder).</br>
**5. AccountHolderRepository** - A repository interface for account holders.</br>
**6. AccountRepository**  - A repository interface for accounts.</br>
**7. UserRepository** - A repository interface for users.</br>
**8. AccountController**  - A controller for managing account-related operations.</br>
**9. AccountHolderController**  - A controller for managing account holder-related operations.</br>
**10. AccountServiceImp**  - An implementation class for account-related services.</br>
**11. AccountHolderServiceImp**  - An implementation class for account holder-related services.</br>
**12. CustomUserDetailsService** - A service for custom user details retrieval (used for authentication)</br>


#### The Main Method :

**In AccountServiceImp**:

**1. deposit**(int accountNumber, double amount): This method allows users to deposit funds into their accounts. It checks if the account exists, the deposit amount is valid, and then updates the account's balance.

**2. withdraw**(int accountNumber, double amount): This method enables users to withdraw funds from their accounts. It validates the account's existence, the withdrawal amount, and the account's balance before making the withdrawal.

**3. transfer**(int sourceAccountNumber, int targetAccountNumber, double amount): This method facilitates fund transfers between two accounts. It checks if both source and target accounts exist, validates the transfer amount, and updates the balances accordingly.

**4. showBalance(int accountNumber)**: This method retrieves and returns the account balance for a given account number.

**5. addAccount(Account account)**: This method allows the creation of new accounts and persists them in the repository.

**6. getAllAccount()**: This method retrieves a list of all accounts.

</br>

**In AccountHolderServiceImp**:

**1. createAccountHolder**(AccountHolder accountHolder)`: This method creates and stores a new account holder in the repository.

**2. updateAccountHolder**(int id, AccountHolder accountHolder)`: It updates the account holder's information based on the provided ID.

**3. deleteAccountHolder(int id)**: This method deletes an account holder with the specified ID.

**4.getAllAccountHolders()**: Retrieves a list of all account holders.

**5. findByAccountHolderId(int id)**: This method retrieves an account holder by their ID.

</br>
</br>

##### External Link: 
[**The Trello**](https://trello.com/invite/b/cpbDaKwn/ATTI7dd96bdcff384f51b6fd4329f587d3e9A01BAA78/mid-project)
</br>
[**Presentation**](https://www.canva.com/design/DAFyUvMoaH8/Tul5tIcVMUpryUh8C4TzEg/edit?utm_content=DAFyUvMoaH8&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
</br>
[**Security**](https://github.com/jejeA/Mid-Project-Jwa.git)



</br>
</br>

**Future work:**
I will be focusing on implementing the administrative functionalities in our project, as the primary emphasis here is on the account holder and their needs. Additionally,
I will be giving special attention to enhancing security using the Spring framework.

note: I have tried security a lot for a long time, and this is the code in this GitHub.


#### Conclusion 

**In summary**, theBank System project is structured to manage bank accounts and account holders efficiently. Key components include entity classes for accounts and users, repository interfaces for data access, controllers for handling HTTP requests, and services for business logic.

The project establishes one-to-one relationships between accounts and account holders, and it uses inheritance for account holders extending the user class. Additionally, it uses an enum for representing account statuses.

The project's structure and relationships provide a solid banking operations and user management foundation. Future enhancements can include authentication, transaction tracking, and error handling. The modular design allows for scalability and further customization to meet specific banking system needs.
</br>
</br>


**The UML Class diagram**: 
</br>
![bank system](https://github.com/jejeA/Jawaher-Bank-System/assets/45108741/559983b2-02cf-4764-9b80-4f11bfff40b4)




