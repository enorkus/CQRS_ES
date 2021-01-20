package com.enorkus.cqrses.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AccountCreatedEvent {
    private UUID id;
    private BigDecimal initialBalance;
    private String owner;
}