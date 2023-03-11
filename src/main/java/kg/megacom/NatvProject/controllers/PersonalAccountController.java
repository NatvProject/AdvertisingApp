package kg.megacom.NatvProject.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NatvProject.models.dtos.AdvertisementDto;
import kg.megacom.NatvProject.models.dtos.BalanceDto;
import kg.megacom.NatvProject.models.dtos.BannerDto;
import kg.megacom.NatvProject.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;

import static kg.megacom.NatvProject.config.SpringFoxConfig.PERSONAL_ACCOUNT;

@Api(tags = PERSONAL_ACCOUNT)
@RestController
@RequestMapping("/api/v1/personal-account")
@RequiredArgsConstructor
public class PersonalAccountController {

    private final JwtService jwtService;
    private final BalanceService balanceService;
    private final BannerService bannerService;
    private final AdvertisementService advertisementService;
    private final PaymentService paymentService;

    @PutMapping("/addMoney")
    @ApiOperation(value = "Пополнение баланса клиента")
    public BalanceDto addMoney(@RequestParam double sum) {
        return balanceService.addMoney(sum, extractClientFromToken());
    }

    @GetMapping("/myBannersList")
    @ApiOperation(value = "Вывод списка баннеров клиента")
    public List<BannerDto> findAllBanners() {
        return bannerService.findAllBannersByClient(extractClientFromToken());
    }

    @GetMapping("/myAdsList")
    @ApiOperation(value = "Вывод списка объявлений клиента")
    public List<AdvertisementDto> findAllAds() {
        return advertisementService.findAllAdvertisementsByClient(extractClientFromToken());
    }

    @PutMapping("/AdPayment/{id}")
    @ApiOperation(value = "Оплата за текстовое объявление")
    public ResponseEntity<?> payForAdvertisement(@PathVariable Long id){
        return paymentService.payForAdvertisement(id);
    }

    @PutMapping("/bannerPayment/{id}")
    @ApiOperation(value = "Оплата за баннерное объявление")
    public ResponseEntity<?> payForBanner(@PathVariable Long id){
        return paymentService.payForBanner(id);
    }


    private String extractClientFromToken(){
        String token = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder
                        .getRequestAttributes())).getRequest()
                .getHeader("Authorization");
        return balanceService.findByClientEmail(jwtService.extractUsername(token)).getClient().getEmail();
    }


}
