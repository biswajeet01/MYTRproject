package mytr.cucumber.ex.helper;

import org.testng.annotations.DataProvider;

import com.framework.config.PropertiesRepository;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.constants.MYTRConstants;

public class Data {
	
	@DataProvider(name = MYTRConstants.dataProviderMethod)
	public Object[][] getTestDataFromExcel() {
		String filePath = System.getProperty("user.dir") + PropertiesRepository.getString("feature.excel.file");
		String[][] featureList = ExcelUtils.getFeatureFiles(filePath, MYTRConstants.featureSheetName);
		
		return featureList;
	}

}
