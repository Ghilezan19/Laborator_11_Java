package org.example.laborator_11_java.Controller;
import org.example.laborator_11_java.Model.Eveniment;
import org.example.laborator_11_java.Repository.EvenimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jpa/evenimente")
public class EvenimenteController {

    @Autowired
    private EvenimentRepository evenimentRepository;

    // 1. Afișarea tuturor evenimentelor
    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return evenimentRepository.findAll();
    }



    // 2. Afișarea evenimentelor dintr-o locație specifică
    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return evenimentRepository.findByLocatie(locatie);
    }

    // 3. Afișarea evenimentelor dintr-o dată specifică
    @GetMapping("/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data) {
        LocalDate localDate = LocalDate.parse(data);
        return evenimentRepository.findByData(localDate);
    }

    // 4. Adăugarea unui eveniment
    @PostMapping
    public Eveniment createEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    // 5. Actualizarea unui eveniment
    @PutMapping
    public Eveniment updateEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    // 6. Ștergerea unui eveniment
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteEveniment(@PathVariable Long id) {
        evenimentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
