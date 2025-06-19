package org.example.split;

import org.example.entities.User;
import org.example.split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements Split {
    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails) {
        double amountPerPerson = amount/participants.size();
        Map<User, Double> splits = new HashMap<>();

        for(User user: participants){
            splits.put(user, amountPerPerson);
        }
        return splits;
    }
}
