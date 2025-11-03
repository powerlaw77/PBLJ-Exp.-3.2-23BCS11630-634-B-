package com.example;

import com.example.config.AppConfig;
import com.example.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService service = context.getBean(BankService.class);
        try {
            service.transfer(1, 2, 500);
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        context.close();
    }
}