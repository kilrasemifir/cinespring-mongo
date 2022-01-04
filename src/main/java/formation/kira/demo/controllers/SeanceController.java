package formation.kira.demo.controllers;

import formation.kira.demo.models.Seance;
import formation.kira.demo.services.SeanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("seances")
@CrossOrigin
@RestController
public class SeanceController {

    private SeanceService service;

    public SeanceController(SeanceService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Seance> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Seance insert(@RequestBody Seance entity) {
        return service.insert(entity);
    }

    @PutMapping("")
    public Seance save(@RequestBody Seance entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Seance findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
