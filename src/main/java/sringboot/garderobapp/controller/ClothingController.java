package sringboot.garderobapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sringboot.garderobapp.dto.response.ClothingResponseDto;
import sringboot.garderobapp.mappers.ClothingMapper;
import sringboot.garderobapp.service.ClothingService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clothing")
@RequiredArgsConstructor
public class ClothingController {
    private final ClothingService clothingService;
    private final ClothingMapper clothingMapper;

    @GetMapping
    public List<ClothingResponseDto> findAll(@RequestParam Map<String, String> params) {
        return clothingService.findAll(params).stream()
                .map(clothingMapper::mapToDto)
                .toList();
    }
}
