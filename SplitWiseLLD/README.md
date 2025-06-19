### Low-Level Design: Splitwise Expense Sharing System

A Splitwise expense sharing system is designed to efficiently track shared expenses
among a group of people, calculate balances, and determine the min number of transactions
needed to settle all debts. The system need to handle multiple users, various expense
types, and provide an optimal solution for debt settlement. The system should be reliable
maintainable, and provide an intuitive interface for expense management and balance calculation.

### Rules of the system:
#### The system maintains a record of users and their associated transactions.
#### Expense can be split in various ways: equally, percentage-bases, custom amounts.
#### The system tracks who owes whom and how much

### Operations:

#### Users can add expenses, specifying payers ,participants, and split methods
#### The system calculates balances between user after each transaction
#### User can view their total balance, as well as detailed balances with specific users.
#### The system provides a simplified settlement plan with min transactions.

Features:

• The system optimizes debt settlement to minimize the number of transactions.

• Transaction history is maintained for auditing purposes.

Interview Setting 🤝
Point 1: Introduction and Vague Problem Statement:
Interviewer: Let's start with a basic problem statement. Design a Splitwise-like expense sharing system.

Candidate: I understand that we need to design a system similar to Splitwise, which helps groups of people track shared expenses and settle accounts.

Here's my high-level understanding:

• Users can record expenses where one person pays and multiple people owe that person.

• The system tracks balances between users, calculating who owes whom.

• The system should provide an optimal way to settle all debts with minimal transactions.

• Users should be able to view their total balance and balances with specific users.

Is this aligned with your expectations?

Interviewer: Yes, that's correct. Please proceed with your approach.

Candidate: Before diving into the design, I'd like to clarify a few requirements:

• What types of expense splits should we support?

• How should the system handle multi-person debt settlement?

• What kinds of operations do we need to prioritize?

Point 2: Clarifying Requirements:
Interviewer: We want a system that:

• Supports basic equal splits for now, but should be extensible to other split types.

• Calculates the minimum number of transactions to settle all debts.

• Handles tracking of expenses and balances efficiently.


Candidate: To summarize, the key requirements are:

• A system that tracks expenses and participants.

• Support for equal splits initially, with extensibility for other split types.

• Balance calculation between users.

• An algorithm to minimize the number of transactions for settling debts.

• User interface for adding expenses and viewing balances.


Interviewer: Perfect, let's proceed.


Point 3: Identifying Key Components:
Candidate: Now that we have the requirements, let's identify the key components of our Splitwise system:

• User: Represents a user in the system with a unique identifier.

• Expense: Contains details about who paid, how much, and how it's split.

• Split: Interface for different split types (equal, percentage, etc.).

• Group: Optional component for organizing expenses among specific sets of users.

• Balance Sheet: Tracks who owes whom and calculates simplified settlements.

• Transaction: Represents a payment between users for settling debts.


Interviewer: That sounds good. Let's proceed with the design details.


Point 4: Design Challenges:
Interviewer: What design challenges do you anticipate?

Candidate: The key challenges for the Splitwise system include:

• Balance Management: Efficiently tracking balances between multiple users.

• Optimization Problem: Finding the minimum number of transactions to settle all debts.

• Split Type Extensibility: Designing a flexible system for different split types like equal, unequal and percentage based splits.

• Transaction Management: Handling the creation and tracking of transactions.

• Data Consistency: Ensuring balance calculations are correct and consistent.


Point 5: Approach:
Interviewer: How would you approach these challenges?

Candidate: I propose using design patterns effectively. Here are my strategies:

1. Factory Pattern for Split Types:

○ Centralizes split type creation logic.

○ Allows for easy addition of new split types (equal, percentage, exact).

○ Keeps split type creation separate from expense management.


2. Observer Pattern for Balance Updates:

○ Notifies appropriate components when new expenses are added.

○ Ensures balance calculations stay up-to-date.

○ Decouples expense creation from balance calculation.


Interviewer: That sounds like a solid approach. Let's delve into the implementation details.


Point 6: Implementation:
Interviewer: Ready to discuss implementation?


Candidate: Yes. I'll focus on implementing the design patterns we discussed and show how they work together in the Splitwise system:

Splitwise Design with Design Patterns :
Article image : https://codewitharyan.com/tech-blogs/design-splitwise

user, expense, split, group, balance sheet, transaction