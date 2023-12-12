package com.flexhamp.yandextaxischeduler.repository;

import com.flexhamp.yandextaxischeduler.model.MomentPrice;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<MomentPrice, Long> {
    @Timed("gettingPricesFromDB")
    List<MomentPrice> findAll();
}