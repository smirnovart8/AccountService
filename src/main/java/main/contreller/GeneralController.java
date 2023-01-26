package main.contreller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.service.AccountService;


@RestController()
@RequestMapping("/balance")
public class GeneralController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/{id}")
  public ResponseEntity getAmount(@PathVariable Integer id) {
    return new ResponseEntity<>(accountService.getAmount(id), HttpStatus.OK);

  }

  @PostMapping("/{id}")
  public ResponseEntity addAmount(@PathVariable Integer id, @RequestBody Long amount) {
    accountService.addAmount(id, amount);
    return new ResponseEntity<>(HttpStatus.OK);

  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity handler(IllegalArgumentException exp) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
