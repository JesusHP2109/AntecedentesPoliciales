package pe.isil.web.service;

import org.springframework.stereotype.Service;
import pe.isil.web.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonaService {

    AtomicInteger dni = new AtomicInteger();

    List<Persona> personas = new ArrayList<>(
            Arrays.asList(
                    new Persona(dni.getAndIncrement(), "jesus","maldonado")

            )
    );

    public List<Persona> getAll() {
        return personas;
    }
    public void savePersona(Persona persona) {

        persona.setDni(dni.incrementAndGet());

        personas.add(persona);
    }

    public Persona findById(Integer dni) {

        Persona persona = personas.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst()
                .orElseGet(null);

        return persona;
    }

    public void updatePersona(Integer dni,
                              Persona persona) {
        Persona currentPersona = findById(dni);

        int index = personas.indexOf(currentPersona);
        persona.setDni(currentPersona.getDni());
        personas.set(index, persona);
    }

    public void deletePersona(Integer dni) {
        Persona currentPersona = findById(dni);
        personas.remove(currentPersona);
    }



}
