package br.com.estudos.cep.repository;

import br.com.estudos.cep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

    Cep findByCep(String cep);
}
