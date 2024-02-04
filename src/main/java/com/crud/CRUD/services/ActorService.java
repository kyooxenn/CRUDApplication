package com.crud.CRUD.services;

import com.crud.CRUD.entity.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> getAllActors();

    Actor getActorById(Long id);

    Actor saveActor(Actor actor);

    Actor updateActor(Actor actor);

    void deleteActor(Long id);
}
