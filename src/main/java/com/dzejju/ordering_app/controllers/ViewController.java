package com.dzejju.ordering_app.controllers;


import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.methods.CartService;
import com.dzejju.ordering_app.methods.CustomerService;
import com.dzejju.ordering_app.methods.OrderService;
import com.dzejju.ordering_app.methods.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViewController {

    Cart cart = new Cart();

    private CartService cartService;
    private ProductService productService;
    private CustomerService customerService;
    private OrderService orderService;

    public ViewController(CartService cartService, ProductService productService, CustomerService customerService, OrderService orderService) {
        this.cartService = cartService;
        this.productService  = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @RequestMapping(value = "/view_products", method = RequestMethod.GET)
    @ResponseBody
    public String viewProducts() {
        return productService.viewProducts();
    }

    @RequestMapping(value = "/products_display_detailed_info", method = RequestMethod.GET)
    @ResponseBody
    public String viewProductsDetails() {
        return productService.viewProductsDetails();
    }


}
