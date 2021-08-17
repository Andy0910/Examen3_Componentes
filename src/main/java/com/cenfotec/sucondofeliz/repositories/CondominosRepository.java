package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Condomino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondominosRepository extends JpaRepository<Condomino, Long> {

    List<Condomino> findAllByCondominio(Condominio condominio);
    List<Condomino> findAllByCondominio_Id(Long id);
}
