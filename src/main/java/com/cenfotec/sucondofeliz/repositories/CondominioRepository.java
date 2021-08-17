package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.entities.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio,Long> {

    List<Condominio> findAllByEstadoIsTrue();
    List<Condominio> findAllByEstadoIsFalse();

}
