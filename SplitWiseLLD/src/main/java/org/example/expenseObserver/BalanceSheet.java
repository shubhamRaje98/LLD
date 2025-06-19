package org.example.expenseObserver;

import org.example.entities.Expense;
import org.example.entities.Transaction;
import org.example.entities.User;
import org.example.entities.UserPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet implements ExpenseObserver{

    Map<UserPair, Double> balances = new HashMap<>();
    @Override
    public void onExpenseAdded(Expense expense) {
        updateBalance(expense);
    }

    @Override
    public void onExpenseUpdated(Expense expense) {
        updateBalance(expense);
    }

    public double getBalance(User user1, User user2) {
        // Represent the balance both ways (user1 -> user2 and user2 -> user1)
        UserPair pair1 = new UserPair(user1, user2);
        UserPair pair2 = new UserPair(user2, user1);
        // Retrieve balances in both directions and calculate the net
        double balance1 = balances.getOrDefault(pair1, 0.0);
        double balance2 = balances.getOrDefault(pair2, 0.0);
        return balance1 - balance2;
    }

    public void updateBalance(Expense expense){
        User payer = expense.getPayer();
        Map<User, Double> shares = expense.getShares();

        for(Map.Entry<User, Double> entry: shares.entrySet()){
            User participant = entry.getKey();
            Double amount = entry.getValue();

            if(!payer.equals(participant)){
                UserPair userPair = new UserPair(participant, payer);

                Double currentBalance = shares.getOrDefault(participant, 0.0);
                balances.put(userPair, currentBalance+amount);
            }
        }
    }

    public double getTotalBalance(User user){
        double total = 0.0;
        for(Map.Entry<UserPair, Double> entry: balances.entrySet()){
            UserPair userPair = entry.getKey();
            Double amount = entry.getValue();

            if(userPair.getUser1().equals(user)){
                total -= amount;
            }else if(userPair.getUser2().equals(user)){
                total += amount;
            }
        }
        return total;
    }

    public List<Transaction> getSimplifiedSettlements(){
        Map<User, Double> netBalances = new HashMap<>();

        for(Map.Entry<UserPair, Double> entry: balances.entrySet()){
            UserPair userPair = entry.getKey();
            Double amount = entry.getValue();

            User debtor = userPair.getUser1();
            User creditor = userPair.getUser2();

            netBalances.put(debtor, netBalances.getOrDefault(debtor, 0.0) - amount);
            netBalances.put(creditor, netBalances.getOrDefault(creditor, 0.0) + amount);
        }

        List<User> debtors = new ArrayList<>();
        List<User> creditors = new ArrayList<>();

        for(Map.Entry<User, Double> entry: netBalances.entrySet()){
            User user = entry.getKey();
            Double balance = entry.getValue();

            if(balance<0){
                debtors.add(user);
            }else if(balance>0){
                creditors.add(user);
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        int debInd = 0;
        int credInd = 0;

        while(debInd < debtors.size() && credInd < creditors.size()){
            User debtor = debtors.get(debInd);
            User creditor = creditors.get(credInd);

            double debtorBalance = netBalances.get(debtor);
            double creditorBalance = netBalances.get(creditor);

            double transferAmt = Math.min(Math.abs(debtorBalance), creditorBalance);

            transactions.add(new Transaction(debtor, creditor, transferAmt));

            netBalances.put(debtor, debtorBalance + transferAmt);
            netBalances.put(creditor, creditorBalance - transferAmt);

            if(Math.abs(netBalances.get(debtor)) < 0.001){
                debInd++;
            }
            if(Math.abs(netBalances.get(creditor)) < 0.001){
                credInd++;
            }
        }

        return transactions;
    }
}
