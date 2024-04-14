package hong2828.banking.service.impl;

import hong2828.banking.dto.AccountDto;
import hong2828.banking.entity.Account;
import hong2828.banking.mapper.AccountMapper;
import hong2828.banking.repository.AccountRepository;
import hong2828.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
