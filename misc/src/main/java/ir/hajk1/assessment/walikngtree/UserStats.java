package ir.hajk1.assessment.walikngtree;

import java.math.BigDecimal;

public class UserStats {

    private final BigDecimal totalAmount;
    private final BigDecimal avgAmount;

    public UserStats(BigDecimal totalAmount, BigDecimal avgAmount) {
        this.totalAmount = totalAmount;
        this.avgAmount = avgAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getAvgAmount() {
        return avgAmount;
    }
}