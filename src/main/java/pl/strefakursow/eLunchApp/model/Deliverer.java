package pl.strefakursow.eLunchApp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import javax.annotation.Nullable;


@Entity
@DiscriminatorValue("deliverer")
public class Deliverer extends Employee {

    @Nullable
    @OneToMany(mappedBy = "deliverer")
    private List<Order> orders;

}
