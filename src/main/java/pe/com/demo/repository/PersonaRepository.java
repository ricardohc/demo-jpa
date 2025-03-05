package pe.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.demo.entity.Persona;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

    @Query(value = "SELECT * FROM persona p WHERE p.nombre = :nombre", nativeQuery = true)
    List<Persona> findByName(@Param("nombre") String nombre);

    @Modifying
    @Query(value = "UPDATE persona p SET p.salario =:salario WHERE p.id =:id", nativeQuery = true)
    void updateSalario(@Param("salario") double salario, @Param("id") long id);
}
