package com.example.pbbo.Model.SalesDepartment;


/**
 * @author Kevin Hartono
 * @version 1.0
 * @created 26-Oct-2020 07:37:24
 */
public class SalesDepartment {

	private String email;
	private String id;
	private SalesInvoice invoice;
	private String phoneNum;
	public SalesInvoice m_SalesInvoice;
	public VendorPayment m_VendorPayment;

	public SalesDepartment(){

	}

	public void finalize() throws Throwable {

	}

}