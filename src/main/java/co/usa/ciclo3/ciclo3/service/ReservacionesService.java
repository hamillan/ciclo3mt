package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservaciones;
import co.usa.ciclo3.ciclo3.model.EstadoReservas;
import co.usa.ciclo3.ciclo3.model.ContarClientes;
import co.usa.ciclo3.ciclo3.repository.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
            Optional<Reservaciones> ent1= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(ent1.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    /** PUT de las Reservaciones */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> ent1= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(!ent1.isEmpty()){

                if(reservation.getStartDate()!=null){
                    ent1.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    ent1.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    ent1.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(ent1.get());
                return ent1.get();
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
    
    /** Método para consultar la vigencia de una reserva */
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
       
        Date datoUno = new Date();
        Date datoDos = new Date();
                
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }

    /** Método para contar la cantidad de clientes con reserva */
    public List<ContarClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }

    /** Método para consultar el Estado de las Reservas */
    public EstadoReservas reporteStatusServicio (){
        List<Reservaciones>completed= metodosCrud.ReservacionEstadoRepositorio("completed");
        List<Reservaciones>cancelled= metodosCrud.ReservacionEstadoRepositorio("cancelled");
        
        return new EstadoReservas(completed.size(), cancelled.size() );
       
       
    }

}
