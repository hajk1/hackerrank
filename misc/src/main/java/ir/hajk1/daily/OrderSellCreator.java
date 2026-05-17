package ir.hajk1.daily;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSellCreator {

    double from;
    double to;
    double marketPrice;

    int orders;
    long money;

    OrderType orderType;

    public static void main(String[] args) {

        OrderSellCreator oc = OrderSellCreator.builder()
            .from(0.6665)
            .to(0.6900)
            .money(20000)
            .orders(10)
            .orderType(OrderType.STX_USDT_P)
            .marketPrice(0.6665)
            .build();
        List<Order> list = oc.generateOrders();
        int i = 1;
        for (Order order : list) {
            System.out.println(i++ + " ,order = " + order);
        }
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private List<Order> generateOrders() {
        double smallDiff = 0.0022;
        double diff = round(to - from, 4);
        //1.15-1.10=0.05
        double hip = round(diff / orders, 4);
        //0.05/10 = 0.005
        int fortyPercentAmount = (int) (money * 40 / 100);
        int sixtyPercentAmount = (int) (money * 60 / 100);
        int numberOfLow = orders * 60 / 100;
        int numberOfHigh = orders - numberOfLow;
        int lowOrderValue = fortyPercentAmount / numberOfLow;
        int highOrderValue = sixtyPercentAmount / numberOfHigh;
//        System.out.println("numberOfLow = " + numberOfLow);
//        System.out.println("numberOfHigh = " + numberOfHigh);
        List<Order> list = new ArrayList<>();
        System.out.println("SHORT:" + orderType);
        System.out.println("AMOUNT=" + money);
        System.out.println("from = " + from);
        System.out.println("to = " + to);
        System.out.println("hip = " + hip);
        from = round(from + hip, 4);
        for (int i = 0; i < numberOfLow; i++) {
            list.add(new Order(round(from - smallDiff, 4), lowOrderValue, marketPrice));
            from = round(from + hip, 4);
        }
        for (int i = 0; i < numberOfHigh; i++) {
            list.add(new Order(round(from - smallDiff, 4), highOrderValue, marketPrice));
            from = round(from + hip, 4);
        }
        return list;
    }
}
