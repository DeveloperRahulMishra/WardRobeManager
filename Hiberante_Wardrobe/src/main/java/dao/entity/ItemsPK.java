/**
 * 
 */
package dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Rahul
 *
 */
@Embeddable
public class ItemsPK implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Column(name = "SEQNUM")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sequenceNumber;

	@Column(name = "WRDNAM")
	private String wardRobeName;

	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber
	 *            the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @return the wardRobeName
	 */
	public String getWardRobeName() {
		return wardRobeName;
	}

	/**
	 * @param wardRobeName
	 *            the wardRobeName to set
	 */
	public void setWardRobeName(String wardRobeName) {
		this.wardRobeName = wardRobeName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sequenceNumber;
		result = prime * result
				+ ((wardRobeName == null) ? 0 : wardRobeName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsPK other = (ItemsPK) obj;
		if (sequenceNumber != other.sequenceNumber)
			return false;
		if (wardRobeName == null) {
			if (other.wardRobeName != null)
				return false;
		} else if (!wardRobeName.equals(other.wardRobeName))
			return false;
		return true;
	}

}
