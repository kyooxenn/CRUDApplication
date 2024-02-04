package com.crud.CRUD.services;


import com.crud.CRUD.ResourceNotFoundException;
import com.crud.CRUD.entity.Actor;
import com.crud.CRUD.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;


    @Override
    public List<Actor> getAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Actor saveActor(Actor actor) {
       return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        Optional<Actor> actorDb = this.actorRepository.findById(actor.getActorId());

        if (actorDb.isPresent()) {
            Actor actorUpdate = actorDb.get();
            actorUpdate.setActorId(actor.getActorId());
            actorUpdate.setFirstName(actor.getFirstName());
            actorUpdate.setLastName(actor.getLastName());
            actorUpdate.setLastUpdate(LocalDateTime.now());
            actorRepository.save(actorUpdate);
            return actorUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + actor.getActorId());
        }
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }


}
