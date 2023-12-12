package com.flexhamp.yandextaxischeduler.service;

import com.flexhamp.yandextaxischeduler.client.TaxiApiClient;
import com.flexhamp.yandextaxischeduler.model.Coordinate;
import com.flexhamp.yandextaxischeduler.model.MomentPrice;
import com.flexhamp.yandextaxischeduler.model.Price;
import com.flexhamp.yandextaxischeduler.properties.YandexProperties;
import com.flexhamp.yandextaxischeduler.repository.PriceRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaxiService {
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;
    private final YandexProperties yandexProperties;
    private final AtomicInteger price;

    public TaxiService(TaxiApiClient taxiApiClient, PriceRepository priceRepository, MeterRegistry meterRegistry, YandexProperties yandexProperties) {
        this.taxiApiClient = taxiApiClient;
        this.priceRepository = priceRepository;
        this.yandexProperties = yandexProperties;
        price = new AtomicInteger();
        meterRegistry.gauge("price", price);
    }

    @Transactional
    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.toString() + "~" + endPoint.toString();

        Price currentPrice = taxiApiClient.getPrice(yandexProperties.getClid(), yandexProperties.getApiKey(), rll);
        if (currentPrice.options.isEmpty()) {
            throw new RuntimeException("options null");
        }

        double priceDouble = currentPrice.options.get(0).getPrice();
        price.set((int) priceDouble);

        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Asia/Yerevan")),
                priceDouble);
        priceRepository.save(momentPrice);
    }

    public List<MomentPrice> getAllPrices() {
        return priceRepository.findAll();
    }
}