package kg.megacom.NatvProject.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NatvProject.models.dtos.AdvertisementDto;
import kg.megacom.NatvProject.services.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kg.megacom.NatvProject.config.SpringFoxConfig.ADVERTISEMENTS;

@Api(tags = ADVERTISEMENTS)
@RestController
@RequestMapping("/api/v1/ads")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Вывод объявления по ID")
    public AdvertisementDto getById(@PathVariable Long id) {
        return advertisementService.findById(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "Вывод списка обяъвлений")
    public List<AdvertisementDto> findAll() {
        return advertisementService.findAll();
    }
}