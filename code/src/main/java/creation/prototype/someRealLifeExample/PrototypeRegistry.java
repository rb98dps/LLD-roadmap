package creation.prototype.someRealLifeExample;

import java.util.List;

public interface PrototypeRegistry<T,Q> {

    void add(T id, Q type);
    void remove(T id);
    List<Q> get(T id);

}
