package br.com.estudos.cep.controller;

import br.com.estudos.cep.model.Cep;
import br.com.estudos.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cep")
public class cepController {

    @Autowired
    private CepService cepService;

    @GetMapping
    public List<Cep> findAll() {
        return cepService.findAll();
    }

    @GetMapping("/{cep}")
    public Cep findByCep(@PathVariable String cep) {
        return cepService.findByCep(cep);
    }

    @PutMapping
    public void update(@RequestBody Cep cep) {
        this.cepService.update(cep);
    }

    @PostMapping
    public Cep save(@RequestBody Cep cep) {
        return cepService.save(cep);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.cepService.delete(id);
    }
}
