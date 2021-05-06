package com.store.payment.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Order
 */
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "number_order")
	private Long numberOrder = null;

	@Column(name = "quantity")
	private Long quantity = null;

	@Column(name = "delivery_cost")
	private Long deliveryCost = null;
	
	@Column(name = "discount")
	private Long discount = null;

	@Column(name = "total_bill")
	private Long totalBill = null;

	@Column(name = "shipdate")
	private LocalDateTime shipDate = null;

	@Column(name = "orderdate")
	private LocalDateTime orderDate = null;
	
	@JoinColumn(name = "product_id")
	private Long productId = null;
	
	@Column(name = "customer_id")
    private Long customerId= null;
	
	@Column(name = "statusOrder", nullable = false)
    @Enumerated(value = EnumType.STRING)
	private StatusEnum statusOrder = null;

	@ElementCollection  
    private List<Product> productList=new ArrayList<Product>();

	/**
	 * Getter and setter
	 **/
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the numberOrder
	 */
	public Long getNumberOrder() {
		return numberOrder;
	}

	/**
	 * @param numberOrder the numberOrder to set
	 */
	public void setNumberOrder(Long numberOrder) {
		this.numberOrder = numberOrder;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the deliveryCost
	 */
	public Long getDeliveryCost() {
		return deliveryCost;
	}

	/**
	 * @param deliveryCost the deliveryCost to set
	 */
	public void setDeliveryCost(Long deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	/**
	 * @return the totalBill
	 */
	public Long getTotalBill() {
		return totalBill;
	}

	/**
	 * @param totalBill the totalBill to set
	 */
	public void setTotalBill(Long totalBill) {
		this.totalBill = totalBill;
	}

	/**
	 * @return the shipDate
	 */
	public LocalDateTime getShipDate() {
		return shipDate;
	}

	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(LocalDateTime shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the discount
	 */
	public Long getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	/**
	 * @return the statusOrder
	 */
	public StatusEnum getStatusOrder() {
		return statusOrder;
	}

	/**
	 * @param statusOrder the statusOrder to set
	 */
	public void setStatusOrder(StatusEnum statusOrder) {
		this.statusOrder = statusOrder;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	

}
