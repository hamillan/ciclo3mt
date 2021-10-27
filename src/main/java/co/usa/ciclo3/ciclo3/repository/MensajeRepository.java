package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Mensaje;
import co.usa.ciclo3.ciclo3.repository.crud.MensajeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAll(){
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    public Optional<Mensaje>getMessage(int id){
        return mensajeCrudRepository.findById(id);
    }
    
    public Mensaje save(Mensaje c){
        return mensajeCrudRepository.save(c);
    }

    public void delete(Mensaje c){
        mensajeCrudRepository.delete(c);
    }
}
