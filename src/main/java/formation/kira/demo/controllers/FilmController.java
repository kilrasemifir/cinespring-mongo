package formation.kira.demo.controllers;

import formation.kira.demo.models.Award;
import formation.kira.demo.models.Film;
import formation.kira.demo.services.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("films")
@CrossOrigin
public class FilmController {

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Film> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Film insert(@RequestBody Film entity) {
        return service.insert(entity);
    }

    @PutMapping("")
    public Film save(@RequestBody Film entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Film findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    @GetMapping("awards")
    public List<Award> findAllAward() {
        return service.findAllAward();
    }

    @GetMapping("search/{keyword}")
    public Iterable<Film> search(@PathVariable String keyword){
        return this.service.search(keyword);
    }
}
