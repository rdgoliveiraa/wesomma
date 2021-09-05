package com.app.wesomma.application.resource;

import com.app.wesomma.domain.tags.Tag;
import com.app.wesomma.domain.tags.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TagResource {

    @Autowired
    TagRepository tagRepository;

    @GetMapping("/tags")
    public List<Tag> findAll(){ return tagRepository.findAll();  }

    @GetMapping("/tag/{id}")
    public Tag findById(@PathVariable(value = "id") Integer id) {
        return tagRepository.findById(id);
    }

    @PostMapping("/tag")
    public Tag save(@RequestBody Tag tags) {
        return tagRepository.save(tags);
    }

    @DeleteMapping("/tag")
    public void delete(@RequestBody Tag tags) {
        tagRepository.delete(tags);
    }

    @PutMapping("/tag")
    public Tag update(@RequestBody Tag tags) {
        return tagRepository.save(tags);
    }

}
