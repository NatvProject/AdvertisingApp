package kg.megacom.NatvProject.services.impl;

import kg.megacom.NatvProject.mappers.BalanceMapper;
import kg.megacom.NatvProject.mappers.ClientMapper;
import kg.megacom.NatvProject.models.dtos.BalanceDto;
import kg.megacom.NatvProject.models.dtos.ClientDto;
import kg.megacom.NatvProject.models.entities.Balance;
import kg.megacom.NatvProject.repositories.BalanceRepo;
import kg.megacom.NatvProject.services.BalanceService;
import kg.megacom.NatvProject.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepo balanceRepo;
    private final BalanceMapper balanceMapper;
    private final ClientMapper clientMapper;
    private final ClientService clientService;


    @Override
    public void saveBalance(ClientDto clientDto) {
        if (Objects.isNull(findByClientEmail(clientDto.getEmail()))) {
            balanceRepo.save(toNewBalance(clientDto));
        }
    }

    private Balance toNewBalance(ClientDto clientDto) {
        return Balance.builder()
                .balance(0D)
                .client(clientMapper.toEntity(clientDto))
                .build();
    }

    @Override
    public BalanceDto update(BalanceDto balance) {
        return balanceMapper.toDto(
                balanceRepo.save(balanceMapper.toEntity(balance)));
    }

    @Override
    public BalanceDto findByClientId(Long id) {
        return balanceMapper.toDto(balanceRepo.findByClient_Id(id));
    }

    @Override
    public BalanceDto findByClientEmail(String email) {
        return balanceMapper.toDto(balanceRepo.findByClientEmail(email));
    }

    @Override
    public BalanceDto addMoney(double sum, String clientEmail) {
        Balance balance = balanceRepo.findByClientEmail(clientEmail);
        balance.setBalance(balance.getBalance() + sum);

        log.info("Баланс клиента с email «" + clientEmail + "» был пополнен на сумму " + sum);
        return balanceMapper.toDto(balanceRepo.save(balance));
    }
}
