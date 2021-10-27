package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Ortopedic;
import co.usa.ciclo3.ciclo3.repository.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic save(Ortopedic p){
        if(p.getId()==null){
            return ortopedicRepository.save(p);
        }else{
            Optional<Ortopedic> paux=ortopedicRepository.getOrtopedic(p.getId());
            if(paux.isEmpty()){
                return ortopedicRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Ortopedic update(Ortopedic c){
        if(c.getId()!=null){
            Optional<Ortopedic>g=ortopedicRepository.getOrtopedic(c.getId());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                return ortopedicRepository.save(g.get());
            }
        }
        return c;

    }

    public boolean deleteCategory(int id){
        Optional<Ortopedic> c=getOrtopedic(id);
        if(!c.isEmpty()){
            ortopedicRepository.delete(c.get());
            return true;
        }
        return false;

    }

}
