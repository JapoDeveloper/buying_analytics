package co.japo.demo.buying_analytics.kafka;

import co.japo.demo.buying_analytics.domain.Transaction;
import co.japo.demo.buying_analytics.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TransactionsProducer implements ApplicationRunner {

    private TransactionService transactionService;
    private MessageChannel transactionsOutput;

    public TransactionsProducer(TransactionService transactionService, TransactionsBinding transactionsBinding) {
        this.transactionService = transactionService;
        this.transactionsOutput = transactionsBinding.transactionsOut();
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Runnable runnable = () -> {
            Transaction transaction = transactionService.dummyTransaction();
            TransactionEvent event = new TransactionEvent(transaction);
            Message<TransactionEvent> message = MessageBuilder
                    .withPayload(event)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .setHeader(KafkaHeaders.MESSAGE_KEY, event.key().getBytes())
                    .build();
            try {
                transactionsOutput.send(message);
                log.info("Sent: {}", event);
            } catch (Exception ex) {
                log.error("Error occurred trying to send transaction message", ex);
            }
        };
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable, 1, 10, TimeUnit.SECONDS);
    }
}
