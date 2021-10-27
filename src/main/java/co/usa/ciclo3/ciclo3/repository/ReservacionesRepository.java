package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Reservaciones;
import co.usa.ciclo3.ciclo3.repository.crud.ReservacionesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservacionesRepository {
    @Autowired
    private ReservacionesCrudRepository reservacionesCrudRepository;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) reservacionesCrudRepository.findAll();
    }

    public Optional<Reservaciones>getReservaciones(int id){
        return reservacionesCrudRepository.findById(id);
    }
    
    public Reservaciones save(Reservaciones c){
        return reservacionesCrudRepository.save(c);
    }

    public void delete(Reservaciones c){
        reservacionesCrudRepository.delete(c);
    }
}
