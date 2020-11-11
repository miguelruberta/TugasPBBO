package com.example.pbbo.Model.Customer;

import java.util.Date;

import com.example.pbbo.Model.Vendor.Kaos;
import com.example.pbbo.Model.Vendor.Sablon;

/**
 * @author Kevin Hartono
 * @version 1.0
 * @created 26-Oct-2020 07:34:23
 */
public class Order {

	private String designFile;
	private int idOrder;
	private int jumlahOrder;
	private Kaos kaos;
	private Sablon sablon;
	private Date tanggal;
	private int totalPrice;
	public Customer m_Customer;

	public Order(){

	}

	public void finalize() throws Throwable {

	}

}