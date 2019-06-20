package co.japo.demo.buying_analytics.kafka;

import co.japo.demo.buying_analytics.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionsConsumer {

    private TransactionService transactionService;

    public TransactionsConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @StreamListener(TransactionsBinding.TRANSACTIONS_IN)
    public void transactionsIn(@Payload TransactionEvent event) {
        log.info("Received a event: {}", event);
        transactionService.add(event);
    }
}
