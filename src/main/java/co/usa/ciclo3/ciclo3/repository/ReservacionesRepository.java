package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Reservaciones;
import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.model.ContarClientes;
import co.usa.ciclo3.ciclo3.repository.crud.ReservacionesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

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

    public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
        return reservacionesCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<ContarClientes> getClientesRepositorio(){
        List<ContarClientes> res = new ArrayList<>();
        List<Object[]> report = reservacionesCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContarClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }
    
    public List<Reservaciones> ReservacionEstadoRepositorio (String status){
        return reservacionesCrudRepository.findAllByStatus(status);
    }

}
