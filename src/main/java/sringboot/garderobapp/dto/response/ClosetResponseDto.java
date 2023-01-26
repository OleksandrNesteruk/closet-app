package sringboot.garderobapp.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ClosetResponseDto {
    private List<Long> clothingId;
    private Long id;
}
