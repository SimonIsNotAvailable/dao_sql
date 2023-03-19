package pizda.dao_zaebao.controller;


import org.springframework.web.bind.annotation.*;
import pizda.dao_zaebao.service.OrderService;

@RestController
@RequestMapping("/products")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/fetch-product")
    public String transfer(@RequestParam(value = "name") String customerName) {
        return orderService.getProductNameFromCustomerName(customerName);
    }
}
