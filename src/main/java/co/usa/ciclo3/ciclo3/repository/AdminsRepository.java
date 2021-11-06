package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Admins;
import co.usa.ciclo3.ciclo3.repository.crud.AdminsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminsRepository {
    @Autowired
    private AdminsCrudRepository AdminsCrudRepository;
    public List<Admins> getAll(){
        return (List<Admins>) AdminsCrudRepository.findAll();
    }
    public Optional<Admins> getAdministrador(int id){
        return AdminsCrudRepository.findById(id);
    }

    public Admins save(Admins administrador){
        return AdminsCrudRepository.save(administrador);
    }
    public void delete(Admins administrador){
        AdminsCrudRepository.delete(administrador);
    }
}
