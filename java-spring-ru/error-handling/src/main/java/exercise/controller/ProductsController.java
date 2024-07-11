package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "")
    public List<Product> index() {
        return productRepository.findAll();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // BEGIN
    @GetMapping(path = "/{id}") // Вывод страницы
    public Product show(@PathVariable String id) {
        return productRepository.findAll().stream()
                .filter(p -> p.getId() == Long.valueOf(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
    }

    @PutMapping(path = "/{id}") // Обновление страницы
    public Product update(@PathVariable String id, @RequestBody Product data) {
        var product = productRepository.findAll().stream()
                .filter(p -> p.getId() == Long.valueOf(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        product.setTitle(data.getTitle());
        product.setPrice(data.getPrice());
        return data;
    }
    // END

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}