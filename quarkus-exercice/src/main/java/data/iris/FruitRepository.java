package data.iris;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    Fruit findByName(String name){
        return find("name", name).firstResult();
    }

    List<Fruit> findFruits(String name){
        return list("name like ?1",name+"%");
    }

}
