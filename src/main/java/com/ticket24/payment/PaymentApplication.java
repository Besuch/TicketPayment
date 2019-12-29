package com.ticket24.payment;

import com.ticket24.payment.entity.Ticket;
import com.ticket24.payment.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(TicketRepository ticketRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Ticket ticket = new Ticket("01/02/2020", (1 + i));
                ticketRepository.save(ticket);
            }
        };
    }
}
