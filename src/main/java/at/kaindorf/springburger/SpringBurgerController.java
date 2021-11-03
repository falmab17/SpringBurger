package at.kaindorf.springburger;

import at.kaindorf.springburger.beans.Burger;
import at.kaindorf.springburger.beans.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j // loggen direkt auf die Spring Console weil sout bei spring unübersichtlich ist
@Controller // Request Mapping möglich
@RequestMapping("/design")// Definition für post u. get mapping
@SessionAttributes("designBurger")
public class SpringBurgerController {
    private List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("120B", "120g Ground Beef", Ingredient.Type.PATTY),
                new Ingredient("160B", "160g Ground Beef", Ingredient.Type.PATTY),
                new Ingredient("140T", "140g Turkey", Ingredient.Type.PATTY),
                new Ingredient("SWIS", "Swiss Cheese", Ingredient.Type.CHEESE),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGGIE),
                new Ingredient("ONIO", "Onion", Ingredient.Type.VEGGIE),
                new Ingredient("SALA", "Salat", Ingredient.Type.VEGGIE));


    @ModelAttribute // zugehörige Methode wird automatisch vom Framework aufgerufen bevor die get methode aufgerufen wird
    public void addAttributes(Model model) {
        Map<String, List<Ingredient>> ingredientMap = new HashMap<>();
        for (Ingredient.Type type : Ingredient.Type.values()){
            ingredientMap.put(type.toString().toLowerCase(), filterByType(type));
        }
        model.addAttribute("ingredients", ingredientMap);
        model.addAttribute("designBurger", new Burger());
    }

    private List<Ingredient> filterByType(Ingredient.Type type){
        return ingredients.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }

    @GetMapping // wenn hier nichts ist, kann ichs mit design aufrufen
    public String showDesignForm() {
        log.info("getRequest /design"); // durch slf4j
        return "designForm"; // html Datei in resources/templates
    }

    @PostMapping
    public String processBurger(@ModelAttribute("designBurger") Burger burger){
        log.info("Burger: "+burger);
        return "redirect:/orders/current"; // leitet weiter zu dem link nach redirect
    }
}
