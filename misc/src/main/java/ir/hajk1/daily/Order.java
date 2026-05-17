package ir.hajk1.daily;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {

    double amount;
    double number;

    double market;

    @Override
    public String toString() {
        return "Order{" +
            "amount=" + amount +
            ", number=" + number +
            ", order=" + number / market +
            '}';
    }
}
