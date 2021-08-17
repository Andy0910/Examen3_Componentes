package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Amenidades;
import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.repositories.AmenidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenidadesServiceImpl implements AmenidadesService{
    @Autowired
    AmenidadesRepository repo;

    @Override
    public Optional<Amenidades> save(Amenidades amenidades) {
        return Optional.of(repo.save(amenidades));
    }

    @Override
    public List<Amenidades> getAmenidadesCondominio(Condominio condominio) {
        return repo.getAmenidadesByCondominio(condominio);
    }
}
