# 💸 Expense Tracker

A Java-based desktop application to track and manage personal expenses with category-wise organization and total calculation, built with Java Swing and MySQL.

## 📖 About the Project
Expense Tracker is a solo-built mini project designed to help users manage their daily expenses efficiently. Users can add expenses, organize them by category, and view their total spending — all stored persistently in a MySQL database.

## 🛠️ Tech Stack
| Layer | Technology |
|---|---|
| Frontend | Java Swing |
| Backend | Java (OOP) |
| Database | MySQL |
| DB Connectivity | JDBC |

## 🧠 OOP Concepts Used
- **Encapsulation** — Data hiding and getter/setter methods
- **Inheritance** — Reusable base classes across modules
- **Polymorphism** — Flexible method handling across components
- **Abstraction** — Interface-based design for clean architecture

## ✨ Features
### ➕ Add Expense
- Add new expenses with amount and description
- Assign each expense to a category
- Records saved directly to MySQL database

### 📂 Categories
- Organize expenses by category
- Filter and view expenses per category

### 💰 View Total
- Calculate and display total expenses
- Real time balance tracking

### 📋 Expense List
- View all recorded expenses in a clean list
- Easy to read and navigate
## 🗂️ Project Structure
ExpenseTracker/
├── src/
│   ├── main/         # Main entry point
│   ├── expense/      # Add and manage expenses
│   ├── category/     # Category management
│   ├── view/         # Display expenses and totals
│   └── db/           # JDBC database connection
└── README.md
## ⚙️ Getting Started
### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- IntelliJ IDEA (recommended)
- MySQL JDBC Driver

### Setup
1. Clone the repository
git clone https://github.com/mahmarani/ExpenseTracker.git
2. Create a MySQL database and import the schema
3. Update JDBC credentials in the db connection file
4. Open in IntelliJ IDEA and run the main class

## 👩‍💻 Developer
Built solo by **Mahma Rani** — CS Student at Sukkur IBA University

## 📄 License
This project is open source and available under the MIT License.







