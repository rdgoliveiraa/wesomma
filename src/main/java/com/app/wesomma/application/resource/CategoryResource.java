package com.app.wesomma.application.resource;

import com.app.wesomma.domain.category.Category;
import com.app.wesomma.domain.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category findById(@PathVariable(value = "id") Integer id) {
        return categoryRepository.findById(id);
    }

    @GetMapping("/categories/{type}")
    public List<Category> findByType(@PathVariable(value = "type") String type) {
        return categoryRepository.findByType(type);
    }

    @PostMapping("/category")
    public Category save(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/category")
    public void delete(@RequestBody Category category) {
        categoryRepository.delete(category);
    }

    @PutMapping("/category")
    public Category update(@RequestBody Category category) {
        return categoryRepository.save(category);
    }


}
