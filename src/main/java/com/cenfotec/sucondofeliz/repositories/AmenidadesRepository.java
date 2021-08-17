package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.entities.Amenidades;
import com.cenfotec.sucondofeliz.entities.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenidadesRepository extends JpaRepository<Amenidades, Long> {
    List<Amenidades> getAmenidadesByCondominio(Condominio condominio);
}
