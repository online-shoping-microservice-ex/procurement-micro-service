package com.online.microservice.procurmentservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "goods_receipt")
@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
public class GoodsReceipt {

	@Id
	@SequenceGenerator(name = "goods_receipt_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_receipt_id_seq")
	private Long id;

	@JsonProperty("GRNCode")
	private String GRNCode;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
	private PurchaseOrder purchaseOrder;

	private Double worth;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "goodsReceipt")	
	private List<GoodsReceiptItem> items;

	private LocalDateTime createdOn = LocalDateTime.now();

	private String receivedUser;

	public void addItem(GoodsReceiptItem item) {
		this.getItems().add(item);
		item.setGoodsReceipt(this);
	}

	public void removeItem(GoodsReceiptItem item) {
		this.getItems().remove(item);
		item.setGoodsReceipt(null);
	}

}
