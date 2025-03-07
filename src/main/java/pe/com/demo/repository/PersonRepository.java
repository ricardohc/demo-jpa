package pe.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.demo.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom{

}
