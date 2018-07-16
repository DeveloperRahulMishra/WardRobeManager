/**
 * 
 */
package dao.utility;

import java.util.List;

import org.hibernate.Session;

import utlis.connection.HibernateUtil;
import vo.WardrobeVO;
import dao.entity.WardrobeKey;

/**
 * @author Rahul
 *
 */
public class WardrobekeyUtility {

	public void save(WardrobeVO vo) {

		WardrobeKey wardrobeKey = new WardrobeKey();

		wardrobeKey.setDescription(vo.getDescription());
		wardrobeKey.setKey(vo.getKey());
		wardrobeKey.setUserCode(vo.getUserCode());
		wardrobeKey.setValue(vo.getValue());

	}

	public List<WardrobeKey> list(WardrobeVO vo) {

		String query = ("from WRDKEY where key= :key ");

		HibernateUtil hibernateUtils = new HibernateUtil();

		Session session = hibernateUtils.getSession();

		hibernateUtils.beginTransaction(session);

		List<WardrobeKey> keyList = session.createQuery(query).setParameter(0, vo.getSequenceNumber()).list();

		hibernateUtils.commitTransaction(session);
		return keyList;

	}

}
