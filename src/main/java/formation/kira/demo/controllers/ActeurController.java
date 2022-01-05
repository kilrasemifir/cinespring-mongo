package formation.kira.demo.controllers;

import formation.kira.demo.models.Acteur;
import formation.kira.demo.services.ActeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acteurs")
@CrossOrigin
public class ActeurController {

    private ActeurService service;

    public ActeurController(ActeurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Acteur> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Acteur insert(@RequestBody Acteur entity) {
        return service.insert(entity);
    }

    @PutMapping
    public Acteur save(@RequestBody Acteur entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Acteur findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
