/**
 * 
 */
package dao.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author Rahul
 *
 */
@Entity
@Table(name = "WARDROBE")
public class Wardrobe {

	public Wardrobe() {
		// defults
	}

	@EmbeddedId
	private WardrobePK wardrobePK;

	@Version
	@Column(name = "UPDDAT")
	private Date upddate;

	@Column(name = "USRCOD")
	private String userCode;

	@Column(name = "CRTDAT")
	private Date createdDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Items> items;

	/**
	 * @return the wardrobePK
	 */
	public WardrobePK getWardrobePK() {
		return wardrobePK;
	}

	/**
	 * @param wardrobePK
	 *            the wardrobePK to set
	 */
	public void setWardrobePK(WardrobePK wardrobePK) {
		this.wardrobePK = wardrobePK;
	}

	/**
	 * @return the upddate
	 */
	public Date getUpddate() {
		return upddate;
	}

	/**
	 * @param upddate
	 *            the upddate to set
	 */
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode
	 *            the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the items
	 */
	public Set<Items> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Set<Items> items) {
		this.items = items;
	}

}
