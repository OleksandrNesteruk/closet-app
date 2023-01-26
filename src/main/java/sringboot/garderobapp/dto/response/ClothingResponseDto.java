package sringboot.garderobapp.dto.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = SocksResponseDto.class, name = "socks"),
        @JsonSubTypes.Type(value = JacketResponseDto.class, name = "jacket"),
        @JsonSubTypes.Type(value = PulloverResponseDto.class, name = "pullover"),
        @JsonSubTypes.Type(value = ShirtResponseDto.class, name = "shirt"),
        @JsonSubTypes.Type(value = ShoesResponseDto.class, name = "shoes"),
        @JsonSubTypes.Type(value = TrousersResponseDto.class, name = "trousers"),
        @JsonSubTypes.Type(value = UnderwearResponseDto.class, name = "underwear"),
        @JsonSubTypes.Type(value = ShoesResponseDto.class, name = "shorts"),})
public abstract class ClothingResponseDto {
    @NotEmpty
    private Long id;

    private String brand;
    private String color;
    private String description;
    private Double price;
    private Double size;
    private Set<Long> seasonsId;
}
