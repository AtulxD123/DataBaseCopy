package dCopy.Condition;

import java.util.ArrayList;
import java.util.List;

import dCopy.DbNames.DataBaseInfo;
import dCopy.List.ListAdd;
import dCopy.model.Tableinfo;
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
	
	public static String fetchTableName(List<Tableinfo> tableInfoList,int tableId){
		String masterTableName = null;
		for(Tableinfo tTemp : tableInfoList){
			if(tTemp.getId()==tableId){
				masterTableName = tTemp.gettablename();
			}
		}
		return masterTableName;
	}


	public static String fetchTablePrimaryKey(List<Tableinfo> tableInfoList,int tableId){
		String PrimaryKeyField = null;
		for(Tableinfo tTemp : tableInfoList){
			if(tTemp.getId()==tableId){
				PrimaryKeyField = tTemp.getPrimaryKey();
			}
		}
		return PrimaryKeyField;
	}
	
	public static String dbSpecificTableList(int dbId){
		return String.format("tableListDbIs%d", dbId);
	}
}


