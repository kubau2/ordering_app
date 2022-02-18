package com.dzejju.ordering_app.controllers;


import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.exceptions.CustomerDataNotFilledException;
import com.dzejju.ordering_app.methods.CartService;
import com.dzejju.ordering_app.methods.CustomerService;
import com.dzejju.ordering_app.methods.OrderService;
import com.dzejju.ordering_app.methods.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    Cart cart = new Cart();

    private CartService cartService;
    private ProductService productService;
    private CustomerService customerService;
    private OrderService orderService;

    public MainController(CartService cartService, ProductService productService, CustomerService customerService, OrderService orderService) {
        this.cartService = cartService;
        this.productService  = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @RequestMapping(value = "/add_item_to_cart", method = RequestMethod.POST)
    @ResponseBody
    public String addItemToCart(@RequestParam Long ID, @RequestParam Integer amount, @RequestParam(required = false) String discountCode) {
        if (ID!=null && amount!=null){
            cart.setProductAmount(ID, amount);
            cart.setDiscountCode(discountCode);
            cart = cartService.addToCart(cart);

            //cartService.addCart(cart);
            return "Product added to cart";
        } else{
            return "Please fill in neccessary data"; //tutaj daj exceptiony
            //throw new
        }
    }

    @RequestMapping(value = "/add_user_data", method = RequestMethod.POST)
    @ResponseBody
    public String addUserData(@RequestParam String Name, @RequestParam String Surname, @RequestParam String Address) {
        if (!Name.trim().isEmpty() && !Surname.trim().isEmpty() && !Address.trim().isEmpty()){
            customerService.addCustomerData(cart.getCustomerID(),Name, Surname, Address);
            return "User data filled";
        } else{
            throw new CustomerDataNotFilledException();
        }
    }

    @RequestMapping(value = "/confirm_cart_and_create_order", method = RequestMethod.POST)
    @ResponseBody
    public String placeOrder() {
        orderService.placeOrder(cart.getCustomerID());
        cart = new Cart();
        return "Order placed";
    }


}
