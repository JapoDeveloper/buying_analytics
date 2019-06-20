package co.japo.demo.buying_analytics.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TransactionsBinding {
    String TRANSACTIONS_OUT = "trans_out";
    String TRANSACTIONS_IN = "trans_in";

    @Output(TRANSACTIONS_OUT)
    MessageChannel transactionsOut();

    @Input(TRANSACTIONS_IN)
    SubscribableChannel transactionsIn();
}
