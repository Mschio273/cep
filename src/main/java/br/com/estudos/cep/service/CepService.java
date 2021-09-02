package br.com.estudos.cep.service;

import br.com.estudos.cep.model.Cep;
import br.com.estudos.cep.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CepService {

    @Autowired
    CepRepository cepRepository;

    public List<Cep> findAll() {
        return this.cepRepository.findAll();
    }

    public Cep findByCep(String cep) {
        Cep cepObject = this.cepRepository.findByCep(cep);
        if (cepObject != null) {
            return cepObject;
        } else {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            RestTemplate restTemplate = new RestTemplate();
            Cep cepResponse = restTemplate.getForObject(url, Cep.class);
            cepRepository.save(cepResponse);
            return cepResponse;
        }
    }

    public Cep save(Cep cep) {
        return this.cepRepository.save(cep);
    }

    public void delete(Long id) {
        this.cepRepository.deleteById(id);
    }

    public void update(Cep cep) {
        this.cepRepository.save(cep);
    }
}
