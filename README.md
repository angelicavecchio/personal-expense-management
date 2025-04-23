# Personal Expense Manager (Java CLI)

This is a command-line application developed in Java for managing personal expenses. The program allows users to register daily expenses by category, view and filter them, compute total spending, and optionally export data to a file. It serves as a practical example of applying object-oriented programming principles, console-based user interaction, and basic file operations in Java.

## Features

- Add new expenses with description, amount, category, and date
- View all registered expenses
- Calculate the total amount spent
- Filter expenses by category
- Export expenses to a text/csv file


## Technologies Used

- Java 17+
- LocalDate and DateTimeFormatter (Java Time API)
- ArrayList for in-memory storage
- FileWriter and File class for file export
- Scanner for user input
- exception handling (e.g., input validation)

## Project Structure
/PersonalExpenseManager ├── App.java // Entry point and user interface ├── Expense.java // Expense data model ├── Management.java // Core logic for managing expenses ├── example.txt // (Optional) Example export file └── README.md

