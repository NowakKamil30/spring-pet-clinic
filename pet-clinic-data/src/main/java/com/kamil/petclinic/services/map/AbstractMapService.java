package com.kamil.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();

    Set<T> findAll() {
      return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(ID id, T obj){
        map.put(id,obj);

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

}
