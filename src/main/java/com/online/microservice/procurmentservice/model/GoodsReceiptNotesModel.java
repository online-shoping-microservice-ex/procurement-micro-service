package com.online.microservice.procurmentservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.online.microservice.procurmentservice.entity.GoodsReceiptItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsReceiptNotesModel {

	
	private String id;

	@JsonProperty("GRNCode")
	private String GRNCode;

	private Double worth;

	private List<GoodsReceiptItem> goodsReceiptItems;

	private String purchaseOrderId;

	

}
