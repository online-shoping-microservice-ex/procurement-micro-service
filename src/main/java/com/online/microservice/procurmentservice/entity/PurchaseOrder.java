package com.online.microservice.procurmentservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.online.microservice.procurmentservice.util.PurchaseOrderStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_order")
@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
public class PurchaseOrder {

	@Id
	@SequenceGenerator(name = "purchser_order_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchser_order_id_seq")
	private Long id;

	private String purchaseOrderCode;

	private LocalDateTime cratedDate = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private PurchaseOrderStatus status;

	private Double worth;

	private String userName;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "purchaseOrder")
	private List<PurchaseOrderItem> items;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "purchaseOrder")
	private List<GoodsReceipt> goodsReceipts;

	private String supplierId;

	public void addItem(PurchaseOrderItem item) {
		this.getItems().add(item);
		item.setPurchaseOrder(this);
	}

	public void removeItem(PurchaseOrderItem item) {
		this.getItems().remove(item);
		item.setPurchaseOrder(null);
	}

}
