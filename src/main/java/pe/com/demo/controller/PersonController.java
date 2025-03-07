package pe.com.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.demo.entity.Job;
import pe.com.demo.entity.Person;
import pe.com.demo.repository.JobRepository;
import pe.com.demo.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/person")
    public List<Person> findAll(){
        return this.personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id") long personId){
        Optional<Person> byId = this.personRepository.findById(personId);
        return byId.orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + personId));
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        Optional<Job> byId = this.jobRepository.findById(person.getJob().getJobId());
        if (!byId.isPresent()) {
            throw new EntityNotFoundException("Job not found with ID: " + person.getJob().getJobId());
        }
        person.setJob(byId.get());
        return personRepository.save(person); // Save Person to the in-memory "database"
    }

    @PatchMapping("/person/{id}")
    public Person partialUpdatePerson(@PathVariable("id") Long personId, @RequestBody Map<String, Object> updates) {
        Optional<Person> byId = this.personRepository.findById(personId);
        if (!byId.isPresent()) {
            throw new EntityNotFoundException("Person not found with ID: " + personId);
        }

        Person person = byId.get();
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    person.setName((String) value);
                    break;
                case "salary":
                    person.setSalary((double) value);
                    break;
                case "creationDate":
                    person.setCreationDate((LocalDateTime) value);
                    break;
            }
        });
        return personRepository.save(person);
    }

    @PutMapping("/person/{personId}")
    public Person fullUpdatePerson(@PathVariable Long personId, @RequestBody Person person) {
        if (!personRepository.existsById(personId)) {
            throw new RuntimeException("Person not found with ID: " + personId);
        }

        person.setIdPerson(personId);
        return personRepository.save(person);
    }
}
