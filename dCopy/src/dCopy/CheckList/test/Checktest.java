package dCopy.CheckList.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dCopy.Condition.Conditions;
import dCopy.DbNames.DataBaseInfo;
import dCopy.List.ListAdd;
import dCopy.archiver.Parchiver;
import dCopy.archiver.model.ParchModel;
import dCopy.model.Tableinfo;
import dCopy.queries.QueryUtil;

public class Checktest {

	

	public static void checkList(List<Tableinfo> tableList,List<DataBaseInfo> dataBaseList) throws SQLException, IOException, ClassNotFoundException {
		List<Tableinfo> freeTableList = ListAdd.getTableData(QueryUtil.fetchFreeTables());
		List<Tableinfo> masterTablelist = ListAdd.getTableData(QueryUtil.masterTableQuery());
		ParchModel archiverInfo = new ParchModel();
		
		for(Tableinfo tab : freeTableList){
			for(DataBaseInfo dtab: dataBaseList){
				archiverInfo.setSourceDataBaseName(dtab.getDataBaseName());
				archiverInfo.setSourceTableName(tab.gettablename());
				archiverInfo.setDestDataBaseName(dtab.getDataBaseName());
				archiverInfo.setDestTableName(tab.gettablename());
			}
		}
	
	
	}
}

