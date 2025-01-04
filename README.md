# Banking Application with GUI Frontend in Java
<br><br>

# Table of Contents

- [Banking Application with GUI Frontend in Java](#banking-application-with-gui-frontend-in-java)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Scenario:](#scenario)
  -  [Phase I: Creating the Initial Classes](#phase-i-creating-the-initial-classes)
  -  [Phase II: Adding an Abstract Superclass & Input Data Validation](#phase-ii-adding-an-abstract-superclass--input-data-validation)
  -  [Phase III: Adding & Implementing Subclasses](#phase-iii-adding--implementing-subclasses)
  -  [Phase IV: Creating the Application GUI](#phase-iv-creating-the-application-gui)
- [Application Architecture & Components](#application-architecture--components)
  -  [DataEntry Class](#dataentry-class)
  -  [Customer Class](#customer-class)
  -  [BankAcctApp Class](#bankacctapp-class)
  -  [Account Abstract Superclass](#account-abstract-superclass)
  -  [CheckingAccount & SavingsAccount Subclasses](#checkingaccount--savingsaccount-subclasses)
  -  [AccountInterface Interface](#accountinterface-interface)
  -  [BankAcctAppGUI Class](#bankacctappgui-class)
- [Functionality \& Rationale](#functionality--rationale)
- [Running Application Screenshots \& Demo](#running-application-screenshots--demo)
- [Potential for Scalability \& Future Enhancements](#potential-for-scalability--future-enhancements)
- [Project Issues \& Lessons Learned](#project-issues--lessons-learned)
  
<br>

# Introduction

The **Banking Application with GUI Frontend** is a four-phase project designed to create a simple yet functional banking application. Users can make deposits and withdrawals from checking and savings accounts, with transactions displayed in real-time.

This project incorporates core object-oriented programming principles, such as inheritance and polymorphism, by utilizing an abstract superclass to manage account types. Encapsulated data ensures sensitive information remains private and secure, while **try/catch exception blocks** and **static methods** provide robust input validation.

During the first three phases, the application employs console-based input and output. In Phase IV, the project is enhanced with a graphical user interface (GUI) frontend to improve usability and user experience.

<br>

# Scenario:

-   ## Phase I: Creating the Initial Classes 
    The initial phase of this project provides the capability to manually input data for new bank customers.The application uses a **sentinel-controlled loop** in the test class to create instances of the **Customer class**. Static methods from the **DataEntry class** are used to collect and validate user input before assigning to the Customer class **instance variables** by way of **setter methods**. Once all customer data has been collected, validated, and assigned to instantiated variables, the **corresponding getter methods** are called by the **BankAccountApp test class** to display the collected data in a formatted report.

-   ## Phase II: Adding an Abstract Superclass & Input Data Validation
    Phase II in the project focuses on adding the capability to create generic bank accounts (e.g., checking and savings), and enhancing the validation of the manually input data. A new class, **Account**, is added to the application (which will be converted to an abstract superclass in Phase III). Input validation is further enhanced in this phase by adding **try/catch blocks** for **exception handling** from improperly formatted or incorrectly entered data.

-   ## Phase III: Adding & Implementing Subclasses
    Expanding on the functionalities of the previous two phases, Phase III adds the capability for creating both **checking** and *savings** accounts for customers. The Account class is converted to an **abstract class**, and two **subclasses** are created: **CheckingAccount** and **SavingsAccount**. Also, since different withdrawal and deposit rules exist for each account type, the **AccountInterface interface** will provide abstract methods for transactions and balance checking. Lastly, logic is added to ensure that all transactional and account input is properly validated before being stored by the appropriate subclass.

-   ## Phase IV: Adding a GUI Frontend
    The final phase of the project, Phase IV, creates a **graphical user interface (GUI)** to replace the console interface. The GUI is created using **Swing classes** to include **JFrames**, **JPanels**, and other GUI components. This GUI uses a combination of **BorderLayout**, **GridBagLayout**, and **FlowLayout** to manage the GUI's layout design.

[Back to Top](#table-of-contents)

<br>

# Application Architecture & Components
The application follows a modular design to provide clearly-defined separation of concerns, as well as to promote code reusability. Each component is designed to handle a specific responsibility, making the application more maintainable and scalable. This approach improves readability, security through encapsulation, and flexibility for future enhancements.

-   ## DataEntry Class
    The **DataEntry class** provides static methods for collecting user input (such as customer and account information, transactional data) and validating it. In Phases I - III, the test class (BankAcctApp) passe arguments to the DataEntry class when calling a specified method. The method uses those arguments as the user prompt and values the user's input is matched against. The method then compares the input against **strict validation rules**. If the input is invalid, **do-while loops** provide an error, prompting the user to correct the input and try again.
    In Phase IV, with the addition of the GUI, additional validation methods were implemented. While the CLI version's validation methods remained in the DataEntry class, the GUI utilized **Regular Expression (Regex) patterns** was incorporated, enhancing the **validation engine** and making it more robust.

-   ## Customer Class
    The **Customer class** is responsible for securely storing customer information and providing access through **getter and setter methods**. **Private instance variables** are populated with data passed by the BankAcctApp or BankAcctAppGUI classes. The class also **overrides** the inherited **toString()** method to return a formatted string representation of the customer’s details. This formatted data is used for generating reports in the CLI or displaying information in the GUI.

-   ## BankAcctApp Class
    The **BankAcctApp class** serves as the application's primary orchestrator. It creates instances of the **Customer** and **Account** classes, assigns data to their instance variables, and stores them in an **ArrayList** for efficient management. This design allows the application **to handle multiple customers and accounts dynamically**. The class interacts with the Customer and Account classes through setter methods, **ensuring encapsulated data integrity** while enabling features like report generation and transaction handling.

-   ## Account Abstract Superclass
    In **Phases II**, the **Account class** provides the **getter** and **setter** methods for storing and retrieving account information. The functionality of this class is enhanced in **Phase III**, however, when it is converted into an **Abstract Class** and the **CheckingAccount and SavingsAccount subclasses** are added. The (now) abstract Account class provides inheritance to the subclasses and serves as a blueprint for shared functionality and structure. It defines common properties and behaviors for all account types, such as account number, balance, and transaction methods, while leaving the implementation of specific behaviors, like withdrawal rules or interest calculations, to the subclasses. This approach ensures code reuse and enforces a consistent structure across all account types.

-   ## CheckingAccount & Savings Account Subclasses
    The CheckingAccount and SavingsAccount subclasses inherit from the Account abstract class and implement specific transaction rules and fees. Both subclasses handle deposits and withdrawals while sharing safeguards to prevent overdrafts and incorrect interest application.

    -   Transaction Fees: Each subclass charges a fee for every transaction, including deposits and withdrawals. The fees vary based on account type, with CheckingAccount having lower fees to support frequent transactions and SavingsAccount charging higher fees to promote saving.
    -   Shared Rules: Logic is implemented to prevent overdrafting savings accounts and to ensure no interest is applied to account balances of $0 or less.
    
    These subclasses provide distinct account management features while adhering to shared principles of financial security and error handling.
    
-   ## AccountInterface Interface
    The **AccountInterface** serves three key purposes:
        **1. Enforce encapsulation** by defining a consistent interface for interacting with account objects.
        **2. Promote flexibility** by allowing for the addition of new transaction types (e.g., transfers between accounts, fee deductions) and integration with other components.
        **3. Enhance modularity** by providing a standardized set of methods for all account types, improving code reusability."
    These are discussed in greater detail in the [Potential for Scalability & Future Enhancements](#potential-for-scalability--future-enhancements) section.

-   ## BankAcctAppGUI Class
    The **BankAcctAppGUI class** is responsible for implementing the **graphical user interface (GUI)** introduced in **Phase IV**. It utilizes **Java's Swing library**, incorporating **JFrame** for the main application window and **JPanel** for creating distinct sections within the interface. **FlowLayout**, **BorderLayout**, and **GridBagLayout** are implemented to position GUI components in an intuitive manner. The GUI leverages the **enhanced data validation engine** from the **DataEntry class** to ensure data integrity and security. This class facilitates user interaction with the application through a more visually appealing and user-friendly interface. More details and screenshots are provided in the [Functionality & Rationale](#functionality--rationale) and [Running Application Screenshots & Demo](#running-application-screenshots--demo) sections below.

[Back to Top](#table-of-contents)

<br>

# Functionality & Rationale

[Back to Top](#table-of-contents)

<br>

# Running Application Screenshots & Demo

[Back to Top](#table-of-contents)

<br>

# Potential for Scalability & Future Enhancements

[Back to Top](#table-of-contents)

<br>

# Project Issues & Lessons Learned

[Back to Top](#table-of-contents)

