/**
 * 
 */
package client;

import java.util.List;
import java.util.Scanner;

import dao.entity.WardrobeKey;
import dao.entityUtility.WardrobekeyUtility;

/**
 * @author Rahul
 *
 */
public class OnetimeClient {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		System.out
				.println("----------WELOCME TO ONE TIME MANAGER ----------------------");

		boolean userChoiceIncorrect = true;

		while (userChoiceIncorrect) {
			System.out.println(" Press 1 to Save Item in ONE TIME ");
			System.out.println(" Press 2 to retrieve Item from ONE TIME");
			System.out.println(" Press 3 to update item in ONE TIME");
			int userOption = scanner.nextInt();
			switch (userOption) {

			case 1:
				userChoiceIncorrect = false;
				boolean isContinue = true;
				while (isContinue) {
					saveItem();
					System.out.println("Want to continue , press Y");
					if (!scanner.next().equalsIgnoreCase("Y")) {
						isContinue = false;
					}
				}
				System.out.println("Inderted !!");
				break;

			case 2:
				userChoiceIncorrect = false;
				 retriveItem();
				break;
			case 3:
				userChoiceIncorrect = false;
				break;
			default:
				System.err.println("Choose from above item list");
				userChoiceIncorrect = true;
			}
		}

		/*
		 * try { HibernateUtil.isConnectionExists(); } catch (HibernateException
		 * he) { System.err.println(he.getMessage()); System.err .println(
		 * "--------- Not ABLE TO MAKE  CONNECTION TO DATABASE ----------------------"
		 * ); }
		 */
	}

	private static void saveItem() {

		OnetimeVO onetimeVO = new OnetimeVO();

		System.out.println("Enter Enity Code -");
		onetimeVO.setEntityCode(scanner.next());

		System.out.println("Enter Sub Entity Code : -");
		onetimeVO.setSubEntityCode(scanner.next());

		System.out.println("Enter Field Code : -");
		onetimeVO.setFieldCode(scanner.next());

		System.out.println("Enter Field Value : -");
		onetimeVO.setFieldValue(scanner.next());

		System.out.println("Enter Field Description : -");
		onetimeVO.setFieldDescription(scanner.next());

		new WardrobekeyUtility().perists(onetimeVO);
	}
	
	static List<WardrobeKey> retriveItem(){
		
		List<WardrobeKey> onetime = null;
		
		OnetimeVO onetimeVO = new OnetimeVO();
		
		System.out.println("Enter Enity Code -");
		onetimeVO.setEntityCode(scanner.next());

		System.out.println("Enter Sub Entity Code : -");
		onetimeVO.setSubEntityCode(scanner.next());

		
		onetime = new WardrobekeyUtility().list(onetimeVO);
		
		for(WardrobeKey on : onetime){
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("Brand Name Code :- " + on.getFieldValue() + " \n Brand Description :- " + on.getFieldDescription());
			System.out.println("-------------------------------------------------------------------------------------------");
		}
		return onetime;
		
	}
}
