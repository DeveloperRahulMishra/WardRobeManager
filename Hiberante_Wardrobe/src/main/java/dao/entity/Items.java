/**
 * 
 */
package dao.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author Rahul
 *
 */
@Entity
@Table(name = "ITMES")
public class Items {

	public Items() {
	}

	@EmbeddedId
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "SEQNUM", nullable = false, updatable = false), name = "sequenceNumber"),
			@AttributeOverride(column = @Column(name = "WRDNAM", nullable = false, updatable = false), name = "wardRobeName") })
	private ItemsPK primaryKey;

	@Column(name = "NAM", length = 50, nullable = false)
	private String name;

	@Column(name = "PRC", length = 10)
	private String price;

	@Column(name = "PRCDAT")
	private Date purchaseDate;

	@Column(name = "CLR", length = 20, nullable = false)
	private String color;

	@Column(name = "TYP", length = 20)
	private String type;

	@Column(name = "SBTYP", length = 20)
	private String subType;

	@Column(name = "RATNG", length = 5)
	private String rating;

	@Version
	@Column(name = "UPDDAT", length = 20)
	private Date update;

	@Column(name = "SZE", length = 5)
	private String size;

	@Column(name = "BRND", length = 50, nullable = false)
	private String brand;

/*	@ManyToOne(fetch = FetchType.LAZY,optional)
	@JoinColumns(value = {
			@JoinColumn(name = "SEQNUM", insertable = false, updatable = false),
			@JoinColumn(name = "NAM", insertable = false, updatable = false),
			@JoinColumn(name = "USRNAM", insertable = false, updatable = false) })
	private Wardrobe wardrobes;*/


	/**
	 * @return the primaryKey
	 */
	public ItemsPK getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * @param primaryKey
	 *            the primaryKey to set
	 */
	public void setPrimaryKey(ItemsPK primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate
	 *            the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType
	 *            the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the update
	 */
	public Date getUpdate() {
		return update;
	}

	/**
	 * @param update
	 *            the update to set
	 */
	public void setUpdate(Date update) {
		this.update = update;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
