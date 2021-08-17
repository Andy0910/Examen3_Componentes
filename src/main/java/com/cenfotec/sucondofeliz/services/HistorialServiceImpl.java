package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Historial;
import com.cenfotec.sucondofeliz.repositories.HistorialRepository;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService{

    @Autowired
    HistorialRepository repo;

    @Override
    public void save(Historial historial) {
        repo.save(historial);
    }

    @Override
    public Optional<Historial> get(Long id) {
        return repo.findById(id).map( record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Historial> getAllByCondominio(Condominio condominio) {
        return repo.findAllByCondominio(condominio);
    }

    @Override
    public List<Historial> getAll() {
        return repo.findAll();
    }
}
