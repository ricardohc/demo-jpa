package pe.com.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.demo.entity.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    @Query(value = "SELECT * FROM person p WHERE p.name = :name", nativeQuery = true)
    List<Person> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE person p SET p.salary =:salary WHERE p.id_person =:idPerson", nativeQuery = true)
    void updateSalary(@Param("salary") double salary, @Param("idPerson") long idPerson);

}
