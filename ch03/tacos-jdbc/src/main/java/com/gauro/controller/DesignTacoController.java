package com.gauro.controller;

import com.gauro.data.IngredientRepository;
import com.gauro.data.TacoRepository;
import com.gauro.domain.Ingredient;
import com.gauro.domain.Order;
import com.gauro.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gauro.domain.Ingredient.Type;

/**
 * @author Chandra
 */
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(el -> ingredients.add(el));
        Type[] types = Ingredient.Type.values();

        Arrays.stream(types).forEach(type ->
                model.addAttribute(type.toString().toLowerCase(),
                        ingredients.stream().filter(ingredient -> type.equals(ingredient.getType()))));
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }

        Taco saved=designRepo.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";

    }

}
