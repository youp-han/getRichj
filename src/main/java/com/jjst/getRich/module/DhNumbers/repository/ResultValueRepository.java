package com.jjst.getRich.module.DhNumbers.repository;

import com.jjst.getRich.module.DhNumbers.entity.ResultValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultValueRepository extends JpaRepository<ResultValue, Long> {

    ResultValue findResultValueByDrwNo(Integer no);

    @Query("SELECT COUNT(p) FROM ResultValue p")
    long countAllResultValue();

    @Query("SELECT MAX(r.drwNo) FROM ResultValue r")
    Integer findMaxDrawNo();

}
