package com.example.MinorProj1.Controllers;


import com.example.MinorProj1.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issuetxn")

    public void setTransactionService(){
         transactionService.issuetxn();
    }



}
