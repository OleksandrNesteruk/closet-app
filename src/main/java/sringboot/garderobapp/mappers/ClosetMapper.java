package sringboot.garderobapp.mappers;

import org.mapstruct.Mapper;
import sringboot.garderobapp.dto.response.ClosetResponseDto;
import sringboot.garderobapp.model.Closet;

@Mapper(componentModel = "spring")
public interface ClosetMapper {
    ClosetResponseDto mapToDto(Closet closet);
}
