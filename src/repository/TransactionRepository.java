package repository;

import domain.Transaction;

import java.util.*;

public class TransactionRepository {
    private final Map<String, List<Transaction>> txByAccount = new HashMap<>();

    public void add(Transaction transaction) {
//        txByAccount.computeIfAbsent(transaction.getAccountNumber(), k -> new ArrayList<>()).add(transaction);
        List<Transaction> list = txByAccount.computeIfAbsent(transaction.getAccountNumber(), k -> new ArrayList<>());
        list.add(transaction);
    }

    public List<Transaction> finByAccount(String account) {
        return new ArrayList<>(txByAccount.getOrDefault(account, Collections.emptyList()));
    }
}
