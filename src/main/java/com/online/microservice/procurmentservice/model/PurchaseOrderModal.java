package com.online.microservice.procurmentservice.model;

import java.time.LocalTime;
import java.util.List;

import com.online.microservice.procurmentservice.entity.PurchaseOrderItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseOrderModal {

	private String id;

	private String purchaseOrderCode;

	private LocalTime cratedDate;

	private Double worth;

	private List<PurchaseOrderItem> items;

	private String supplierId;

}
