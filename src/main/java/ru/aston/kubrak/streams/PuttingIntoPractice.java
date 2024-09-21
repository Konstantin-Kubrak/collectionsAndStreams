package ru.aston.kubrak.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> homeWork1 = transactions.stream().filter(e -> e.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
        List<String> homeWork2 = transactions.stream().map(e -> e.getTrader().getCity()).distinct().collect(Collectors.toList());
        List<Trader> homeWork3 = transactions.stream().map(Transaction::getTrader).filter(e -> e.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        List<String> homeWork4 = transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted().collect(Collectors.toList());
        Trader homeWork5 = transactions.stream().map(Transaction::getTrader).filter(e -> e.getCity().equals("Milan")).findAny().orElse(null);
        Integer homeWork6 = transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(0, Integer::sum);
        Integer homeWork7 = transactions.stream().map(Transaction::getValue).max(Integer::compareTo).orElse(0);
        Integer homeWork8 = transactions.stream().map(Transaction::getValue).min(Integer::compareTo).orElse(0);

    }
}
