package sringboot.garderobapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocksResponseDto extends ClothingResponseDto {
    private int pairsAmount;
}
