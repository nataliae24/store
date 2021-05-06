package com.store.payment.core.model;

import javax.persistence.*;

/**
 * Product
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "code")
	private String code = null;

	@Column(name = "name")
	private String name = null;

	@Column(name = "description")
	private String description = null;

	@Column(name = "price")
	private String price = null;

	@Column(name = "status_product", nullable = false)
    @Enumerated(value = EnumType.STRING)
	private StatusProduct statusProduct = null;
	

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the statusProduct
	 */
	public StatusProduct getStatusProduct() {
		return statusProduct;
	}

	/**
	 * @param statusProduct the statusProduct to set
	 */
	public void setStatusProduct(StatusProduct statusProduct) {
		this.statusProduct = statusProduct;
	}

	
}
