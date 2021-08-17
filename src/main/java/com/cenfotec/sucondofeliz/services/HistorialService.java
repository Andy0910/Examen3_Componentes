package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Historial;

import java.util.List;
import java.util.Optional;

public interface HistorialService {

    public void save(Historial historial);
    public Optional<Historial> get(Long id);
    public List<Historial> getAllByCondominio(Condominio condominio);
    public List<Historial> getAll();


}
