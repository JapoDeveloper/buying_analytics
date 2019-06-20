package co.japo.demo.buying_analytics.kafka;

import co.japo.demo.buying_analytics.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    private String user;
    private String product;
    private double price;
    private int count;

    public TransactionEvent(Transaction transaction) {
        this.user = transaction.getUser().getName();
        this.product = transaction.getProduct().getName();
        this.price = transaction.getProduct().getPrice();
        this.count = transaction.getBuyCount();
    }

    public double getTotal() {
        return price * count;
    }

    public String key() {
        return this.user + "-" + this.product;
    }
}
