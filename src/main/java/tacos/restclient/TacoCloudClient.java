package tacos.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.models.Ingredient;

import java.util.List;

@Service
@Slf4j
public class TacoCloudClient {
    private final RestTemplate restTemplate;

    @Autowired
    public TacoCloudClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Ingredient> getAllIngredients(){
        return restTemplate.exchange("http://localhost:8080/ingredients", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Ingredient>>(){}).getBody();
    }
    public Ingredient getIngredientById(Long ingredientId){
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
                        Ingredient.class,ingredientId);
      log.info("Fetched time: {}",responseEntity.getHeaders().getDate());
      return responseEntity.getBody();
    }

    public Ingredient createIngredient(Ingredient ingredientToBeCreated){
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/ingredients",
                        ingredientToBeCreated, Ingredient.class);
        log.info("New resource created at: {}",responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }

    public void updateIngredients(Ingredient ingredientToBeUpdated){
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredientToBeUpdated,ingredientToBeUpdated.getId());
    }
    public void deleteIngredient(Ingredient ingredientToBeDeleted){
        restTemplate.delete("http://localhost:8080/ingredients/{id}",ingredientToBeDeleted.getId());
    }
}
