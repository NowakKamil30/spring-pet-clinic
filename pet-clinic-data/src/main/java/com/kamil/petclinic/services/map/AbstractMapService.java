package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.BaseEntity;
import com.kamil.petclinic.model.Person;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll() {
      return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T obj){
        if(obj != null){
            if(obj.getId() == null) {
                obj.setId(getNextId());
            }
            map.put(obj.getId(),obj);
        }
        else {
            throw  new RuntimeException("Object cannot be null");
        }

        return obj;
    }

    T deleteById(ID id){
        return map.remove(id);
    }

    T delete(T obj){
         map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(obj));
         return obj;
    }
    T change(ID id, T obj){
        return map.replace(id,obj);
    }
    private Long getNextId(){

        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
