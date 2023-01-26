package sringboot.garderobapp.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Trousers extends Clothing {
    private String trousersType;
}
