package sringboot.garderobapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoesRequestDto extends ClothingRequestDto {
    private String type;
}
