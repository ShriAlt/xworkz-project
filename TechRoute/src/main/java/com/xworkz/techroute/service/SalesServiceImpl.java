package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.SalesDTO;
import com.xworkz.techroute.entity.ProductMasterEntity;
import com.xworkz.techroute.entity.SalesEntity;
import com.xworkz.techroute.entity.StockEntity;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.repository.ProductMasterRepository;
import com.xworkz.techroute.repository.SalesRepository;
import com.xworkz.techroute.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SalesServiceImpl implements SalesService{

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductMasterRepository productRepository;

    @Override
    public IssueCode validateAndSaveSale(SalesDTO salesDTO) {
        try {
            ProductMasterEntity product = productRepository.findByProductCode(salesDTO.getProductCode());
            if (product == null) {
                return IssueCode.PRODUCT_NOT_FOUND;
            }
            StockEntity stock = stockRepository.findByProduct_ProductCode(salesDTO.getProductCode());
            if (stock == null) {
                return IssueCode.STOCK_NOT_FOUND;
            }
            if (salesDTO.getSaleQuantity() == null || salesDTO.getSaleQuantity() <= 0) {
                return IssueCode.INVALID_QUANTITY;
            }
            if (salesDTO.getSaleQuantity() > stock.getQuantity()) {
                return IssueCode.INSUFFICIENT_STOCK;
            }
            SalesEntity sale = new SalesEntity();
            sale.setCustomerName(salesDTO.getCustomerName());
            sale.setAvailableStock(salesDTO.getAvailableStock());
            sale.setProductGroupName(salesDTO.getProductGroupName());
            sale.setProductName(salesDTO.getProductName());
            sale.setCompanyName(salesDTO.getCompanyName());
            sale.setModel(salesDTO.getModel());
            sale.setProductCode(salesDTO.getProductCode());
            sale.setSaleQuantity(salesDTO.getSaleQuantity());
            sale.setSalePrice(salesDTO.getSalePrice());
            sale.setOrderStatus(salesDTO.getOrderStatus());
            sale.setCreatedAt(LocalDateTime.now());

            salesRepository.save(sale);

            stock.setQuantity(stock.getQuantity() - salesDTO.getSaleQuantity());
            stock.setLastUpdated(LocalDateTime.now());
            stockRepository.save(stock);

            return IssueCode.OK;

        } catch (Exception e) {
            e.printStackTrace();
            return IssueCode.DB_ERROR;
        }
    }

}
