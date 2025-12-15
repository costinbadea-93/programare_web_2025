package org.example.ex1.repository;

import org.example.ex1.model.AccountOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOwnerRepository extends JpaRepository<AccountOwner, Long> {
}
