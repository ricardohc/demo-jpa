package pe.com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Persona {

    @Id
    private long id;
    private String nombre;
    private double salario;


}
