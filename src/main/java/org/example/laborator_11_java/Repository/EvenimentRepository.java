package org.example.laborator_11_java.Repository;
import org.example.laborator_11_java.Model.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {

    List<Eveniment> findByLocatie(String locatie);

    List<Eveniment> findByData(LocalDate data);
}
