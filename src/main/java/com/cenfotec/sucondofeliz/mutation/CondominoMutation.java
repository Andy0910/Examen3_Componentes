package com.cenfotec.sucondofeliz.mutation;

import com.cenfotec.sucondofeliz.entities.Condomino;
import com.cenfotec.sucondofeliz.services.CondominosService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CondominoMutation implements GraphQLMutationResolver {
    @Autowired
    private CondominosService service;

    public Condomino createCondomino(String nombre, String cedula, int condominio){
        return this.service.create(nombre, cedula, condominio);
    }

    public Condomino updateCondomino(int id, String nombre, String cedula){
        Condomino condomino = new Condomino();
        condomino.setId(id);
        condomino.setNombre(nombre);
        condomino.setCedula(cedula);
        return this.service.update(condomino).get();
    }

    public Condomino deleteCondomino(int id){
        return this.service.delete((long)id).get();
    }



}
