package data.iris;

import javax.persistence.*;

@Entity
@Cacheable
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 40, unique = true)
    public String name;

    public Fruit() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Fruit(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
