package pe.isil.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Antecedentes {

    private Integer codigo;
    private String categoria;
    private String ubicacion;
    private String fecha;
    private String crimer;


}
