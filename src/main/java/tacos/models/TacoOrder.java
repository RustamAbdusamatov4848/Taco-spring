package tacos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "taco_order")
public class TacoOrder implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private LocalDateTime dateOfCreated;

  @NotBlank(message="Delivery name is required")
  @Column(name = "delivery_name")
  private String deliveryName;

  @NotBlank(message="Street is required")
  @Column(name = "delivery_street")
  private String deliveryStreet;

  @NotBlank(message="City is required")
  @Column(name = "delivery_city")
  private String deliveryCity;

  @NotBlank(message="State is required")
  @Column(name = "delivery_state")
  private String deliveryState;

  @NotBlank(message="Zip code is required")
  @Column(name = "delivery_zip")
  private String deliveryZip;

  @CreditCardNumber(message="Not a valid credit card number")
  @Column(name = "cc_number")
  private String ccNumber;

  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
           message="Must be formatted MM/YY")
  @Column(name = "cc_expiration")
  private String ccExpiration;

  @Digits(integer=3, fraction=0, message="Invalid CVV")
  @Column(name = "cc_CVV")
  private String ccCVV;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "taco_id")
  private List<Taco> tacos = new ArrayList<>();
  @PrePersist
  private void init() {
    dateOfCreated = LocalDateTime.now();
  }
  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
}
