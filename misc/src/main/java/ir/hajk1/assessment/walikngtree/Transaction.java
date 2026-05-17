package ir.hajk1.assessment.walikngtree;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private String transactionId;
    private LocalDate date;
    private BigDecimal amount;
    private String transactionType;
    private Long userId;

    // getters, constructors, etc.
    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Long getUserId() {
        return userId;
    }
}
