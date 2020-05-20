package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto findById(UUID customerId);

    CustomerDto create(CustomerDto customerDto);

    void update(UUID customerId, CustomerDto customerDto);

    void delete(UUID customerId);
}
