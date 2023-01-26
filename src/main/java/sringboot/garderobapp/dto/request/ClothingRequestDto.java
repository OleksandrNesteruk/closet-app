package sringboot.garderobapp.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = SocksRequestDto.class, name = "socks"),
        @JsonSubTypes.Type(value = JacketRequestDto.class, name = "jacket"),
        @JsonSubTypes.Type(value = PulloverRequestDto.class, name = "pullover"),
        @JsonSubTypes.Type(value = ShirtRequestDto.class, name = "shirt"),
        @JsonSubTypes.Type(value = ShoesRequestDto.class, name = "shoes"),
        @JsonSubTypes.Type(value = TrousersRequestDto.class, name = "trousers"),
        @JsonSubTypes.Type(value = UnderwearRequestDto.class, name = "underwear"),
        @JsonSubTypes.Type(value = ShortsRequestDto.class, name = "shorts")})
public abstract class ClothingRequestDto {
    @Size(max = 30, message = "Max size is 30 character")
    private String brand;
    @Size(max = 30, message = "Max size is 30 character")
    private String color;
    @Size(max = 40, message = "Max size is 40 character")
    private String description;
    private Double price;
    private Double size;
    private Set<Long> seasonsId;
}
