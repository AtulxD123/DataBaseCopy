package dCopy.Condition;

import java.util.ArrayList;
import java.util.List;

import dCopy.DbNames.DataBaseInfo;
import dCopy.List.ListAdd;
import dCopy.queries.QueryUtil;

public class Conditions {

//	public static int levelStatus(int level) {
//		
//		
//		return level;
//	}
	public static String getDbName(int dataBaseId) {
		String dataBaseName = ListAdd.DbName(dataBaseId,QueryUtil.dbNameQuery());
		return dataBaseName;
	}
	
	public static String getDbFromList(int dataBaseId,List<DataBaseInfo> dataBaseList) {
		String dataBaseName = null;
		for(DataBaseInfo dTemp : dataBaseList) {
			if(dTemp.getDataBaseId()==dataBaseId) {
				dataBaseName = dTemp.getDataBaseName();
			}
		}
		return dataBaseName;
	}
}


