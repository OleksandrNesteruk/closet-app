package sringboot.garderobapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocksRequestDto extends ClothingRequestDto {
    private int pairsAmount;
}
