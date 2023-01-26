package sringboot.garderobapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
@Entity
public abstract class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private final String type = getClass().getSimpleName();
    private String brand;
    private String color;
    private String description;
    private Double price;
    private Double size;
    @ManyToMany
    @JoinTable(name = "clothing_seasons",
            joinColumns = @JoinColumn(name = "clothing_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id"))
    private Set<Season> seasons;
}
