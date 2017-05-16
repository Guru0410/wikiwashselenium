package utilities;

public class Utility 
{


	public static boolean isExecutable(String test_name, ExcelReader excel)
	{

		String sheetName="testcases";
		for(int rowNum=2;rowNum<=excel.getRowCount(sheetName);rowNum++){

			if(excel.getCellData(sheetName, "test_name", rowNum).equals(test_name)){

				if(excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y"))
					return true;
				else
					return false;

			}
		}

		return false;

	}


	//TestNG Parameterization
	public static Object[][] getData(String sheetName, ExcelReader excel)
	{
		// return test data;
		// read test data from xls

		int rows=excel.getRowCount(sheetName)-1;
		if(rows <=0){
			Object[][] testData =new Object[1][0];
			return testData;

		}
		rows = excel.getRowCount(sheetName);  // 3
		int cols = excel.getColumnCount(sheetName);
		Object data[][] = new Object[rows-1][cols];

		for( int rowNum = 2 ; rowNum <=rows ; rowNum++){

			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;


	}




}
