package com.DMDA.Lab09_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DMDA.Lab09_10.entity.dmdaEntity;

public interface dmdaRepository extends JpaRepository<dmdaEntity, Long> {
}

