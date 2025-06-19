package org.example.split;

import org.example.entities.User;

import java.util.List;
import java.util.Map;

public interface Split {
    Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails);
}
