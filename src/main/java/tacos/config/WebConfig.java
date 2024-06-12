package tacos.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tacos.models.Ingredient;
import tacos.models.Taco;
import tacos.models.User;
import tacos.models.enums.TypeIngredient;
import tacos.repositories.IngredientRepository;
import tacos.repositories.TacoRepository;
import tacos.repositories.UserRepository;
import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
  }
  @Bean
  public ApplicationRunner tacoDataLoader(IngredientRepository ingredientRepository, UserRepository userRepository,
                                      PasswordEncoder passwordEncoder, TacoRepository tacoRepository){
    return args -> {

      Ingredient flourTortilla = new Ingredient(
              1L, "Flour Tortilla", TypeIngredient.WRAP);
      Ingredient cornTortilla = new Ingredient(
              2L, "Corn Tortilla", TypeIngredient.WRAP);
      Ingredient groundBeef = new Ingredient(
              3L, "Ground Beef", TypeIngredient.PROTEIN);
      Ingredient carnitas = new Ingredient(
              4L, "Carnitas", TypeIngredient.PROTEIN);
      Ingredient tomatoes = new Ingredient(
              5L, "Diced Tomatoes", TypeIngredient.VEGGIES);
      Ingredient lettuce = new Ingredient(
              6L, "Lettuce", TypeIngredient.VEGGIES);
      Ingredient cheddar = new Ingredient(
              7L, "Cheddar", TypeIngredient.CHEESE);
      Ingredient jack = new Ingredient(
              8L, "Monterrey Jack", TypeIngredient.CHEESE);
      Ingredient salsa = new Ingredient(
              9L, "Salsa", TypeIngredient.SAUCE);
      Ingredient sourCream = new Ingredient(
              10L, "Sour Cream", TypeIngredient.SAUCE);

      ingredientRepository.save(flourTortilla);
      ingredientRepository.save(cornTortilla);
      ingredientRepository.save(groundBeef);
      ingredientRepository.save(carnitas);
      ingredientRepository.save(tomatoes);
      ingredientRepository.save(lettuce);
      ingredientRepository.save(cheddar);
      ingredientRepository.save(jack);
      ingredientRepository.save(salsa);
      ingredientRepository.save(sourCream);

      User user = new User();
      user.setId(1L);
      user.setUsername("Rustam");
      user.setPassword(passwordEncoder.encode("1246100"));
      user.setEmail("korolev.rudfrsttml@yandex.ru");
      user.setCity("Moscow");
      user.setStreet("Lenina street");
      user.setState("Russia");
      user.setZip("123456");
      user.setPhoneNumber("89157214848");
      userRepository.save(user);

      Taco taco1 = new Taco();
      taco1.setName("Carnivore");
      taco1.setIngredients(Arrays.asList(
              flourTortilla, groundBeef, carnitas,
              sourCream, salsa, cheddar));
      tacoRepository.save(taco1);

      Taco taco2 = new Taco();
      taco2.setName("Bovine Bounty");
      taco2.setIngredients(Arrays.asList(
              cornTortilla, groundBeef, cheddar,
              jack, sourCream));
      tacoRepository.save(taco2);

      Taco taco3 = new Taco();
      taco3.setName("Veg-Out");
      taco3.setIngredients(Arrays.asList(
              flourTortilla, cornTortilla, tomatoes,
              lettuce, salsa));
      tacoRepository.save(taco3);
    };
  }
  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
