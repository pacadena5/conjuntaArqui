package ec.edu.espe.conjunta2Cadena.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.conjunta2Cadena.model.Car;
import ec.edu.espe.conjunta2Cadena.model.Customer;
import ec.edu.espe.conjunta2Cadena.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public void createOne(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void changeOne(@RequestBody Customer customer, @PathVariable String id) {
        Customer custom = customerRepository.findById(id).get();
        custom.setFirstName(customer.getFirstName());
        custom.setLastName(customer.getLastName());
        customerRepository.save(custom);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteOne(@PathVariable String id) {
        customerRepository.deleteById(id);
    }

    @RequestMapping(value="/{model}", method=RequestMethod.GET)
    public List<Customer> findByCarModel(@PathVariable String model) {
        Customer customer = customerRepository.findByCarsModel(model).get(0);
        Car car = new Car();
        for (int i = 0; i < customer.cars.size(); i++) {
            car = customer.cars.get(i);
            System.out.println("el model>" + car.getModel());
            System.out.println("el param>" + model);
            if (car.model.equals(model)){
                System.out.println("entro al if");
                customer.cars.remove(i);
            }
        }
        /* for (Car car2 : customer.cars) {
            if (car2.model.equals(model)){
                System.out.println("entro al if");
                customer.cars.remove(car2);
            }
        } */
        System.out.println("cars>");
        System.out.println(customer.cars);
        customerRepository.save(customer);
        return customerRepository.findAll();
    }
}
