package tacos.models;


import jakarta.persistence.*;
import lombok.*;
import tacos.models.enums.TypeIngredient;
@Data
@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private TypeIngredient typeIngredient;
}
