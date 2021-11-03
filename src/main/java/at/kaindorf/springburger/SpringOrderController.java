package at.kaindorf.springburger;

import at.kaindorf.springburger.beans.Burger;
import at.kaindorf.springburger.beans.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/orders")
public class SpringOrderController {
    @GetMapping("/current")
    public String showOrder(Model model, @SessionAttribute Burger designBurger){
        log.info("In OrderController: " + designBurger);
        model.addAttribute("order", new Order());
        model.addAttribute("designBurger", designBurger);
        return "orderForm"; // Name der View in templates
    }

    @PostMapping
    public String performOder(Model model, @SessionAttribute Burger designBurger, @ModelAttribute("order") Order order){
        log.info("Order submitted: "+order);
        return "redirect:/design";
    }
}
