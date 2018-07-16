/**
 * 
 */
package dao.utility;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utlis.KeyGenerator;
import utlis.OneTimeKey;
import utlis.connection.HibernateUtil;
import vo.ItemsVO;
import dao.entity.Items;
import dao.entity.ItemsPK;
import dao.entity.Wardrobe;
import dao.entity.WardrobePK;

/**
 * @author Rahul
 *
 */
public class ItemUtility {

	public static Session sessionTemp;

	
	public Set<Items> getEntityValueObject(Set<ItemsVO> itemVOs, WardrobePK pk) {

		Set<Items> itemVOSet = new HashSet<Items>();

		for (ItemsVO itemVO : itemVOs) {

			Items items = new Items();
			ItemsPK itemsPk = new ItemsPK();
			itemsPk.setSequenceNumber(new KeyGenerator()
					.getKey(OneTimeKey.PRIMARY_KEY_DIGIT));
			itemsPk.setWardRobeName(pk.getName());
			
			items.setPrimaryKey(itemsPk);
			items.setBrand(itemVO.getBrand());
			items.setColor(itemVO.getColor());
			items.setName(itemVO.getName());
			items.setPrice(itemVO.getPrice());
			items.setPurchaseDate(itemVO.getPurchaseDate());
			items.setRating(itemVO.getRating());
			items.setSize(itemVO.getSize());
			items.setSubType(itemVO.getSubType());
			items.setType(itemVO.getType());

			itemVOSet.add(items);
		}
		return itemVOSet;

	}
	
	public Items listItem(ItemsPK pk) {

		HibernateUtil hibernateUtils = new HibernateUtil();

		sessionTemp = hibernateUtils.getSession();

		hibernateUtils.beginTransaction(sessionTemp);

		Items items = (Items) sessionTemp.get(Items.class, pk);

		return items;
	}
	
	public void removeItem(ItemsPK pk) {

		HibernateUtil hibernateUtils = new HibernateUtil();

		sessionTemp = hibernateUtils.getSession();

		hibernateUtils.beginTransaction(sessionTemp);

		Items items = (Items) sessionTemp.get(Items.class, pk);
		
		sessionTemp.remove(items);
		
		sessionTemp.getTransaction().commit();
	}
	
	public void commitTransaction(Session session) {

		if (session == null) {

			session = sessionTemp;
		}

		session.getTransaction().commit();

	}
}
