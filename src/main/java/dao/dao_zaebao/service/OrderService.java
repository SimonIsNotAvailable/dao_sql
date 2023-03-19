package dao.dao_zaebao.service;


import dao.dao_zaebao.repository.DaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderService(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    private DaoRepository daoRepository;

    public List<String> getProductNameFromCustomerName(String customerName) {
        return daoRepository.getProductName(customerName);
    }
}