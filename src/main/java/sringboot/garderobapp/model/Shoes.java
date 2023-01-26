package sringboot.garderobapp.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Shoes extends Clothing {
    private String shoeType;
}
