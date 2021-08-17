package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Amenidades;
import com.cenfotec.sucondofeliz.entities.Condominio;

import java.util.List;
import java.util.Optional;

public interface AmenidadesService {

    Optional<Amenidades> save(Amenidades amenidades);
    List<Amenidades> getAmenidadesCondominio(Condominio condominio);

}
