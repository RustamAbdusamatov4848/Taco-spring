package tacos.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.models.Ingredient;
import tacos.models.Taco;
import tacos.models.TacoOrder;
import tacos.models.types.TypeIngredient;
import tacos.repositories.IngredientRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  private final IngredientRepository ingredientRepository;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    Iterable<Ingredient> ingredients = ingredientRepository.findAll();
    TypeIngredient[] types = TypeIngredient.values();
    for (TypeIngredient type : types) {
      model.addAttribute(type.toString().toLowerCase(), findAllIngredientsByType(ingredients, type));
    }
  }

  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order() {
    return new TacoOrder();
  }

  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }

  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  @PostMapping
  public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {

    if (errors.hasErrors()) {
      return "design";
    }

    tacoOrder.addTaco(taco);

    return "redirect:/orders/current";
  }

  private Iterable<Ingredient> findAllIngredientsByType(Iterable<Ingredient> ingredients, TypeIngredient type) {
    return StreamSupport
            .stream(ingredients.spliterator(),false)
            .filter(ingredient -> ingredient.getTypeIngredient().equals(type))
            .collect(Collectors.toList());
  }

}
