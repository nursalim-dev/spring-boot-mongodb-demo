package com.nursalim.springboot.mongodb.demo.controller;

import com.nursalim.springboot.mongodb.demo.model.Expense;
import com.nursalim.springboot.mongodb.demo.service.ExpenseService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
