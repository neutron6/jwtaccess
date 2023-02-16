package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer saveData(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public List<Customer> getAllData() {
        return customerRepoImpl.findAll();
    }

    public Customer updateData(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public void deleteData(int custId) {
        customerRepoImpl.deleteById(custId);
    }

    public Boolean validateAdmin(int adminId, String adminPass) {
        for (Customer customer : customerRepoImpl.findAll()) {
            if (customer.getAdminId() == adminId && customer.getAdminPass().equals(adminPass)) {
                return true;
            }
        }
        return false;
    }
}
