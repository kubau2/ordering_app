package com.dzejju.ordering_app.controllers;


import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.methods.CartService;
import com.dzejju.ordering_app.methods.CustomerService;
import com.dzejju.ordering_app.methods.OrderService;
import com.dzejju.ordering_app.methods.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

//    @Autowired
//    StockRepository stockRepository;
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    CartRepository cartRepository;

    Cart cart = new Cart();

    private CartService cartService;
    private ProductService productService;
    private CustomerService customerService;
    private OrderService orderService;

    public WebController(CartService cartService, ProductService productService, CustomerService customerService, OrderService orderService) {
        this.cartService = cartService;
        this.productService  = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @RequestMapping(value = "/add_item_to_cart", method = RequestMethod.POST)
    @ResponseBody
    public String addItemToCart(@RequestParam Long ID, @RequestParam Integer amount) {
        if (ID!=null && amount!=null){
            cart.setProductAmount(ID, amount);
            cart = cartService.addToCart(cart);

            //cartService.addCart(cart);
            return "Product added to cart";
        } else{
            return "Please fill in neccessary data"; //tutaj daj exceptiony
            //throw new
        }
    }


    @RequestMapping(value = "/show_cart", method = RequestMethod.GET)
    @ResponseBody
    public String showCart(@RequestParam Long ID) {
            return cartService.showCart(ID);
    }


    @RequestMapping(value = "/add_user_data", method = RequestMethod.POST)
    @ResponseBody
    public String PlaceOrder(@RequestParam String Name, @RequestParam String Surname, @RequestParam String Address) {
        if (!Name.trim().isEmpty() && !Surname.trim().isEmpty() && !Address.trim().isEmpty()){
            customerService.addCustomerData(cart.getCustomerID(),Name, Surname, Address);
            return "User data filled";
        } else{
            return "Please fill in neccessary data"; //tutaj daj exceptiony
            //throw new
        }
    }

    @RequestMapping(value = "/confirm_cart_and_create_order", method = RequestMethod.POST)
    @ResponseBody
    public String PlaceOrder() {
        orderService.placeOrder(cart.getCustomerID());
        cart = new Cart();
        return "Order placed";
    }


}
