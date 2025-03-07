package pe.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.demo.entity.Job;
import pe.com.demo.entity.Person;
import pe.com.demo.repository.JobRepository;
import pe.com.demo.repository.PersonRepository;

import java.time.LocalDateTime;

@Service
public class PersonServiceImpl {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public void savePersonWithJob() {
        // Crear un Job
        Job job = new Job();
//        job.setJobId(1);
        job.setJobName("Software Developer");
        jobRepository.save(job); // Persistir el Job

        // Crear una Person y asociarla con el Job
        Person person = new Person();
        person.setName("John Doe");
//        person.setJob(job); // Asociar el Job a la Person
        person.setSalary(1500);
        person.setCreationDate(LocalDateTime.now());
        personRepository.save(person); // Persistir la Person
    }

    @Transactional
    public void createJobWithPersons() {
        // Create a Job
        Job job = new Job();
        job.setJobName("QA");
        jobRepository.save(job); // Save Job first

        // Create Persons
        Person person1 = new Person();
        person1.setName("Catt");
        person1.setCreationDate(LocalDateTime.now());
//        person1.setJob(job); // Associate with the Job

        Person person2 = new Person();
        person2.setName("Ric");
        person2.setCreationDate(LocalDateTime.now());
//        person2.setJob(job); // Associate with the Job

        // Save Persons
        personRepository.save(person1);
        personRepository.save(person2);
    }
}
