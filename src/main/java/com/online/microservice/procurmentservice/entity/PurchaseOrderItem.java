package com.online.microservice.procurmentservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_order_item")
@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
public class PurchaseOrderItem {

	@Id
	@SequenceGenerator(name = "purchser_order_item_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchser_order_item_id_seq")
	private long id;

	private String productId;

	private long orderedQty;

	private long receivedQty;

	private long pendingQty;

	private Double cost;

	private Double unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchaser_order_id", referencedColumnName = "id")
	private PurchaseOrder purchaseOrder;

}
