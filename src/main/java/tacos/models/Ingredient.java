package tacos.models;


import jakarta.persistence.*;
import lombok.*;
import tacos.models.types.TypeIngredient;

@Data
@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private TypeIngredient typeIngredient;
}
