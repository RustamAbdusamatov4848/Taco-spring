package tacos.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.models.Taco;
import tacos.repositories.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/tacos",
                produces="application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {
  private final TacoRepository tacoRepo;

  @Autowired
  public TacoController(TacoRepository tacoRepo) {
    this.tacoRepo = tacoRepo;
  }
  @GetMapping(params="recent")
  public Iterable<Taco> recentTacos() {
    PageRequest page = PageRequest.of(
            0, 12, Sort.by("dateOfCreated").descending());
    return tacoRepo.findAll(page).getContent();
  }
  @GetMapping("/{id}")
  public ResponseEntity<Taco> getTacoById(@PathVariable("id") Long id){
    Optional<Taco> tacoOptional = tacoRepo.findById(id);
    return tacoOptional.isPresent() ?
            new ResponseEntity<>(tacoOptional.get(),HttpStatus.OK) :
            new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
  }
  @PostMapping(consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Taco postTaco(@RequestBody Taco taco) {
    return tacoRepo.save(taco);
  }
}
