package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;

import java.util.List;
import java.util.Optional;

public interface CondominioService {
    public List<Condominio> getAll();
    public List<Condominio> getActive();
    public List<Condominio> getNotActive();
    public Optional<Condominio> findById(long id);
    public  Optional<Condominio> save(Condominio contact);
    public  Optional<Condominio> update(Condominio contact);
    public boolean delete(Long id);
    public Optional<Condominio> activate(Long id);
    public Optional<Condominio> deactivate(Long id);
}
