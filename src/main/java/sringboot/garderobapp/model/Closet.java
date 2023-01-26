package sringboot.garderobapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "closets")
public class Closet {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "closets_clothing",
            joinColumns = @JoinColumn(name = "closet_id"),
            inverseJoinColumns = @JoinColumn(name = "clothing_id"))
    private List<Clothing> clothes;
    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;
}
