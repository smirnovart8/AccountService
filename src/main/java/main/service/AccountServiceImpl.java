package main.service;

import java.util.Optional;
import main.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import main.repository.AccountRepository;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository repository;

  @Override
  public Long getAmount(Integer id) {
    Optional<Account> optionalAccount;
    optionalAccount = repository.findById(id);
    if (optionalAccount.isPresent()) {
      return optionalAccount.get().getBalance();
    } else {
      throw new IllegalArgumentException();
    }

  }

  @Override
  public void addAmount(Integer id, Long value) {

    Optional<Account> optionalAccount;
    optionalAccount = repository.findById(id);
    if (optionalAccount.isPresent()) {
      repository.save(new Account(id, (optionalAccount.get().getBalance()) + value));
    } else {
      throw new IllegalArgumentException();
    }


  }

}
