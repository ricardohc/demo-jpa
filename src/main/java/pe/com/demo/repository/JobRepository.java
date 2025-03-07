package pe.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.demo.entity.Job;
import pe.com.demo.entity.Person;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
