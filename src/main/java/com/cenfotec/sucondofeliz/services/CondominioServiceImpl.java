package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Historial;
import com.cenfotec.sucondofeliz.repositories.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    CondominioRepository repo;

    @Override
    public List<Condominio> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Condominio> getActive() {
        return repo.findAllByEstadoIsTrue();
    }

    @Override
    public List<Condominio> getNotActive() {
        return repo.findAllByEstadoIsFalse();
    }

    @Override
    public Optional<Condominio> findById(long id) {
        return repo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty()) ;
    }

    @Override
    public Optional<Condominio> save(Condominio condominio) {
        return Optional.of(repo.save(condominio));
    }

    @Override
    public Optional<Condominio> update(Condominio condominio) {
        Optional<Condominio> optCondo = repo.findById(condominio.getId());
        if(optCondo.isPresent()){
            Condominio data = optCondo.get();
            if(data.isEstado()) {
                data.setNombre(condominio.getNombre());
                data.setDireccion(condominio.getDireccion());
                data.setCedulaJuridica(condominio.getCedulaJuridica());
                data.setCuota(condominio.getCuota());
                data.setRepresentante(condominio.getRepresentante());
                data.setCantidadUnidades(condominio.getCantidadUnidades());
                return Optional.of(repo.save(data));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Condominio> optCondo = repo.findById(id);
        if(optCondo.isPresent()){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Condominio> activate(Long id) {
        Optional<Condominio> optCondo = repo.findById(id);
        if (optCondo.isPresent()){
            Condominio condo = optCondo.get();
            condo.setEstado(true);
            return Optional.of(repo.save(condo));
        }
        return Optional.empty();
    }
    @Override
    public Optional<Condominio> deactivate(Long id) {
        Optional<Condominio> optCondo = repo.findById(id);
        if (optCondo.isPresent()){
            Condominio condo = optCondo.get();
            condo.setEstado(false);
            return Optional.of(repo.save(condo));
        }
        return Optional.empty();
    }
}
