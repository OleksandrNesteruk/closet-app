package sringboot.garderobapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Socks extends Clothing {
    @Column(name = "pairs_amount")
    private int pairsAmount;
}
