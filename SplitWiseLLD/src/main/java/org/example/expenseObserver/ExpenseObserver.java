package org.example.expenseObserver;

import org.example.entities.Expense;

public interface ExpenseObserver {
    void onExpenseAdded(Expense expense);
    void onExpenseUpdated(Expense expense);
}
