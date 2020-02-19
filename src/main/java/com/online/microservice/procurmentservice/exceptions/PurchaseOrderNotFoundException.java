package com.online.microservice.procurmentservice.exceptions;

public class PurchaseOrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7228229383122127607L;

	public PurchaseOrderNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderNotFoundException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
