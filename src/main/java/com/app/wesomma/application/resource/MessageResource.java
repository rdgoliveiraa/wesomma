package com.app.wesomma.application.resource;

import com.app.wesomma.domain.message.MenssageRepository;
import com.app.wesomma.domain.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class MessageResource {

    @Autowired
    MenssageRepository menssageRepository;

    @GetMapping("/menssages")
    public List<Message> findAll(){
        return menssageRepository.findAll();
    }

    @GetMapping("/menssage/{id}")
    public Message findById(@PathVariable(value = "id") Integer id) {
        return menssageRepository.findById(id);
    }

    @PostMapping("/menssage")
    public Message save(@RequestBody Message message) {
        return menssageRepository.save(message);
    }

    @DeleteMapping("/menssage")
    public void delete(@RequestBody Message message) {
        menssageRepository.delete(message);
    }

    @PutMapping("/menssage")
    public Message update(@RequestBody Message message) {
        return menssageRepository.save(message);
    }
}
