package guru.springframework.msscbrewery.web.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;

import java.util.UUID;

public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("cola")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(23L)
                .build();
    }

    @Override
    public BeerDtoV2 createBeer(BeerDtoV2 beerDto) {
        beerDto.setId(UUID.randomUUID());
        return beerDto;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }

}
