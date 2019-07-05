/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/

package com.mausamcon.comconnect.api;

import com.mausamcon.comconnect.model.Products;
import com.mausamcon.comconnect.persistence.ProductsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("comconnect/products")
public class ProductsController {
    private ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //INSET PRODUCTS
    @PostMapping
    public void insert(@RequestBody Products products) {
        this.productsRepository.insert(products);

    }

    //UPDATE PRODUCTS
    @PutMapping
    public void update(@RequestBody Products products) {
        this.productsRepository.save(products);
    }

    //GET ALL PRODUCTS
    @GetMapping("all")
    public Collection<Products> allusers() {
        return this.productsRepository.findAll();
    }
    //DELETE PRODUCT BY THIER ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.productsRepository.deleteById(id);
    }

    //GET ALL PRODUCTS (SORTED BY THEIR PRICE)
    @GetMapping("sortedByPrice")
    public Collection<Products> all() {
        Sort sortByPriceAsc = Sort.by("price").ascending();
        Collection<Products> products = this.productsRepository.findAll(sortByPriceAsc);
        return products;
    }

    //GET PRODUCT BY THEIR ID
    @GetMapping("/{id}")
    public Products byId(@PathVariable String id) {
        Products products = this.productsRepository.findById(id).orElse(null);
        return products;
    }




    //GET ALL PRODUCT BY THEIR NAME
    @GetMapping("/byName/{name}")
    public Collection<Products> byState(@PathVariable String name) {
        return this.productsRepository.findALlByNameContains(name);
    }
}
