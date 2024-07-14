package com.example.mytimeplan.RestApi;

import com.example.mytimeplan.entity.Star;
import com.example.mytimeplan.manager.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/star")
public class RestStarController{

    private StarService liststars;

    @Autowired
    public RestStarController(StarService liststars) {
        this.liststars = liststars;
    }
    @GetMapping("/all")
    public Iterable<Star> getAll() {
        return liststars.findAll();
    }

    @GetMapping
    public Optional<Star> getById(@RequestParam Long id) {
        return liststars.findById(id);
    }

    @PostMapping
    public Star addStar(@RequestBody Star star) {
        return liststars.save(star);
    }

    @PutMapping
    public Star updateStar(@RequestBody Star star) {
        return liststars.save(star);
    }

    @DeleteMapping
    public void deleteCar(@RequestBody Long id) {
        liststars.deletebyId(id);
    }


}
