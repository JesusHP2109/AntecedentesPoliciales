package pe.isil.web.service;

import org.springframework.stereotype.Service;
import pe.isil.web.model.Persona;
import pe.isil.web.model.Policia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



@Service
public class PoliciaService {

    AtomicInteger dni = new AtomicInteger();

    List<Policia> policias = new ArrayList<>(
            Arrays.asList(
                    new Policia(dni.getAndIncrement(), "Roberto","maldonado")


            )
    );

    public List<Policia> getAll() {
        return policias;
    }
    public void savePolicia(Policia policia) {

        policia.setDni(dni.incrementAndGet());

        policias.add(policia);
    }

    public Policia findById(Integer dni) {

        Policia policia = policias.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst()
                .orElseGet(null);

        return policia;
    }

    public void updatePolicia(Integer dni,
                              Policia policia) {
        Policia currentPolicia = findById(dni);

        int index = policias.indexOf(currentPolicia);
        policia.setDni(currentPolicia.getDni());
        policias.set(index, policia);
    }

    public void deletePolicia(Integer dni) {
        Policia currentPolicia = findById(dni);
        policias.remove(currentPolicia);
    }

}
