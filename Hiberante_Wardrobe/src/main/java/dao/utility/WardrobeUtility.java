/**
 * 
 */
package dao.utility;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import utlis.KeyGenerator;
import utlis.OneTimeKey;
import utlis.connection.HibernateUtil;
import vo.WardrobeVO;
import dao.entity.Items;
import dao.entity.Wardrobe;
import dao.entity.WardrobePK;

/**
 * @author Rahul
 *
 */
public class WardrobeUtility {

	public static Session sessionTemp;

	/**
	 * save -
	 * 
	 * @param wardrobeVO
	 *            -
	 */
	public WardrobePK createWardRobe(WardrobeVO wardrobeVO) {

		Wardrobe wardrobe = new Wardrobe();
		WardrobePK pk = new WardrobePK();

		pk.setSequenceNumber(new KeyGenerator()
				.getKey(OneTimeKey.PRIMARY_KEY_DIGIT));
		pk.setUserName(wardrobeVO.getUserName());
		pk.setName(wardrobeVO.getName());
		wardrobe.setWardrobePK(pk);

		Set<Items> items = null;
		if (wardrobeVO.getItemsVo() != null) {
			items = new ItemUtility().getEntityValueObject(
					wardrobeVO.getItemsVo(), pk);
			wardrobe.setItems(items);
		}

		HibernateUtil hiberanteUtil = new HibernateUtil();
		try {

			Session session = hiberanteUtil.getSession();
			hiberanteUtil.beginTransaction(session);
			pk = (WardrobePK) hiberanteUtil.saveEntity(session, wardrobe);
			hiberanteUtil.commitTransaction(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return pk;
	}

	public void updateWardRobe(WardrobeVO wardrobeVO) {

		WardrobePK pk = new WardrobePK();
		try {
			pk.setSequenceNumber(wardrobeVO.getSequenceNumber());
			pk.setUserName(wardrobeVO.getUserName());
			pk.setName(wardrobeVO.getName());

			Wardrobe wardRobe = findEntity(pk);

			Set<Items> items = null;
			if (wardrobeVO.getItemsVo() != null) {
				items = new ItemUtility().getEntityValueObject(
						wardrobeVO.getItemsVo(), wardRobe.getWardrobePK());
			}

			HibernateUtil hiberanteUtil = new HibernateUtil();
			Session session = hiberanteUtil.getSession();
			hiberanteUtil.beginTransaction(session);
			if (items != null) {
				for (Items item : items) {
					hiberanteUtil.saveEntity(session, item);
				}
			}
			hiberanteUtil.commitTransaction(session);
		} catch (HibernateException e) {
			System.out.println("Exception occured. " + e.getMessage());
		}
	}

	public Wardrobe listAllItem(WardrobePK pk) {

		HibernateUtil hibernateUtils = new HibernateUtil();

		sessionTemp = hibernateUtils.getSession();

		hibernateUtils.beginTransaction(sessionTemp);

		Wardrobe wardrobe = (Wardrobe) sessionTemp.get(Wardrobe.class, pk);

		return wardrobe;
	}

	public void commitTransaction(Session session) {

		if (session == null) {

			session = sessionTemp;
		}

		session.getTransaction().commit();

	}

	public List<Wardrobe> listWardrobeForUser(String userName) {

		String query = ("from Wardrobe where USRNAM = :user ");
		// here persistent class name is Emp

		HibernateUtil hibernateUtils = new HibernateUtil();

		Session session = hibernateUtils.getSession();

		hibernateUtils.beginTransaction(session);

		List<Wardrobe> wardrobe = session.createQuery(query)
				.setParameter("user", userName).list();

		hibernateUtils.commitTransaction(session);

		return wardrobe;
	}

	public Wardrobe findEntity(WardrobePK pk) {

		HibernateUtil hiberanteUtil = new HibernateUtil();

		Session session = hiberanteUtil.getSession();
		hiberanteUtil.beginTransaction(session);
		Wardrobe entity = (Wardrobe) session.get(Wardrobe.class, pk);

		if (entity == null) {
			throw new HibernateException("Wardrobe not found");
		}
		hiberanteUtil.commitTransaction(session);
		return entity;
	}

}
