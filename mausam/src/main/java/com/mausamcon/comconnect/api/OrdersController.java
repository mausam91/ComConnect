/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.api;

import com.mausamcon.comconnect.model.OrderStatus;
import com.mausamcon.comconnect.model.Orders;
import com.mausamcon.comconnect.persistence.OrdersRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("comconnect/orders")
public class OrdersController {

    private OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    //INSERT ORDER
    @PostMapping
    public void insert(@RequestBody Orders order) {
        this.ordersRepository.insert(order);

    }

    //UPDATE OREDER
    @PutMapping
    public void update(@RequestBody Orders order) {
        this.ordersRepository.save(order);
    }

    //DELETE ORDER
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        this.ordersRepository.deleteById(id);
    }

    //GET ALL ORDER
    @GetMapping("allorder")
    public Collection<Orders> allorder() {

        return this.ordersRepository.findAll();
    }

    //GET ALL ORDER (SORTED BY DATE ASCENDING)
    @GetMapping("all")
    public Collection<Orders> all() {
        Sort sortByOrderDateAsc = Sort.by("orderDate").ascending();

        Collection<Orders> ordersdetails = this.ordersRepository.findAll(sortByOrderDateAsc);
        return ordersdetails;
    }

    //GET ORDERS BY ID
    @GetMapping("{id}")
    public Orders byId(@PathVariable String id) {
        Orders orders = this.ordersRepository.findById(id).orElse(null);
        return orders;
    }
    @GetMapping("/byOrderStatus/{orderStatus}")
    public Collection<Orders> byOrderStatus(@PathVariable OrderStatus orderStatus) {
        return this.ordersRepository.findAllByOrderStatus(orderStatus);
    }
    //GET ORDER BY ORDERBY USER NAME
    @GetMapping("byOrderBy/{orderBy}")
    public Collection<Orders> byOrderBy(@PathVariable String orderBy){
    return  ordersRepository.findAllByOrderByUser(orderBy);
    }

    //GET ORDER BY ORDERBY SUPERSTORE NAME





    //GET ALL ORDERS BY PRICE LESS THAN
    @GetMapping("byPriceLessThan/{price}")
    public Collection<Orders> byPriceLessThan(@PathVariable double price){
        return  ordersRepository.findAllByOrderByPriceLessThan(price);
    }

    //GET ALL ORDERS BY QUANTITY LESS THAN
    @GetMapping("byQuantityLessThan/{quantity}")
    public Collection<Orders> byQuantityLessThan(@PathVariable int quantity){
        return  ordersRepository.findAllByOrderByQuantityLessThan(quantity);
    }


}

