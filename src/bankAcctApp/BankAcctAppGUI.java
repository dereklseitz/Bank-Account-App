/* Phase IV */

package bankAcctApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BankAcctAppGUI extends JFrame {
    private JButton addCustomerBtn, addTransactionBtn, viewInfoBtn;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public BankAcctAppGUI(ArrayList<Customer> customers, ArrayList<Account> accounts) {
        super("Bank Account Application");
        this.customers = customers;
        this.accounts = accounts;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addCustomerBtn = new JButton("Add Customer and Account");
        addCustomerBtn.setPreferredSize(new Dimension(200, 50));
        addTransactionBtn = new JButton("Add Transactions to Existing Account");
        addTransactionBtn.setPreferredSize(new Dimension(200, 50));
        viewInfoBtn = new JButton("View Customer Account Info");
        viewInfoBtn.setPreferredSize(new Dimension(200, 50));
        mainPanel.add(addCustomerBtn);
        mainPanel.add(addTransactionBtn);
        mainPanel.add(viewInfoBtn);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(mainPanel);
        add(centerPanel, BorderLayout.CENTER);

        addCustomerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddCustomerPanel();
            }
        });
        addTransactionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddTransactionPanel();
            }
        });
        viewInfoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showViewInfoPanel();
            }
        });

        setVisible(true);
    }

    private void showAddCustomerPanel() {
        JFrame addCustomerFrame = new JFrame("Add Customer and Account");
        addCustomerFrame.setSize(800, 600);
        addCustomerFrame.setLayout(new BorderLayout());

        JPanel customerPanel = new JPanel(new GridBagLayout());
        JPanel accountPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Information
        gbc.gridx = 0;
        gbc.gridy = 0;
        customerPanel.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        JTextField idTxtFld = new JTextField(15);
        customerPanel.add(idTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        customerPanel.add(new JLabel("SSN:"), gbc);
        gbc.gridx = 1;
        JTextField ssnTxtFld = new JTextField(15);
        customerPanel.add(ssnTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        customerPanel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        JTextField lastNameTxtFld = new JTextField(15);
        customerPanel.add(lastNameTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        customerPanel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        JTextField firstNameTxtFld = new JTextField(15);
        customerPanel.add(firstNameTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        customerPanel.add(new JLabel("Street Address:"), gbc);
        gbc.gridx = 1;
        JTextField streetTxtFld = new JTextField(15);
        customerPanel.add(streetTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        customerPanel.add(new JLabel("City:"), gbc);
        gbc.gridx = 1;
        JTextField cityTxtFld = new JTextField(15);
        customerPanel.add(cityTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        customerPanel.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        String[] states = {
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
        };
        JComboBox<String> stateDropdown = new JComboBox<>(states);
        customerPanel.add(stateDropdown, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        customerPanel.add(new JLabel("ZIP Code:"), gbc);
        gbc.gridx = 1;
        JTextField zipTxtFld = new JTextField(15);
        customerPanel.add(zipTxtFld, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        customerPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        JTextField phoneTxtFld = new JTextField(10);
        customerPanel.add(phoneTxtFld, gbc);

        // Account Information
        gbc.gridx = 0;
        gbc.gridy = 0;
        accountPanel.add(new JLabel("Account Number:"), gbc);
        gbc.gridx = 1;
        JTextField acctNumTxtFld = new JTextField(15);
        accountPanel.add(acctNumTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        accountPanel.add(new JLabel("Account Type:"), gbc);
        gbc.gridx = 1;
        JRadioButton chkRadio = new JRadioButton("Checking");
        JRadioButton savRadio = new JRadioButton("Savings");
        ButtonGroup acctTypeGroup = new ButtonGroup();
        acctTypeGroup.add(chkRadio);
        acctTypeGroup.add(savRadio);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(chkRadio);
        radioPanel.add(savRadio);
        accountPanel.add(radioPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        accountPanel.add(new JLabel("Service Fee:"), gbc);
        gbc.gridx = 1;
        JTextField svcFeeTxtFld = new JTextField(15);
        accountPanel.add(svcFeeTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        accountPanel.add(new JLabel("Interest Rate:"), gbc);
        gbc.gridx = 1;
        JTextField intRateTxtFld = new JTextField(15);
        accountPanel.add(intRateTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        accountPanel.add(new JLabel("Overdraft Fee: "), gbc);
        gbc.gridx = 1;
        JTextField ovDrftTxtFld = new JTextField(15);
        accountPanel.add(ovDrftTxtFld, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        accountPanel.add(new JLabel("Starting Balance:"), gbc);
        gbc.gridx = 1;
        JTextField startBalTxtFld = new JTextField(15);
        accountPanel.add(startBalTxtFld, gbc);

        JPanel buttonPanel = new JPanel();
        JButton saveBtn = new JButton("Save");
        JButton clearBtn = new JButton("Clear");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(saveBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(cancelBtn);

        addCustomerFrame.add(customerPanel, BorderLayout.NORTH);
        addCustomerFrame.add(accountPanel, BorderLayout.CENTER);
        addCustomerFrame.add(buttonPanel, BorderLayout.SOUTH);
        addCustomerFrame.setVisible(true);

     // Add action listeners for buttons
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("--Action Event-- saveBtn clicked DataEntry validation engine starting.");
                try {
                    // Create a new instance of Customer and Account at the beginning
                    System.out.println("Attempting to create new Customer.");
                    Customer customer = new Customer();
                    System.out.println("New Customer created.");

                    System.out.println("\nStarting Customer Information validation.");
                    // ----------------- Customer Information -----------------
                    System.out.println("Starting [id] validation.");
                    String id = idTxtFld.getText().trim();
                    DataEntry.inputIDGUI(id); // Use the GUI-specific validation method for ID
                    customer.setID(id);
                    System.out.println("[id] validated.");

                    System.out.println("Starting [ssn] validation.");
                    String ssn = ssnTxtFld.getText().trim();
                    DataEntry.inputSSNGUI(ssn); // Use the GUI-specific validation method for SSN
                    customer.setSSN(ssn);
                    System.out.println("[ssn] validated.");

                    System.out.println("Starting [lastName] validation.");
                    String lastName = lastNameTxtFld.getText().trim();
                    DataEntry.inputLastNameGUI(lastName); // Use the GUI-specific validation method for last name
                    customer.setLastName(lastName);
                    System.out.println("[lastName] validated.");

                    System.out.println("Starting [firstName] validation.");
                    String firstName = firstNameTxtFld.getText().trim();
                    DataEntry.inputFirstNameGUI(firstName); // Use the GUI-specific validation method for first name
                    customer.setFirstName(firstName);
                    System.out.println("[firstName] validated.");

                    System.out.println("Starting [street] validation.");
                    String street = streetTxtFld.getText().trim();
                    DataEntry.inputStreetGUI(street); // Use the GUI-specific validation method for street
                    customer.setStreet(street);
                    System.out.println("[street] validated.");

                    System.out.println("Starting [city] validation.");
                    String city = cityTxtFld.getText().trim();
                    DataEntry.inputCityGUI(city); // Use the GUI-specific validation method for city
                    customer.setCity(city);
                    System.out.println("[city] validated");

                    // Handle dropdown for State
                    System.out.println("Starting [state] validation.");
                    String state = (String) stateDropdown.getSelectedItem();
                    if (state == null || state.isEmpty()) {
                        throw new IllegalArgumentException("State must be selected.");
                    }
                    customer.setState(state);
                    System.out.println("[state] validated.");

                    System.out.println("Starting [zip] validation.");
                    String zip = zipTxtFld.getText().trim();
                    DataEntry.inputZipGUI(zip); // Use the GUI-specific validation method for zip
                    customer.setZip(zip);
                    System.out.println("[zip] validated.");

                    System.out.println("Starting [phone] validation.");
                    String phone = phoneTxtFld.getText().trim();
                    DataEntry.inputPhoneGUI(phone); // Use the GUI-specific validation method for phone
                    customer.setPhone(phone);
                    System.out.println("[phone] validated.");

                    System.out.println("Customer Information validation completed.");

                    // ----------------- Account Information -----------------
                    // Create Null account object
                    Account account = null;
                    // Determine account type
                    System.out.println("Checking for account type.");
                	System.out.println("Attempting to create new account.");
                    if (chkRadio.isSelected()) {
                    	account = new CheckingAccount();
                        account.setAccountType("CHK");
                        System.out.println("Account type accepted.");
                        System.out.println("New Checking Account created.");
                    } else if (savRadio.isSelected()) {
                    	account = new SavingsAccount();
                        account.setAccountType("SAV");
                        System.out.println("Account type accepted.");
                        System.out.println("New Savings Account created.");
                    } else {
                        throw new IllegalArgumentException("Account type must be selected.");
                    }
                    
                    // Account number validation
                    System.out.println("Starting [accountNumber] validation.");
                    String accountNumber = acctNumTxtFld.getText().trim();
                    DataEntry.inputNumericStringGUI(accountNumber, 5); // Use GUI-specific validation method for account number
                    account.setAccountNumber(accountNumber); // Set account number in the account instance
                    System.out.println("[accountNumber] validated.");
                    
                    // Service fee validation
                    System.out.println("Starting [svcFee] validation.");
                    String svcFeeStr = svcFeeTxtFld.getText().trim();
                    try {
                        double svcFee = DataEntry.inputDecimalInRangeGUI(svcFeeStr, 0.00, 10.00); // Validate and convert to double
                        account.setSvcFee(svcFee); // Set service fee in the same Account instance
                        System.out.println("[svcFee] validated.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(addCustomerFrame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent further processing if invalid input
                    }

                    // Interest rate validation
                    System.out.println("Starting [interestRate] validation.");
                    String intRateStr = intRateTxtFld.getText().trim();
                    try {
                        double interestRate = DataEntry.inputDecimalInRangeGUI(intRateStr, 0.0, 10.0); // Validate and convert to double
                        account.setInterestRate(interestRate); // Set interest rate
                        System.out.println("[interestRate] validated.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(addCustomerFrame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent further processing if invalid input
                    }

                    // Overdraft fee validation
                    System.out.println("Starting [overdraftFee] validation.");
                    String ovDrftFeeStr = ovDrftTxtFld.getText().trim();
                    try {
                        double overdraftFee = DataEntry.inputDecimalGUI(ovDrftFeeStr); // Validate and convert to double
                        account.setOverDraftFee(overdraftFee); // Set overdraft fee
                        System.out.println("[overdraftFee] validated.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(addCustomerFrame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent further processing if invalid input
                    }

                    // Starting balance validation
                    System.out.println("Starting [startingBalance] validation.");
                    String startBalStr = startBalTxtFld.getText().trim();
                    try {
                        double startingBalance = DataEntry.inputDecimalGUI(startBalStr); // Validate and convert to double
                        account.setBalance(startingBalance); // Set starting balance
                        System.out.println("[startingBalance] validated.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(addCustomerFrame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent further processing if invalid input
                    }

                    // ----------------- Add to Collections -----------------
                    System.out.println("Adding customer instance to customers collection.");
                    customers.add(customer); // Add customer to collection
                    System.out.println("Customer was successfully added.");
                    System.out.println("Adding account instance to accounts collection.");
                    accounts.add(account); // Add account to collection
                    System.out.println("Account was successfully added.");

                    // ----------------- Success Message -----------------
                    JOptionPane.showMessageDialog(addCustomerFrame, "Customer and Account added successfully!");

                    // ----------------- Clear Fields -----------------
                    System.out.println("Clearing JTextField form controls.");
                    idTxtFld.setText("");
                    ssnTxtFld.setText("");
                    lastNameTxtFld.setText("");
                    firstNameTxtFld.setText("");
                    streetTxtFld.setText("");
                    cityTxtFld.setText("");
                    stateDropdown.setSelectedIndex(0);
                    zipTxtFld.setText("");
                    phoneTxtFld.setText("");
                    acctNumTxtFld.setText("");
                    svcFeeTxtFld.setText("");
                    intRateTxtFld.setText("");
                    ovDrftTxtFld.setText("");
                    startBalTxtFld.setText("");
                    System.out.println("JTextField form controls cleared successfully.");

                } catch (IllegalArgumentException ex) {
                    // Display validation error message and keep fields unchanged for correction
                    JOptionPane.showMessageDialog(addCustomerFrame, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
            	System.out.println("--Action Event-- clearBtn clicked.");
                System.out.println("Clearing JTextField form controls.");
                idTxtFld.setText("");
                ssnTxtFld.setText("");
                lastNameTxtFld.setText("");
                firstNameTxtFld.setText("");
                streetTxtFld.setText("");
                cityTxtFld.setText("");
                stateDropdown.setSelectedIndex(0);
                zipTxtFld.setText("");
                acctNumTxtFld.setText("");
                svcFeeTxtFld.setText("");
                intRateTxtFld.setText("");
                ovDrftTxtFld.setText("");
                startBalTxtFld.setText("");
                System.out.println("JTextField form controls cleared successfully.");

            }
        });


        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("--Action Event-- cancelBtn Clicked -- Operation canceled.");
                addCustomerFrame.dispose();
            }
        });
    }

    private void showAddTransactionPanel() {
        JFrame addTransactionFrame = new JFrame("Add Transaction");
        addTransactionFrame.setSize(800, 600);
        addTransactionFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Account Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        addTransactionFrame.add(new JLabel("Account Number:"), gbc);
        gbc.gridx = 1;
        JTextField acctNumTxtFld = new JTextField(15);
        addTransactionFrame.add(acctNumTxtFld, gbc);

        // Transaction Type (Radio Buttons for Deposit or Withdrawal)
        gbc.gridx = 0;
        gbc.gridy = 1;
        addTransactionFrame.add(new JLabel("Transaction Type:"), gbc);
        gbc.gridx = 1;

        // Create the radio buttons for deposit and withdrawal types
        JRadioButton depositButton = new JRadioButton("Deposit");
        JRadioButton withdrawalButton = new JRadioButton("Withdrawal");

        // Group the radio buttons
        ButtonGroup transactionTypeGroup = new ButtonGroup();
        transactionTypeGroup.add(depositButton);
        transactionTypeGroup.add(withdrawalButton);

        // Add the radio buttons to the panel
        JPanel transactionTypePanel = new JPanel();
        transactionTypePanel.add(depositButton);
        transactionTypePanel.add(withdrawalButton);

        addTransactionFrame.add(transactionTypePanel, gbc);

        // Date (Transaction Date)
        gbc.gridx = 0;
        gbc.gridy = 2;
        addTransactionFrame.add(new JLabel("Transaction Date (MM/dd/yyyy):"), gbc);
        gbc.gridx = 1;
        JTextField dateTxtFld = new JTextField(15);
        addTransactionFrame.add(dateTxtFld, gbc);

        // Amount (For deposit/withdrawal)
        gbc.gridx = 0;
        gbc.gridy = 3;
        addTransactionFrame.add(new JLabel("Amount:"), gbc);
        gbc.gridx = 1;
        JTextField amountTxtFld = new JTextField(15);
        addTransactionFrame.add(amountTxtFld, gbc);

        // Apply Interest Button
        JButton applyInterestBtn = new JButton("Apply Interest");
        gbc.gridx = 0;
        gbc.gridy = 4;
        addTransactionFrame.add(applyInterestBtn, gbc);

        // Submit Button
        gbc.gridx = 2;
        gbc.gridy = 4;
        JButton submitBtn = new JButton("Submit");
        addTransactionFrame.add(submitBtn, gbc);

        // Transaction History
        gbc.gridx = 0;
        gbc.gridy = 5;
        addTransactionFrame.add(new JLabel("Transaction History:"), gbc);
        gbc.gridx = 1;
        JTextArea transactionHistoryArea = new JTextArea(10, 40);
        transactionHistoryArea.setEditable(false);
        addTransactionFrame.add(new JScrollPane(transactionHistoryArea), gbc);

        addTransactionFrame.setVisible(true);

        // Action listener for Apply Interest button
        applyInterestBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = acctNumTxtFld.getText();
                String transactionDate = dateTxtFld.getText();
                Account selectedAccount = null;
                Customer selectedCustomer = null;

                // Validate the date format (MM/dd/yyyy)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                try {
                    LocalDate.parse(transactionDate, formatter); // Check if the date is valid
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(addTransactionFrame, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Find the account and customer based on the account number
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                        selectedAccount = accounts.get(i);
                        selectedCustomer = customers.get(i);
                        break;
                    }
                }

                // Handle interest application if account found
                if (selectedAccount != null && selectedCustomer != null) {
                    // Apply interest to the account
                    selectedAccount.applyAccruedInterest(transactionDate);

                    // Log the interest applied transaction
                    String transaction = selectedAccount.logTransaction(transactionDate, "Interest Applied", 0);

                    // Update transaction history display
                    StringBuilder historyText = new StringBuilder();
                    for (String trans : selectedAccount.getTransactionHistory()) {
                        historyText.append(trans).append("\n");
                    }
                    transactionHistoryArea.setText(historyText.toString());
                } else {
                    JOptionPane.showMessageDialog(addTransactionFrame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener for Submit button (Deposit/Withdrawal)
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = acctNumTxtFld.getText();
                String transactionDate = dateTxtFld.getText();
                Account selectedAccount = null;
                Customer selectedCustomer = null;

                // Validate the date format (MM/dd/yyyy)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                try {
                    LocalDate.parse(transactionDate, formatter); // Check if the date is valid
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(addTransactionFrame, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Find the account and customer based on the account number
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                        selectedAccount = accounts.get(i);
                        selectedCustomer = customers.get(i);
                        break;
                    }
                }

                // Handle deposit/withdrawal if account found
                if (selectedAccount != null && selectedCustomer != null) {
                    String transactionType = "";
                    double amount = 0;

                    if (depositButton.isSelected()) {
                        transactionType = "Deposit";
                        amount = Double.parseDouble(amountTxtFld.getText());
                    } else if (withdrawalButton.isSelected()) {
                        transactionType = "Withdrawal";
                        amount = Double.parseDouble(amountTxtFld.getText());
                    }

                    // Process Deposit or Withdrawal
                    String transaction = "";
                    switch (transactionType) {
                        case "Deposit":
                            selectedAccount.deposit(amount);
                            transaction = selectedAccount.logTransaction(transactionDate, "Deposit", amount);
                            break;
                        case "Withdrawal":
                            selectedAccount.withdrawal(amount);
                            transaction = selectedAccount.logTransaction(transactionDate, "Withdrawal", amount);
                            break;
                    }

                    // Update the transaction history display
                    StringBuilder historyText = new StringBuilder();
                    for (String trans : selectedAccount.getTransactionHistory()) {
                        historyText.append(trans).append("\n");
                    }
                    transactionHistoryArea.setText(historyText.toString());
                } else {
                    JOptionPane.showMessageDialog(addTransactionFrame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void showViewInfoPanel() {
        JFrame viewInfoFrame = new JFrame("View Customer and Account Info");
        viewInfoFrame.setSize(800, 600);
        viewInfoFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Account Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        viewInfoFrame.add(new JLabel("Account Number:"), gbc);
        gbc.gridx = 1;
        JTextField acctNumTxtFld = new JTextField(15);
        viewInfoFrame.add(acctNumTxtFld, gbc);

        // Submit Button
        gbc.gridx = 2;
        gbc.gridy = 0;
        JButton submitBtn = new JButton("Submit");
        viewInfoFrame.add(submitBtn, gbc);

        // Customer and Account Info Labels
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        viewInfoFrame.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        JLabel idLabel = new JLabel();
        viewInfoFrame.add(idLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        viewInfoFrame.add(new JLabel("SSN:"), gbc);
        gbc.gridx = 1;
        JLabel ssnLabel = new JLabel();
        viewInfoFrame.add(ssnLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        viewInfoFrame.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        JLabel lastNameLabel = new JLabel();
        viewInfoFrame.add(lastNameLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        viewInfoFrame.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        JLabel firstNameLabel = new JLabel();
        viewInfoFrame.add(firstNameLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        viewInfoFrame.add(new JLabel("Street Address:"), gbc);
        gbc.gridx = 1;
        JLabel streetLabel = new JLabel();
        viewInfoFrame.add(streetLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        viewInfoFrame.add(new JLabel("City:"), gbc);
        gbc.gridx = 1;
        JLabel cityLabel = new JLabel();
        viewInfoFrame.add(cityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        viewInfoFrame.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        JLabel stateLabel = new JLabel();
        viewInfoFrame.add(stateLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        viewInfoFrame.add(new JLabel("ZIP Code:"), gbc);
        gbc.gridx = 1;
        JLabel zipLabel = new JLabel();
        viewInfoFrame.add(zipLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        viewInfoFrame.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        JLabel phoneLabel = new JLabel();
        viewInfoFrame.add(phoneLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        viewInfoFrame.add(new JLabel("Account Type:"), gbc);
        gbc.gridx = 1;
        JLabel acctTypeLabel = new JLabel();
        viewInfoFrame.add(acctTypeLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        viewInfoFrame.add(new JLabel("Balance:"), gbc);
        gbc.gridx = 1;
        JLabel balanceLabel = new JLabel();
        viewInfoFrame.add(balanceLabel, gbc);

        // Transaction History Section
        gbc.gridx = 0;
        gbc.gridy = 12;
        viewInfoFrame.add(new JLabel("Transaction History:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        JTextArea transactionHistoryArea = new JTextArea(10, 40);
        transactionHistoryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionHistoryArea);
        viewInfoFrame.add(scrollPane, gbc);

        // Done Button
        JButton doneBtn = new JButton("Done");
        gbc.gridx = 2;
        gbc.gridy = 13;
        viewInfoFrame.add(doneBtn, gbc);

        viewInfoFrame.setVisible(true);

        // Add action listener for the submit button
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve and display customer and account info
                String accountNumber = acctNumTxtFld.getText();
                Account selectedAccount = null;
                Customer selectedCustomer = null;
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                        selectedAccount = accounts.get(i);
                        selectedCustomer = customers.get(i);
                        break;
                    }
                }
                if (selectedAccount != null && selectedCustomer != null) {
                    idLabel.setText(selectedCustomer.getID());
                    ssnLabel.setText(selectedCustomer.getSSN());
                    lastNameLabel.setText(selectedCustomer.getLastName());
                    firstNameLabel.setText(selectedCustomer.getFirstName());
                    streetLabel.setText(selectedCustomer.getStreet());
                    cityLabel.setText(selectedCustomer.getCity());
                    stateLabel.setText(selectedCustomer.getState());
                    zipLabel.setText(selectedCustomer.getZip());
                    phoneLabel.setText(selectedCustomer.getPhone());
                    acctTypeLabel.setText(selectedAccount.getAccountType());
                    balanceLabel.setText(String.format("$%.2f", selectedAccount.getBalance()));

                    // Populate transaction history
                    StringBuilder transactionHistoryText = new StringBuilder();
                    for (String transaction : selectedAccount.getTransactionHistory()) {
                        transactionHistoryText.append(transaction).append("\n");
                    }
                    transactionHistoryArea.setText(transactionHistoryText.toString());
                } else {
                    JOptionPane.showMessageDialog(viewInfoFrame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener for the done button
        doneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewInfoFrame.dispose(); // Close the window when done is clicked
            }
        });
    }
    
    

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        new BankAcctAppGUI(customers, accounts);
    }
}