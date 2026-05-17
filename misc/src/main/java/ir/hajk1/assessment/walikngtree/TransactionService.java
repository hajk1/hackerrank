package ir.hajk1.assessment.walikngtree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {

    public static void main(String[] args) {
        TransactionService transactionService = new TransactionService();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction());
        transactionService.getUserDebitStats(transactions);
    }

    public Map<Long, UserStats> getUserDebitStats(List<Transaction> transactions) {
        LocalDate sixtyDaysAgo = LocalDate.now().minusDays(60);

        return transactions.stream()
            // filter DEBIT
            .filter(t -> "DEBIT".equalsIgnoreCase(t.getTransactionType()))
            // filter date after (or equal to) 60 days ago
            .filter(t -> !t.getDate().isBefore(sixtyDaysAgo))
            // group by userId
            .collect(Collectors.groupingBy(
                Transaction::getUserId,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        BigDecimal total = list.stream()
                            .map(Transaction::getAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                        BigDecimal avg = list.isEmpty()
                            ? BigDecimal.ZERO
                            : total.divide(
                                BigDecimal.valueOf(list.size()),
                                2,                       // scale
                                RoundingMode.HALF_UP     // rounding
                            );

                        return new UserStats(total, avg);
                    }
                )
            ));
    }
}