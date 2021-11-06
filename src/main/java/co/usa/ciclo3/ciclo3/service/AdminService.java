package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Admins;
import co.usa.ciclo3.ciclo3.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminsRepository adminsRepository;
    
    public List<Admins> getAll(){
        return adminsRepository.getAll();
    }
    public Optional<Admins> getAdministrador(int id){
        return adminsRepository.getAdministrador(id);
    }
    
    public Admins save(Admins admins){
        if(admins.getId()==null){
            return adminsRepository.save(admins);  
        }else{
            Optional<Admins> aux=adminsRepository.getAdministrador(admins.getId());
            if(!aux.isEmpty()){
                return adminsRepository.save(admins);
            }else{
                return admins;
            }
        }
        
    }
    
    public Admins update(Admins admins){
        if(admins.getId()!=null){
            Optional<Admins> e= adminsRepository.getAdministrador(admins.getId());
            if(e.isEmpty()){
                if(admins.getName()!=null){
                    e.get().setName(admins.getName());
                }
                if(admins.getPassword()!=null){
                    e.get().setPassword(admins.getPassword());
                }
                
                if(admins.getEmail()!=null){
                    e.get().setEmail(admins.getEmail());
                }
                adminsRepository.save(e.get());
                return e.get();
            }else{
                return admins;
            }
        }else{
            return admins;
        }
    }
    public boolean deleteAdministrador(int administradorId){
        Boolean d=getAdministrador(administradorId).map(administrador -> {
            adminsRepository.delete(administrador);
            return true;
        }).orElse(false);
        return d;
    }
    
}
