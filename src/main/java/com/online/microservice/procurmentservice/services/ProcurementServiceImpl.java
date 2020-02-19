/**
 * 
 */
package com.online.microservice.procurmentservice.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.microservice.procurmentservice.entity.GoodsReceipt;
import com.online.microservice.procurmentservice.entity.PurchaseOrder;
import com.online.microservice.procurmentservice.exceptions.PurchaseOrderDeleteConstraintFailedException;
import com.online.microservice.procurmentservice.exceptions.PurchaseOrderNotFoundException;
import com.online.microservice.procurmentservice.model.GoodsReceiptNotesModel;
import com.online.microservice.procurmentservice.model.PurchaseOrderModal;
import com.online.microservice.procurmentservice.repository.PurchaseOrderRepository;
import com.online.microservice.procurmentservice.util.PurchaseOrderStatus;

/**
 * @author HOME
 *
 */
@Service
@Transactional
public class ProcurementServiceImpl implements ProcurementService {

	private final String PURCHASE_ORDER_NOT_FOUND_MSG = "Purchaser order not found for given id : %1$s";

	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	com.online.microservice.procurmentservice.repository.GRNRepository GRNRepository;

	@Override
	public void createPurchaseOrder(PurchaseOrderModal purchaseOrderModal) {

//		Users user = (Users) CurrentLoginUser.getUser();

		PurchaseOrder purchaseOrder = new PurchaseOrder();

		BeanUtils.copyProperties(purchaseOrderModal, purchaseOrder);
		purchaseOrder.setCratedDate(LocalDateTime.now());
//		purchaseOrder.setUserName(user.getUsername());
		purchaseOrder.setSupplierId(purchaseOrderModal.getSupplierId());
		purchaseOrder.setStatus(PurchaseOrderStatus.PENDING);

		// TODO Auto-generated method stub
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	public void updatePurchaserOrder(Long purchaseOrderId, PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePurchaseOrder(Long purchaseorderId) throws PurchaseOrderDeleteConstraintFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes) {
		// TODO Auto-generated method stub
		GoodsReceipt gr = new GoodsReceipt();
		BeanUtils.copyProperties(goodsReceiptNotes, gr, "createdOn");
		this.GRNRepository.save(gr);

//		List<GoodsReceipt> goodsReceipt = GRNRepository.findAllByPurchaseOrder(gr.getPurchaseOrder());

	}

	@Override
	public void updateGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGoodsReturn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void upateGoodsReturn() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		// TODO Auto-generated method stub

		return purchaseOrderRepository.findAll();
	}

	@Override
	public List<PurchaseOrder> findAllPendingPurchaseOrders() {
		// TODO Auto-generated method stub
		return purchaseOrderRepository.findAll();
	}

	@Override
	public PurchaseOrder findPurchaseOrderById(Long id) {
		// TODO Auto-generated method stub

		return purchaseOrderRepository.findById(id).orElseThrow(() -> {
			throw new PurchaseOrderNotFoundException(String.format(this.PURCHASE_ORDER_NOT_FOUND_MSG, id));
		});
	}

	@Override
	public List<GoodsReceipt> findAllGoodsReceiptsExcludeItemAndPurchaseOrder() {
		// TODO Auto-generated method stub
		return GRNRepository.findAll();
	}

}
