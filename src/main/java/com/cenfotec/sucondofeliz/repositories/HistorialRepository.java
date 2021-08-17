package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Long> {

    List<Historial> findAllByCondominio(Condominio condominio);
}
