package guru.springframework.msscbrewery.web.controllers;

import com.sun.net.httpserver.Headers;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.findById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handleCreate(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto customerDtoCreated =  customerService.create(customerDto);
        Headers headers = new Headers();
        headers.add("Location", BASE_URL + "/" + customerDtoCreated.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable UUID customerId, @Valid @RequestBody CustomerDto customerDto){
        customerService.update(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity handleDelete(@PathVariable UUID customerId){
        customerService.delete(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
