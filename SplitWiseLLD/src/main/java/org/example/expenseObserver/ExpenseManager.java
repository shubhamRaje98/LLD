package org.example.expenseObserver;

import org.example.entities.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager implements ExpenseSubject{
    List<ExpenseObserver> observers = new ArrayList<>();
    List<Expense> expenses = new ArrayList<>();
    @Override
    public void addObserver(ExpenseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ExpenseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyExpenseAdded(Expense expense) {
        for(ExpenseObserver observer: observers){
            observer.onExpenseAdded(expense);
        }
    }

    @Override
    public void notifyExpenseUpdated(Expense expense) {
        for(ExpenseObserver observer: observers){
            observer.onExpenseUpdated(expense);
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        notifyExpenseAdded(expense);
    }

    public void updateExpense(Expense expense) {
        // Find and replace the expense with the same ID in the list
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == expense.getId()) { // Check if the IDs match
                expenses.set(i, expense); // Replace the old expense with the updated one
                notifyExpenseUpdated(expense); // Notify all observers about the update
                return; // Exit the method after updating
            }
        }
        throw new IllegalArgumentException("Expense with ID " + expense.getId() + " not found.");
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
}
