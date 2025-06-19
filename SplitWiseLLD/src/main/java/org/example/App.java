package org.example;

import org.example.entities.Expense;
import org.example.entities.Transaction;
import org.example.entities.User;
import org.example.expenseObserver.BalanceSheet;
import org.example.expenseObserver.ExpenseManager;
import org.example.split.Split;
import org.example.split.SplitFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        User alice = new User(1, "Alice", "alice@example.com");
        User bob = new User(2, "Bob", "bob@example.com");
        User charlie = new User(3, "Charlie", "charlie@example.com");

        ExpenseManager expenseManager = new ExpenseManager();
        BalanceSheet balanceSheet = new BalanceSheet();

        expenseManager.addObserver(balanceSheet);

        List<User> participants = new ArrayList<>();
        participants.add(alice);
        participants.add(bob);
        participants.add(charlie);

        Split equalSplit = SplitFactory.createSplit("EQUAL");
        Map<String, Object> splitDetails = new HashMap<>();
        Map<User, Double> dinnerShares = equalSplit.calculateSplit(60.0, participants, splitDetails);

        Expense dinnerExpense = new Expense(1, "Dinner", 60.0, alice, participants, dinnerShares);

        // Add the expense to the expense manager which will notify observers
        expenseManager.addExpense(dinnerExpense);

        // Bob pays for movie tickets - Create a percentage split expense
        Map<String, Object> percentageSplitDetails = new HashMap<>();
        Map<User, Double> percentages = new HashMap<>();
        percentages.put(alice, 40.0);
        percentages.put(bob, 30.0);
        percentages.put(charlie, 30.0);
        percentageSplitDetails.put("percentages", percentages);

        Split percentageSplit = SplitFactory.createSplit("PERCENTAGE");
        Map<User, Double> movieShares = percentageSplit.calculateSplit(45.0, participants, percentageSplitDetails);

        Expense movieExpense = new Expense(2, "Movie", 45.0, bob, participants, movieShares);

        // Add the movie expense to the expense manager
        expenseManager.addExpense(movieExpense);

        // Get individual balances
        System.out.println("Individual balances:");
        System.out.println("Alice's total balance: $" + balanceSheet.getTotalBalance(alice));
        System.out.println("Bob's total balance: $" + balanceSheet.getTotalBalance(bob));
        System.out.println("Charlie's total balance: $" + balanceSheet.getTotalBalance(charlie));

        // Print specific balances between users
        System.out.println("nPairwise balances:");
        System.out.println("Alice and Bob: $" + balanceSheet.getBalance(alice, bob));
        System.out.println("Alice and Charlie: $" + balanceSheet.getBalance(alice, charlie));
        System.out.println("Bob and Charlie: $" + balanceSheet.getBalance(bob, charlie));

        // Get the simplified settlements
        List<Transaction> settlements = balanceSheet.getSimplifiedSettlements();

        System.out.println("n=== OPTIMAL MINIMUM SETTLEMENTS ===");

        System.out.println(settlements);
    }
}
