package com.online.microservice.procurmentservice.services;

import java.util.List;

import com.online.microservice.procurmentservice.entity.GoodsReceipt;
import com.online.microservice.procurmentservice.entity.PurchaseOrder;
import com.online.microservice.procurmentservice.exceptions.PurchaseOrderDeleteConstraintFailedException;
import com.online.microservice.procurmentservice.model.GoodsReceiptNotesModel;
import com.online.microservice.procurmentservice.model.PurchaseOrderModal;

public interface ProcurementService {

	void createPurchaseOrder(PurchaseOrderModal purchaseOrder);

	void updatePurchaserOrder(Long purchaseOrderId, PurchaseOrder purchaseOrder);

	void deletePurchaseOrder(Long purchaseorderId) throws PurchaseOrderDeleteConstraintFailedException;

	void createGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes);

	void updateGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes);

	void createGoodsReturn();

	void upateGoodsReturn();

	List<PurchaseOrder> findAllPurchaseOrders();

	PurchaseOrder findPurchaseOrderById(Long id);

	List<PurchaseOrder> findAllPendingPurchaseOrders();

	List<GoodsReceipt> findAllGoodsReceiptsExcludeItemAndPurchaseOrder();

}
