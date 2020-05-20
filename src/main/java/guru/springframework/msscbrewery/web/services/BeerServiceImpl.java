package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("cola")
                .beerStyle("pale ale")
                .upc(23L)
                .build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        beerDto.setId(UUID.randomUUID());
        return beerDto;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
