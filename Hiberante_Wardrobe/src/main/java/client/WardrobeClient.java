/**
 * 
 */
package client;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import utlis.OneTimeKey;
import utlis.connection.HibernateUtil;
import vo.ItemsVO;
import vo.WardrobeVO;
import dao.entity.Items;
import dao.entity.ItemsPK;
import dao.entity.Wardrobe;
import dao.entity.WardrobePK;
import dao.utility.ItemUtility;
import dao.utility.WardrobeUtility;

/**
 * @author Rahul
 *
 */
public class WardrobeClient {

	private static Scanner scanner = new Scanner(System.in);

	private static int userCurrentWardRobeId;

	private static String valueSlash = "   ||    ";

	private static String userName = "ADMIN";

	private static boolean userChoiceIncorrect = true;

	private static boolean userSaveChoiceIncorrect = true;

	public static void main(String args[]) {

		System.out.println(OneTimeKey.DOTTED_LINE);
		System.out.println(OneTimeKey.WARDROBE_MANAGER_GREETING);
		WardrobeUtility wardrobeUtility = new WardrobeUtility();

		System.out.println(" ENTER USER CODE ");
		userName = scanner.next();
		List<Wardrobe> userWardRobeList = wardrobeUtility
				.listWardrobeForUser(userName);
		int count = 1;
		for (Wardrobe wardrobe : userWardRobeList) {
			System.out.println("-----------Wardrobe :- " + count);
			System.out.println("WardRobe Name  :- "
					+ wardrobe.getWardrobePK().getName());
			System.out.println("User Name :- "
					+ wardrobe.getWardrobePK().getSequenceNumber());
			System.out.println("User Name :- "
					+ wardrobe.getWardrobePK().getUserName());
			System.out.println("------------------------------");
			count++;
		}

		if (userWardRobeList != null && userWardRobeList.size() > 0) {

			System.out.println("---------------------------------------------");
			System.out.println("Press 1 to List Item");
			if (scanner.next().equalsIgnoreCase("1")) {
				listItem();
			}
		} else {
			createWardRobe();
		}
		
		HibernateUtil.closeConnection();

	}

	private static void createWardRobe() {
		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserName(userName);
		System.out.println("Enter Wardrobe Name : -");
		wardrobeVO.setName(scanner.next());
		Set<ItemsVO> itemsVO = new HashSet<ItemsVO>();
		boolean repeat = false;
		while (!repeat) {

			ItemsVO itemsVo = new ItemsVO();

			System.out.println("Enter  Name : -");
			itemsVo.setName(scanner.next());

			System.out.println("Enter  Rating : -");
			itemsVo.setRating(scanner.next());

			System.out.println("Enter  brand : -");
			itemsVo.setBrand(scanner.next());

			System.out.println("Enter Size : -");
			itemsVo.setSize(scanner.next());

			System.out.println("Enter Color : -");
			itemsVo.setColor(scanner.next());

			System.out.println("Enter Price : -");
			itemsVo.setPrice(scanner.next());

			itemsVo.setPurchaseDate(new Date());

			System.out.println("Enter Type : -");
			itemsVo.setType(scanner.next());

			System.out.println("Enter Sub Type : -");
			itemsVo.setSubType(scanner.next());

			System.out
					.println("Press Y to Add more , any other key to continue");

			if (!scanner.next().equalsIgnoreCase("Y")) {

				repeat = true;
			}
			itemsVO.add(itemsVo);
		}
		wardrobeVO.setItemsVo(itemsVO);
		WardrobePK pk = new WardrobeUtility().createWardRobe(wardrobeVO);
		System.out.println("-----------Wardrobe Created-------------------");
		System.out.println("WardRobe Name :- " + pk.getName());
		System.out.println("User Name :- " + pk.getUserName());
		System.out.println("Wardrobe Code :- " + pk.getSequenceNumber());
		System.out
				.println("-----------Wardrobe Creation Completed--------------------");
	}

	private static void listItem() {

		WardrobeVO wardrobeVO = new WardrobeVO();

		WardrobePK pk = new WardrobePK();
		System.out.println("WardRobe Name :- ");
		pk.setName(scanner.next());
		System.out.println("WardRobe Sequence Code :- ");
		pk.setSequenceNumber(scanner.nextInt());
		pk.setUserName(userName);

		WardrobeUtility wardrobeUtility = new WardrobeUtility();

		Wardrobe wardrobe = wardrobeUtility.listAllItem(pk);

		System.out.println("-----------Item List-------------------");
		System.out.println("WardRobe Name :- "
				+ wardrobe.getWardrobePK().getName());
		System.out.println("Wardrobe Code :- "
				+ wardrobe.getWardrobePK().getSequenceNumber());
		System.out
				.println("Total Item  Count :- " + wardrobe.getItems().size());

		if (wardrobe.getItems() != null) {
			System.out.println("Total Item  Count :- "
					+ wardrobe.getItems().size());
		}
		System.out
				.println("------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(dispalyHeader());
		System.out
				.println("------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Items items : wardrobe.getItems()) {
			System.out.println(dispalyItemValue(items));
		}
		System.out
				.println("------------------------------------------------------------------------------------------------------------------------------------------------");
		wardrobeUtility.commitTransaction(null);
		System.out.println("Press 1 to Modify Item");
		System.out.println("Press 2 to Delete Item");
		
			String input = scanner.next();
		if (input.equals("1")) {
			updateItem(wardrobe.getWardrobePK().getName());
		} else if(input.equals("2")){
			System.out.println("Press 2 to Delete Item");
			deleteItem(wardrobe.getWardrobePK().getName());
		}
	}

	private static void updateItem(String wardRobeName) {

		ItemsPK itemsPK = new ItemsPK();
		System.out.println("Enter Item Code");
		itemsPK.setSequenceNumber(scanner.nextInt());
		itemsPK.setWardRobeName(wardRobeName);

		ItemUtility itemUtility = new ItemUtility();

		Items items = itemUtility.listItem(itemsPK);

		System.out.println("New  Name :- ");
		items.setName(scanner.next());
		System.out.println("New Rating :- ");
		items.setRating(scanner.next());

		itemUtility.commitTransaction(null);
		System.out.println(dispalyHeader());
		System.out.println(dispalyItemValue(items));
	}

	private static void deleteItem(String wardRobeName) {
		ItemsPK itemsPK = new ItemsPK();
		System.out.println("Enter Item Code");
		itemsPK.setSequenceNumber(scanner.nextInt());
		itemsPK.setWardRobeName(wardRobeName);

		ItemUtility itemUtility = new ItemUtility();

		itemUtility.removeItem(itemsPK);
	}

	private static String dispalyItemValue(Items items) {

		StringBuilder sb = new StringBuilder();
		sb.append(items.getPrimaryKey().getSequenceNumber()).append(valueSlash)
				.append(items.getBrand()).append(valueSlash)
				.append(items.getColor()).append(valueSlash)
				.append(items.getName()).append(valueSlash)
				.append(items.getPrice()).append(valueSlash)
				.append(items.getRating()).append(valueSlash)
				.append(items.getSize()).append(valueSlash)
				.append(items.getType()).append(valueSlash)
				.append(items.getSubType()).append(valueSlash);
		return sb.toString();
	}

	private static String dispalyHeader() {

		StringBuilder sb = new StringBuilder();
		sb.append("Code").append(valueSlash).append("Brand").append(valueSlash)
				.append("Colour").append(valueSlash).append("Name")
				.append(valueSlash).append("Price").append(valueSlash)
				.append("Raing").append(valueSlash).append("Size")
				.append(valueSlash).append("Type").append(valueSlash)
				.append("SubType").append(valueSlash);
		return sb.toString();
	}

}
