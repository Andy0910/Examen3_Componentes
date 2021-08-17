package com.cenfotec.sucondofeliz.controller;

import com.cenfotec.sucondofeliz.entities.Amenidades;
import com.cenfotec.sucondofeliz.entities.Condominio;
import com.cenfotec.sucondofeliz.entities.Condomino;
import com.cenfotec.sucondofeliz.entities.Historial;
import com.cenfotec.sucondofeliz.services.AmenidadesService;
import com.cenfotec.sucondofeliz.services.CondominioService;
import com.cenfotec.sucondofeliz.services.CondominosService;
import com.cenfotec.sucondofeliz.services.HistorialService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CondominioController {

    @Autowired
    private CondominioService condoService;

    @Autowired
    private HistorialService historialService;

    @Autowired
    private AmenidadesService amenidadesService;

    @Autowired
    private CondominosService condominosService;

    @GetMapping(value = "/condominios")
    public List getAll() { return condoService.getAll();}

    @GetMapping(value = "/condominios/actives")
    public List getActives() { return condoService.getActive();}

    @GetMapping(value = "/condominios/not_actives")
    public List getNotActives() { return condoService.getNotActive();}

    @GetMapping(path = "/condominios/{id}")
    public ResponseEntity<Condominio> findById(@PathVariable long id){
        Optional<Condominio> result = condoService.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/condominios")
    public Condominio create(@RequestBody Condominio condominio) {
         Condominio condo = condoService.save(condominio).get();
         insertarHistorial(condo);
         return condo;
    }
    @GetMapping(value="/condominios/amenidades/{id}")
    public ResponseEntity getAmenidadesCondo(@PathVariable("id") long id){
        Optional<Condominio> optCondo = condoService.findById(id);
        if (optCondo.isPresent()){
            return ResponseEntity.ok().body(amenidadesService.getAmenidadesCondominio(optCondo.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping(value="/condominios/amenidades/{id}")
    public ResponseEntity addAmenidades(@PathVariable("id") long id, @RequestBody Amenidades amenidades){
        Optional<Condominio> optCondo = condoService.findById(id);
        if(optCondo.isPresent()){
            Amenidades data = amenidades;
            data.setCondominio(optCondo.get());
            return ResponseEntity.ok().body(amenidadesService.save(data).get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value="/condominios/{id}")
    public ResponseEntity<Condominio> update(@PathVariable("id") long id,
                                          @RequestBody Condominio condominio){
        condominio.setId(id);
        Optional<Condominio> optCondo = condoService.findById(id);
        if (optCondo.isPresent()) {
            double cuotaVieja = optCondo.get().getCuota();
            Optional<Condominio> result = condoService.update(condominio);
            if (result.isPresent()) {
                if (cuotaVieja != result.get().getCuota()) {
                    insertarHistorial(result.get());
                }
                return ResponseEntity.ok().body(result.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    private void insertarHistorial(Condominio condominio){
        Historial historial = new Historial();
        historial.setFecha(new Date(LocalDateTime.now().atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli()));
        historial.setCuota(condominio.getCuota());
        historial.setCondominio(condominio);
        historialService.save(historial);
    }

    @GetMapping(value="/condominios/historial/{id}")
    public ResponseEntity getHistorialCondo(@PathVariable("id") long id){
        Optional<Condominio> optCondo = condoService.findById(id);
        if (optCondo.isPresent()){
            return ResponseEntity.ok().body(historialService.getAllByCondominio(optCondo.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/condominios/historial")
    public List<Historial> getHistorial(){
        return historialService.getAll();
    }

    @DeleteMapping(value="/condominios/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (condoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(value="/condominios/activate/{id}")
    public ResponseEntity activate(@PathVariable("id") long id){
        if(condoService.activate(id).isPresent()){
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/condominios/deactivate/{id}")
    public ResponseEntity deactivate(@PathVariable("id") long id){
        if(condoService.deactivate(id).isPresent()){
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/condominios/condominos/{id}")
    public ResponseEntity getCondominos(@PathVariable("id") long id){
        Optional<Condominio> optCondo = condoService.findById(id);
        if(optCondo.isPresent()){
            return ResponseEntity.ok().body(condominosService.getAllByCondo(optCondo.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/condominios/condominos/{id}")
    public ResponseEntity createCondomino(@PathVariable("id") long id, @RequestBody Condomino condomino){
        Optional<Condominio> optCondo = condoService.findById(id);
        if(optCondo.isPresent()){
            condomino.setCondominio(optCondo.get());
            condomino.setEstado("Condomino");
            return ResponseEntity.ok().body(condominosService.save(condomino).get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value="/condominos/{id}")
    public ResponseEntity updateCondomino(@PathVariable("id") long id, @RequestBody Condomino condomino){
        Optional<Condomino> optCondomino = condominosService.findById(id);
        condomino.setId(id);
        if(optCondomino.isPresent()){
            return ResponseEntity.ok().body(condominosService.update(condomino).get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value="/condominos/{id}")
    public ResponseEntity deleteCondomino(@PathVariable("id") long id){
        Optional<Condomino> optCondomino = condominosService.delete(id);
        if(optCondomino.isPresent()){
            return ResponseEntity.ok().body(optCondomino.get());
        }
        return ResponseEntity.notFound().build();
    }

}
