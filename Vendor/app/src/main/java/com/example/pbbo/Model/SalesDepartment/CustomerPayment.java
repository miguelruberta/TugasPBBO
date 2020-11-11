package com.example.pbbo.Model.SalesDepartment;

import com.example.pbbo.Model.Customer.*;

/**
 * @author Kevin Hartono
 * @version 1.0
 * @created 26-Oct-2020 07:37:39
 */
public class CustomerPayment {

	private Customer customer;
	private String id;
	private SalesInvoice invoice;
	private int jumlah;
	private String method;
	public SalesInvoice m_SalesInvoice;

	public CustomerPayment(){

	}

	public void finalize() throws Throwable {

	}

}