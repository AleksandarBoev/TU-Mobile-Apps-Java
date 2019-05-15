package tu.practise.firm.services;

import java.util.List;

public interface Extractable<V, ID> { //id can't be primitive
    List<V> getAll();

    V getById(ID id);
}
