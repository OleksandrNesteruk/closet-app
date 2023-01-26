package sringboot.garderobapp.mappers;

import lombok.RequiredArgsConstructor;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.dto.request.ClothingRequestDto;
import sringboot.garderobapp.dto.request.JacketRequestDto;
import sringboot.garderobapp.dto.request.PulloverRequestDto;
import sringboot.garderobapp.dto.request.ShirtRequestDto;
import sringboot.garderobapp.dto.request.ShoesRequestDto;
import sringboot.garderobapp.dto.request.ShortsRequestDto;
import sringboot.garderobapp.dto.request.SocksRequestDto;
import sringboot.garderobapp.dto.request.TrousersRequestDto;
import sringboot.garderobapp.dto.request.UnderwearRequestDto;
import sringboot.garderobapp.dto.response.ClothingResponseDto;
import sringboot.garderobapp.dto.response.JacketResponseDto;
import sringboot.garderobapp.dto.response.PulloverResponseDto;
import sringboot.garderobapp.dto.response.ShirtResponseDto;
import sringboot.garderobapp.dto.response.ShoesResponseDto;
import sringboot.garderobapp.dto.response.ShortsResponseDto;
import sringboot.garderobapp.dto.response.SocksResponseDto;
import sringboot.garderobapp.dto.response.TrousersResponseDto;
import sringboot.garderobapp.dto.response.UnderwearResponseDto;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.model.Jacket;
import sringboot.garderobapp.model.Pullover;
import sringboot.garderobapp.model.Season;
import sringboot.garderobapp.model.Shirt;
import sringboot.garderobapp.model.Shoes;
import sringboot.garderobapp.model.Shorts;
import sringboot.garderobapp.model.Socks;
import sringboot.garderobapp.model.Trousers;
import sringboot.garderobapp.model.Underwear;
import sringboot.garderobapp.service.SeasonService;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mapstruct.SubclassExhaustiveStrategy.RUNTIME_EXCEPTION;

@Mapper(componentModel = "spring")
@Component
@RequiredArgsConstructor
public abstract class ClothingMapper {
    protected SeasonService seasonService;

    @Mapping(target = "seasons", source = "seasonsId")
    @SubclassMapping(source = SocksRequestDto.class, target = Socks.class)
    @SubclassMapping(source = JacketRequestDto.class, target = Jacket.class)
    @SubclassMapping(source = PulloverRequestDto.class, target = Pullover.class)
    @SubclassMapping(source = ShirtRequestDto.class, target = Shirt.class)
    @SubclassMapping(source = ShoesRequestDto.class, target = Shoes.class)
    @SubclassMapping(source = TrousersRequestDto.class, target = Trousers.class)
    @SubclassMapping(source = UnderwearRequestDto.class, target = Underwear.class)
    @SubclassMapping(source = ShortsRequestDto.class, target = Shorts.class)
    @BeanMapping(subclassExhaustiveStrategy = RUNTIME_EXCEPTION)
    public abstract Clothing mapToModel(ClothingRequestDto source);

    protected Set<Season> mapToSeason(Set<Long> value) {
        return value.stream()
                .map(seasonService::getById)
                .collect(Collectors.toSet());
    }

    @Mapping(target = "seasonsId", source = "seasons")
    @SubclassMapping(source = Socks.class, target = SocksResponseDto.class)
    @SubclassMapping(source = Jacket.class, target = JacketResponseDto.class)
    @SubclassMapping(source = Pullover.class, target = PulloverResponseDto.class)
    @SubclassMapping(source = Shirt.class, target = ShirtResponseDto.class)
    @SubclassMapping(source = Shoes.class, target = ShoesResponseDto.class)
    @SubclassMapping(source = Trousers.class, target = TrousersResponseDto.class)
    @SubclassMapping(source = Underwear.class, target = UnderwearResponseDto.class)
    @SubclassMapping(source = Shorts.class, target = ShortsResponseDto.class)
    @BeanMapping(subclassExhaustiveStrategy = RUNTIME_EXCEPTION)
    public abstract ClothingResponseDto mapToDto(Clothing clothing);

    protected Set<Long> mapToIds(Set<Season> value) {
        return value.stream()
                .map(Season::getId)
                .collect(Collectors.toSet());
    }
}
