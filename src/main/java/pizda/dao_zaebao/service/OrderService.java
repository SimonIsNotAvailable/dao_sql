package pizda.dao_zaebao.service;


import org.springframework.stereotype.Service;
import pizda.dao_zaebao.repository.DaoRepository;

@Service
public class OrderService {
    private DaoRepository daoRepository;

    public String getProductNameFromCustomerName(String customerName) {
        return daoRepository.getProductName(customerName);
    }
}