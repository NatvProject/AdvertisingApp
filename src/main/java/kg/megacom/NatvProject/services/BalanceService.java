package kg.megacom.NatvProject.services;

import kg.megacom.NatvProject.models.dtos.BalanceDto;
import kg.megacom.NatvProject.models.dtos.ClientDto;

public interface BalanceService {
    BalanceDto findByClientId(Long id);
    BalanceDto findByClientEmail(String email);
    void saveBalance(ClientDto clientDto);
    BalanceDto update(BalanceDto balance);
    BalanceDto addMoney(double sum, String clientEmail);
}
