package com.enorkus.cqrses.controller;

import com.enorkus.cqrses.domain.BankAccount;
import com.enorkus.cqrses.domain.dto.AccountCreationDTO;
import com.enorkus.cqrses.domain.dto.MoneyAmountDTO;
import com.enorkus.cqrses.service.AccountCommandService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Bank Account Commands", description = "Bank Account Commands API")
@AllArgsConstructor
public class AccountCommandController {
    private final AccountCommandService accountCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<BankAccount> createAccount(@RequestBody AccountCreationDTO creationDTO) {
        return this.accountCommandService.createAccount(creationDTO);
    }

    @PutMapping(value = "/credit/{accountId}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountId") String accountId,
                                                          @RequestBody MoneyAmountDTO moneyCreditDTO) {
        return this.accountCommandService.creditMoneyToAccount(accountId, moneyCreditDTO);
    }

    @PutMapping(value = "/debit/{accountId}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountId") String accountId,
                                                           @RequestBody MoneyAmountDTO moneyDebitDTO) {
        return this.accountCommandService.debitMoneyFromAccount(accountId, moneyDebitDTO);
    }
}
