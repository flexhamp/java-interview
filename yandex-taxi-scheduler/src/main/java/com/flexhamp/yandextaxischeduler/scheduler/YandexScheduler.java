package com.flexhamp.yandextaxischeduler.scheduler;

import com.flexhamp.yandextaxischeduler.model.Coordinate;
import com.flexhamp.yandextaxischeduler.properties.CoordinateProperties;
import com.flexhamp.yandextaxischeduler.service.TaxiService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {
    private final TaxiService taxiService;
    private final CoordinateProperties coordinateProperties;

    @Timed("gettingPriceScheduler")
    @Scheduled(fixedDelay = 30_000)
    public void updatePrices() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLatitude(), coordinateProperties.getStartLongitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLatitude(), coordinateProperties.getFinishLongitude());
        taxiService.getPrice(startPoint, endPoint);
    }
}