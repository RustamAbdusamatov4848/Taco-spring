package tacos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "tacos")
@RestResource(rel = "tacos",path = "tacos")
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private LocalDateTime dateOfCreated;

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  @Column(name = "name",unique = true)
  private String name;

  @Size(min=1, message="You must choose at least 1 ingredient")
  @ManyToMany
  @JoinColumn(name = "ingredient_id")
  private List<Ingredient> ingredients = new ArrayList<>();
  @PrePersist
  private void init() {
    dateOfCreated = LocalDateTime.now();
  }
  public void addIngredient(Ingredient taco) {
    this.ingredients.add(taco);
  }
}
