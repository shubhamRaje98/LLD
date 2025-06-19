package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Expense {
    double id;
    String description;
    double amount;
    User payer;
    List<User> participant;
    Map<User, Double> shares;
}
