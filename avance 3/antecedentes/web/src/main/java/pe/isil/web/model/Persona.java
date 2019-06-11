package pe.isil.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private Integer dni;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String alias;
    private String sexo;
    private String fecNacimiento;
    private int edad;
    private  String telefono;
    private String nomPadre;
    private String nomMadre;

    public Persona(Integer dni, String nombre, String apePaterno) {
        this.dni = dni;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
    }
}
