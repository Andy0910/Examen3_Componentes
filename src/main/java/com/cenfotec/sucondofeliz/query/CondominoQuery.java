package com.cenfotec.sucondofeliz.query;

import com.cenfotec.sucondofeliz.entities.Condomino;
import com.cenfotec.sucondofeliz.services.CondominosService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CondominoQuery implements GraphQLQueryResolver {
    @Autowired
    private CondominosService service;

    public List<Condomino> getCondominos(int id){
        return this.service.getAllByCondoId((long) id);
    }
}
