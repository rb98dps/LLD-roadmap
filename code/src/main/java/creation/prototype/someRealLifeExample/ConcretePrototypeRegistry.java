package creation.prototype.someRealLifeExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcretePrototypeRegistry<T,Q extends ProtoType> implements PrototypeRegistry<T,Q>{

    Map<T,List<Q >> map;
    @Override
    public void add(T id,Q type) {
        if(map == null){
            map = new HashMap<>();
        }
        List<Q> list = map.getOrDefault(id,new ArrayList<>());
        list.add(type);
        map.put(id,list);
    }
    @Override
    public void remove(T id) {
        map.remove(id);
    }

    @Override
    public List<Q> get(T id) {
      List<Q> list = map.get(id);
        List<Q> list1 = new ArrayList<>();
        list.forEach(q-> list1.add((Q) q.clone()) );
        return list1;
    }

}
