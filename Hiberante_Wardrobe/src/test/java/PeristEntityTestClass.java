import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dao.entity.WardrobePK;
import dao.utility.WardrobeUtility;
import dao.vo.AccessoriesVO;
import dao.vo.LowerVO;
import dao.vo.UpperVO;
import dao.vo.WardrobeVO;

public class PeristEntityTestClass {

	@Test
	public void saveLower() {

		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(9580);
		Set<ItemsVO> lowerVOs = new HashSet<ItemsVO>();

		int numberOFObject = 5;

		String defaultValue = "Test";

		while (numberOFObject != 0) {

			ItemsVO lowerVO = new ItemsVO();

			lowerVO.setBrand(defaultValue);
			lowerVO.setSize(defaultValue);
			lowerVO.setColor(defaultValue);
			lowerVO.setPrice(defaultValue);
			lowerVO.setPurchaseDate(new Date());
			lowerVO.setType(defaultValue);
			lowerVO.setSubType(defaultValue);
			lowerVO.setDescription(defaultValue);
			lowerVO.setUserCode(defaultValue);
			lowerVO.setQuality(defaultValue);
			lowerVO.setPrefrence(defaultValue);
			lowerVOs.add(lowerVO);
			numberOFObject--;
		}
		wardrobeVO.setLowerVOs(lowerVOs);
		new WardrobeUtility().save(wardrobeVO);
	}

	@Test
	public void saveUpper() {

		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(9580);
		Set<UpperVO> upperVos = new HashSet<UpperVO>();

		int numberOFObject = 5;

		String defaultValue = "Test";

		while (numberOFObject != 0) {

			UpperVO upperVo = new UpperVO();

			upperVo.setBrand(defaultValue);
			upperVo.setSize(defaultValue);
			upperVo.setColor(defaultValue);
			upperVo.setPrice(defaultValue);
			upperVo.setPurchaseDate(new Date());
			upperVo.setType(defaultValue);
			upperVo.setSubType(defaultValue);
			upperVo.setDescription(defaultValue);
			upperVo.setUserCode(defaultValue);
			upperVo.setQuality(defaultValue);
			upperVo.setPrefrence(defaultValue);
			upperVos.add(upperVo);
			numberOFObject--;
		}
		wardrobeVO.setUpperVOs(upperVos);
		new WardrobeUtility().save(wardrobeVO);
	}

	@Test
	public void saveAccesories() {

		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(9580);
		Set<AccessoriesVO> accesoriesVOs = new HashSet<AccessoriesVO>();
		int numberOFObject = 5;

		String defaultValue = "Test";

		while (numberOFObject != 0) {

			AccessoriesVO accesories = new AccessoriesVO();

			accesories.setBrand(defaultValue);
			accesories.setSize(defaultValue);
			accesories.setColor(defaultValue);
			accesories.setPrice(defaultValue);
			accesories.setPurchaseDate(new Date());
			accesories.setType(defaultValue);
			accesories.setSubType(defaultValue);
			accesories.setDescription(defaultValue);
			accesories.setUserCode(defaultValue);
			accesories.setQuality(defaultValue);
			accesories.setPrefrence(defaultValue);
			accesoriesVOs.add(accesories);
			numberOFObject--;
		}
		wardrobeVO.setAccessoriesVOs(accesoriesVOs);
		new WardrobeUtility().save(wardrobeVO);
	}

	@Test
	public void saveAll() {
		String defaultValue = "Test";
		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(9580);
		Set<ItemsVO> lowerVOs = new HashSet<ItemsVO>();
		Set<AccessoriesVO> accesoriesVOs = new HashSet<AccessoriesVO>();
		Set<UpperVO> upperVos = new HashSet<UpperVO>();
		int numberOFObject = 5;
		WardrobePK pk = new WardrobePK();

		while (numberOFObject != 0) {

			ItemsVO lowerVO = new ItemsVO();

			lowerVO.setBrand(defaultValue);
			lowerVO.setSize(defaultValue);
			lowerVO.setColor(defaultValue);
			lowerVO.setPrice(defaultValue);
			lowerVO.setPurchaseDate(new Date());
			lowerVO.setType(defaultValue);
			lowerVO.setSubType(defaultValue);
			lowerVO.setDescription(defaultValue);
			lowerVO.setUserCode(defaultValue);
			lowerVO.setQuality(defaultValue);
			lowerVO.setPrefrence(defaultValue);
			lowerVOs.add(lowerVO);

			UpperVO upperVo = new UpperVO();

			upperVo.setBrand(defaultValue);
			upperVo.setSize(defaultValue);
			upperVo.setColor(defaultValue);
			upperVo.setPrice(defaultValue);
			upperVo.setPurchaseDate(new Date());
			upperVo.setType(defaultValue);
			upperVo.setSubType(defaultValue);
			upperVo.setDescription(defaultValue);
			upperVo.setUserCode(defaultValue);
			upperVo.setQuality(defaultValue);
			upperVo.setPrefrence(defaultValue);
			upperVos.add(upperVo);

			AccessoriesVO accesories = new AccessoriesVO();

			accesories.setBrand(defaultValue);
			accesories.setSize(defaultValue);
			accesories.setColor(defaultValue);
			accesories.setPrice(defaultValue);
			accesories.setPurchaseDate(new Date());
			accesories.setType(defaultValue);
			accesories.setSubType(defaultValue);
			accesories.setDescription(defaultValue);
			accesories.setUserCode(defaultValue);
			accesories.setQuality(defaultValue);
			accesories.setPrefrence(defaultValue);
			accesoriesVOs.add(accesories);

			numberOFObject--;
		}
		wardrobeVO.setAccessoriesVOs(accesoriesVOs);
		wardrobeVO.setUpperVOs(upperVos);
		wardrobeVO.setLowerVOs(lowerVOs);
		pk = 	new WardrobeUtility().save(wardrobeVO);
		updateWardRobe(pk);
	}
	
	public void updateWardRobe(WardrobePK pk) {
		String defaultValue = "UPDT";
		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(9580);
		wardrobeVO.setSequenceNumber(pk.getSequenceNumber());
		Set<ItemsVO> lowerVOs = new HashSet<ItemsVO>();
		Set<AccessoriesVO> accesoriesVOs = new HashSet<AccessoriesVO>();
		Set<UpperVO> upperVos = new HashSet<UpperVO>();
		int numberOFObject = 5;

		while (numberOFObject != 0) {

			ItemsVO lowerVO = new ItemsVO();

			lowerVO.setBrand(defaultValue);
			lowerVO.setSize(defaultValue);
			lowerVO.setColor(defaultValue);
			lowerVO.setPrice(defaultValue);
			lowerVO.setPurchaseDate(new Date());
			lowerVO.setType(defaultValue);
			lowerVO.setSubType(defaultValue);
			lowerVO.setDescription(defaultValue);
			lowerVO.setUserCode(defaultValue);
			lowerVO.setQuality(defaultValue);
			lowerVO.setPrefrence(defaultValue);
			lowerVOs.add(lowerVO);

			UpperVO upperVo = new UpperVO();

			upperVo.setBrand(defaultValue);
			upperVo.setSize(defaultValue);
			upperVo.setColor(defaultValue);
			upperVo.setPrice(defaultValue);
			upperVo.setPurchaseDate(new Date());
			upperVo.setType(defaultValue);
			upperVo.setSubType(defaultValue);
			upperVo.setDescription(defaultValue);
			upperVo.setUserCode(defaultValue);
			upperVo.setQuality(defaultValue);
			upperVo.setPrefrence(defaultValue);
			upperVos.add(upperVo);

			AccessoriesVO accesories = new AccessoriesVO();

			accesories.setBrand(defaultValue);
			accesories.setSize(defaultValue);
			accesories.setColor(defaultValue);
			accesories.setPrice(defaultValue);
			accesories.setPurchaseDate(new Date());
			accesories.setType(defaultValue);
			accesories.setSubType(defaultValue);
			accesories.setDescription(defaultValue);
			accesories.setUserCode(defaultValue);
			accesories.setQuality(defaultValue);
			accesories.setPrefrence(defaultValue);
			accesoriesVOs.add(accesories);

			numberOFObject--;
		}
		wardrobeVO.setAccessoriesVOs(accesoriesVOs);
		wardrobeVO.setUpperVOs(upperVos);
		wardrobeVO.setLowerVOs(lowerVOs);
		pk = 	new WardrobeUtility().save(wardrobeVO);

	}
	
	@Test
	public void updateWardRobeError() {
		String defaultValue = "UPDT";
		WardrobeVO wardrobeVO = new WardrobeVO();
		wardrobeVO.setUserId(55555);
		wardrobeVO.setSequenceNumber(65555);
		Set<ItemsVO> lowerVOs = new HashSet<ItemsVO>();
		Set<AccessoriesVO> accesoriesVOs = new HashSet<AccessoriesVO>();
		Set<UpperVO> upperVos = new HashSet<UpperVO>();
	
		wardrobeVO.setAccessoriesVOs(accesoriesVOs);
		wardrobeVO.setUpperVOs(upperVos);
		wardrobeVO.setLowerVOs(lowerVOs);
		new WardrobeUtility().save(wardrobeVO);

	}
}
