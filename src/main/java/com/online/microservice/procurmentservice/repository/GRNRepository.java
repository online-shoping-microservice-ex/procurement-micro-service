package com.online.microservice.procurmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.microservice.procurmentservice.entity.GoodsReceipt;
import com.online.microservice.procurmentservice.entity.PurchaseOrder;

@Repository
public interface GRNRepository extends JpaRepository<GoodsReceipt, Long>{

	List<GoodsReceipt> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);
	
}
