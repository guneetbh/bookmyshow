package org.bms.user.repositories;

import org.bms.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository  extends JpaRepository<Actor, Long> {
    Actor save(Actor actor);
}
