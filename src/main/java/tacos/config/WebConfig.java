package tacos.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tacos.models.Ingredient;
import tacos.repositories.IngredientRepository;

import static tacos.models.enums.TypeIngredient.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
  }
  @Bean
  public ApplicationRunner dataLoader(IngredientRepository repository){
    return args -> {
      repository.save(new Ingredient(1L,"Flour Tortilla",WRAP));
      repository.save(new Ingredient(2L,"Corn Tortilla",WRAP));
      repository.save(new Ingredient(3L,"Ground Beef",PROTEIN));
      repository.save(new Ingredient(4L,"Carnitas",PROTEIN));
      repository.save(new Ingredient(5L,"Diced Tomatoes",VEGGIES));
      repository.save(new Ingredient(6L,"Lettuce",VEGGIES));
      repository.save(new Ingredient(7L,"Cheddar",CHEESE));
      repository.save(new Ingredient(8L,"Monterrey Jack'",CHEESE));
      repository.save(new Ingredient(9L,"Salsa",SAUCE));
      repository.save(new Ingredient(10L,"Sour Cream",SAUCE));
    };
  }
}
