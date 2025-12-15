package org.example.ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.AccountOwner;
import org.example.ex1.repository.AccountOwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final AccountOwnerRepository accountOwnerRepository;

    @Transactional
    public void add10BankAccOwners(){
        for (int i = 0; i < 10; i++) {
            AccountOwner accountOwner = AccountOwner
                    .builder()
                    .accountOwnerName("AccOwner " + i)
                    .build();

            if(i == 5) {
                throw new RuntimeException("Simulated exception at i=5");
            }

            accountOwnerRepository.save(accountOwner);
        }
    }
}
