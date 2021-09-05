package com.app.wesomma.application.resource;

import com.app.wesomma.domain.transaction.TypeTransaction;
import com.app.wesomma.domain.transaction.TypeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TypeTransactionResource {

    @Autowired
    TypeTransactionRepository typeTransactionRepository;

    @GetMapping("/typetransactions")
    public List<TypeTransaction> findAll(){
        return typeTransactionRepository.findAll();
    }

    @GetMapping("/typetransaction/{id}")
    public TypeTransaction findById(@PathVariable(value = "id") Integer id) {
        return typeTransactionRepository.findById(id);
    }

    @PostMapping("/typetransaction")
    public TypeTransaction save(@RequestBody TypeTransaction typeTransaction) { return typeTransactionRepository.save(typeTransaction); }

    @DeleteMapping("/typetransaction")
    public void delete(@RequestBody TypeTransaction typeTransaction) { typeTransactionRepository.delete(typeTransaction); }

    @PutMapping("/typetransaction")
    public TypeTransaction update(@RequestBody TypeTransaction typeTransaction) {
        return typeTransactionRepository.save(typeTransaction);
    }
}
