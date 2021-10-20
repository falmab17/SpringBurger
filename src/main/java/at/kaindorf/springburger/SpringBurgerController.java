package at.kaindorf.springburger;

import at.kaindorf.springburger.beans.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j // loggen direkt auf die Spring Console weil sout bei spring unübersichtlich ist
@Controller
@RequestMapping("/design")// Definition für post u. get mapping
public class SpringBurgerController {
    private List<Ingredient> ingredients;
    {
        ingredients = Arrays.asList( new Ingredient("120B", "120g Ground Beef", Ingredient.Type.PATTY),
                new Ingredient("160B", "160g Ground Beef", Ingredient.Type.PATTY),
                new Ingredient("140T", "140g Turkey", Ingredient.Type.PATTY),
                new Ingredient("SWIS", "Swiss Cheese", Ingredient.Type.CHEESE),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGGIE),
                new Ingredient("ONIO", "Onion", Ingredient.Type.VEGGIE),
                new Ingredient("SALA", "Salat", Ingredient.Type.VEGGIE));
    }

    @GetMapping
    public String showDesignForm() {
        log.info("getRequest /design");
        return "designForm";
    }
}
