package pe.isil.web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Policia {
    private Integer dni;
    private String nombre;
    private String apellido;
    private String cargo;
    private String comisaria;
    private int edad;

    public Policia(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
