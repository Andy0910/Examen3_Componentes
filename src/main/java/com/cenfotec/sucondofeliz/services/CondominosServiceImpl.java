package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Condomino;
import com.cenfotec.sucondofeliz.repositories.CondominosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CondominosServiceImpl implements CondominosService{
    @Autowired
    CondominosRepository repo;
    @Autowired
    CondominioService condoService;

    @Override
    public Optional<Condomino> save(Condomino condomino) {
        return Optional.of(repo.save(condomino));
    }

    @Override
    public List<Condomino> getAllByCondo(Condominio condominio) {
        return repo.findAllByCondominio(condominio);
    }

    @Override
    public Optional<Condomino> update(Condomino condomino) {
        Optional<Condomino> optCondomino = repo.findById(condomino.getId());
        if (optCondomino.isPresent()){
            Condomino data = new Condomino();
            data.setId(condomino.getId());
            data.setCondominio(optCondomino.get().getCondominio());
            data.setEstado(optCondomino.get().getEstado());
            data.setNombre(condomino.getNombre());
            data.setCedula(condomino.getCedula());
            return Optional.of(repo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Condomino> delete(Long id) {
        Optional<Condomino> optCondomino = repo.findById(id);
        if(optCondomino.isPresent()){
            Condomino data = optCondomino.get();
            data.setEstado("Ex-Condomino");
            return Optional.of(repo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Condomino> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Condomino> getAllByCondoId(Long id) {
        return repo.findAllByCondominio_Id(id);
    }

    @Override
    public Condomino create(String nombre, String cedula, int condominio) {
        Condomino condomino = new Condomino();
        condomino.setNombre(nombre);
        condomino.setCedula(cedula);
        condomino.setEstado("Condomino");
        condomino.setCondominio(condoService.findById(condominio).get());
        return this.repo.save(condomino);
    }


}
