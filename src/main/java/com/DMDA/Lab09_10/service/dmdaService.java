package com.DMDA.Lab09_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.DMDA.Lab09_10.entity.dmdaEntity;
import com.DMDA.Lab09_10.repository.dmdaRepository;

@Service
public class dmdaService {
    @Autowired
    private dmdaRepository repository;

    public List<dmdaEntity> getAllAccounts() {
        return repository.findAll();
    }

    public dmdaEntity getAccountById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public dmdaEntity saveAccount(dmdaEntity account) {
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}

