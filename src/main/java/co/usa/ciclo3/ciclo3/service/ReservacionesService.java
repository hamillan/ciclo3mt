package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservaciones;
import co.usa.ciclo3.ciclo3.repository.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Hugo Millan
 */

@Service
public class ReservacionesService {
    @Autowired
    /** CRUD para las Reservaciones - Definición global */
    private ReservacionesRepository metodosCrud;

    /** instancia de las Reservaciones */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }

    /** GET de las Reservaciones */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservaciones(reservationId);
    }

    /** POST de las Reservaciones */
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    /** PUT de las Reservaciones */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /** DELETE de las Reservaciones */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }    
}
