package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto findById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("amazon")
                .build();
    }
}
