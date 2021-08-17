package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Condomino;
import org.checkerframework.checker.nullness.Opt;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CondominosService {
    Optional<Condomino> save(Condomino condomino);
    List<Condomino> getAllByCondo(Condominio condominio);
    List<Condomino> getAllByCondoId(Long id);
    Optional<Condomino> update(Condomino condomino);
    Optional<Condomino> delete(Long id);
    Optional<Condomino> findById(Long id);
    Condomino create(String nombre, String cedula, int condominio);

}
