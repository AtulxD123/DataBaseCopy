package dCopy.Condition;

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
}
