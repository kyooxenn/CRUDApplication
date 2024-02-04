package com.crud.CRUD.controller;

import com.crud.CRUD.entity.Actor;
import com.crud.CRUD.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping
    public ResponseEntity<List<Actor>> getAllActor() {
        return ResponseEntity.ok().body(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {
        return ResponseEntity.ok().body(this.actorService.saveActor(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Actor> updateProduct(@PathVariable long id, @RequestBody  Actor actor) {
        actor.setActorId(id);
        return ResponseEntity.ok().body(this.actorService.updateActor(actor));
    }


    @DeleteMapping("/{id}")
    public HttpStatus  deleteActor(@PathVariable Long id) {
        this.actorService.deleteActor(id);
        return HttpStatus.OK;
    }


}
