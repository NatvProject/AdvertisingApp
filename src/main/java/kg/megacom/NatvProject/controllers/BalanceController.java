package kg.megacom.NatvProject.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NatvProject.models.dtos.BalanceDto;
import kg.megacom.NatvProject.services.BalanceService;
import kg.megacom.NatvProject.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

import static kg.megacom.NatvProject.config.SpringFoxConfig.BALANCE;

@Api(tags = BALANCE)
@RestController
@RequestMapping("/api/v1/balances")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/byClient/{id}")
    @ApiOperation(value = "Нахождение баланса по ID клиента")
    public BalanceDto findBalanceByClientId(@PathVariable Long id){
        return balanceService.findByClientId(id);
    }
}
