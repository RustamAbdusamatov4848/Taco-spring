package tacos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "tacos")
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;


  private Date createdAt = new Date();

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")

  private String name;

  @Size(min=1, message="You must choose at least 1 ingredient")
  @ManyToMany
  @JoinColumn(name = "ingredient_id")
  private List<Ingredient> ingredients = new ArrayList<>();

  public void addIngredient(Ingredient taco) {
    this.ingredients.add(taco);
  }
}
