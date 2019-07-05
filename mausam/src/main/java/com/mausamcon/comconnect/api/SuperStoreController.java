/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/

package com.mausamcon.comconnect.api;

import com.mausamcon.comconnect.model.SuperStore;
import com.mausamcon.comconnect.persistence.SuperStoreRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("comconnect/superstores")
public class SuperStoreController {
    private SuperStoreRepository superStoreRepository;

    public SuperStoreController(SuperStoreRepository superStoreRepository) {
        this.superStoreRepository = superStoreRepository;
    }
    //INSERT THE SUPERSTORE
    @PostMapping
    public void insert(@RequestBody SuperStore superStore){
        this.superStoreRepository.insert(superStore);

    }
    //UPDATE SUPERSTORE
    @PutMapping
    public void update(@RequestBody SuperStore superStore) {
        this.superStoreRepository.save(superStore);
    }
    //DELETE THE SUPERSTORE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.superStoreRepository.deleteById(id);
    }
    //GET ALL SUPERSTORES
    @GetMapping("/all")
    public Collection<SuperStore> all(){
        Sort sortByNameAsc = Sort.by("Name").ascending();
        Collection<SuperStore> superStores = this.superStoreRepository.findAll(sortByNameAsc);
        return superStores;
    }
    @GetMapping("/{id}")
    public SuperStore byId(@PathVariable String id){
        SuperStore superStore= this.superStoreRepository.findById(id).orElse(null);
        return superStore;
    }
    //GET ALL SUPERSTORE BY NAME
    @GetMapping("/byName/{name}")
    public Collection<SuperStore> byName(@PathVariable String name) {
        return this.superStoreRepository.findALlByNameContains(name);
    }

    @GetMapping("byState/{byState}")
    public Collection<SuperStore> byState(@PathVariable String byState) {
        return superStoreRepository.findAllByOrdersByState(byState);
    }


}
