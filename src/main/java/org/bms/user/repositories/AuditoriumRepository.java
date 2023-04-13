package org.bms.user.repositories;

import org.bms.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Auditorium save(Auditorium auditorium);

}
