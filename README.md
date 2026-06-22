# Cognifyz Java Development Internship

![Java](https://img.shields.io/badge/Java-17-red)
![Internship](https://img.shields.io/badge/Internship-Completed-success)
![Level](https://img.shields.io/badge/Level-1%2C2%2C3-blue)

## Overview

This repository contains a comprehensive collection of Java projects developed as part of the **Cognifyz Technologies Java Development Internship**. The projects demonstrate proficiency in core Java concepts including object-oriented programming, data structures, algorithms, multi-threading, networking, file I/O, GUI development, and API integration.

## Tech Stack

- **Language:** Java 17 (LTS)
- ** Paradigms:** OOP, Procedural, Concurrent Programming
- **Libraries:** Java Standard Library (`java.io`, `java.net`, `java.util`, `javax.swing`, `java.util.concurrent`)
- **Tools:** Git, PowerShell/CMD

## Repository Structure

```
Cognifyz/
├── Level1/                    # Fundamentals (4 tasks)
│   ├── TemperatureConverter.java
│   ├── PalindromeChecker.java
│   ├── StudentGradeCalculator.java
│   └── RandomPasswordGenerator.java
├── Level2/                    # Intermediate (3 tasks)
│   ├── TicTacToe.java
│   ├── PasswordStrengthChecker.java
│   └── FileEncryptionDecryption.java
├── Level3/                    # Advanced (5 tasks)
│   ├── ChatServer.java        # Socket-based server
│   ├── ChatClient.java        # Socket-based client
│   ├── MultiThreadedApplication.java
│   ├── DesktopApplication.java
│   └── CurrencyConverter.java
├── README.md
├── Level1/README.md
├── Level2/README.md
└── Level3/README.md
```

## Project Descriptions

### Level 1 — Fundamentals

| Task | Project | Description | Key Skills |
|------|---------|-------------|-----------|
| 1 | **Temperature Converter** | Converts temperatures between Celsius and Fahrenheit based on user input. | I/O, arithmetic, conditionals |
| 2 | **Palindrome Checker** | Determines if a word or phrase is a palindrome (ignoring spaces and punctuation). | String manipulation, loops |
| 3 | **Student Grade Calculator** | Calculates average grade from a user-specified number of grades. | Loops, arrays, arithmetic |
| 4 | **Random Password Generator** | Generates secure passwords with configurable length and character types. | Random generation, string ops |

### Level 2 — Intermediate

| Task | Project | Description | Key Skills |
|------|---------|-------------|-----------|
| 1 | **Tic-Tac-Toe Game** | Two-player console game with move validation, win/draw detection, and replay support. | 2D arrays, game logic |
| 2 | **Password Strength Checker** | Evaluates password strength based on length, character variety, and complexity. | Regex, string analysis |
| 3 | **File Encryption/Decryption** | Encrypts/decrypts text files using a Caesar cipher algorithm. | File I/O, encryption logic |

### Level 3 — Advanced

| Task | Project | Description | Key Skills |
|------|---------|-------------|-----------|
| 1 | **Chat Application** | Real-time client-server chat using Java Sockets and multi-threading. | Networking, sockets, threads |
| 2 | **Multi-threaded Application** | Demonstrates concurrency with increment/decrement threads synchronized via `ReentrantLock`. | Concurrency, locks, synchronization |
| 3 | **Desktop Application** | Functional calculator GUI built with Java Swing and event-driven programming. | Swing, event handling, GUI |
| 4 | **Currency Converter** | Fetches live exchange rates via API and performs currency conversion. | HTTP, JSON parsing, API integration |

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Git

## Installation

```powershell
# Clone the repository
git clone https://github.com/siddhartha-kodipunjula/Cognifyz-Technologies.git
cd Cognifyz
```

## Compilation

Navigate to each level directory and compile:

```powershell
cd Level1
javac *.java
cd ..

cd Level2
javac *.java
cd ..

cd Level3
javac *.java
cd ..
```

## Running

### Level 1
```powershell
cd Level1
java TemperatureConverter
java PalindromeChecker
java StudentGradeCalculator
java RandomPasswordGenerator
```

### Level 2
```powershell
cd Level2
java TicTacToe
java PasswordStrengthChecker
java FileEncryptionDecryption
```

### Level 3
```powershell
cd Level3

# Chat (requires two separate terminals)
java ChatServer   # Terminal 1
java ChatClient   # Terminal 2

# Other applications
java MultiThreadedApplication
java DesktopApplication
java CurrencyConverter
```

## Usage Notes

- **Chat Application:** Start `ChatServer` first. Open a second terminal and run `ChatClient`. Type messages in either terminal to communicate.
- **File Encryption/Decryption:** Provide full file paths when prompted.
- **Currency Converter:** Requires an active internet connection to fetch live rates.
- **Desktop Application:** Opens a Swing GUI window.

## Internship Details

- **Company:** Cognifyz Technologies
- **Program:** Java Development Internship
- **Levels Completed:** Level 1, Level 2, Level 3 (all 10 tasks)

## Learning Outcomes

- Mastery of core Java syntax and control structures
- Implementation of algorithms and data structures
- Secure coding practices and encryption concepts
- Network programming with Sockets
- Concurrency and thread synchronization
- GUI development with Swing
- External API integration and JSON parsing

## License

This project is developed for educational purposes as part of an internship program at Cognifyz Technologies.

---

>Built by **Siddhartha Kodipunjula** for Cognifyz Technologies Internship Program
