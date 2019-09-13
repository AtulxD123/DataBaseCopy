package dCopy.CheckList;

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

public class CheckList {

	public static void checkList(List<Tableinfo> tableList,List<DataBaseInfo> dataBaseList) throws SQLException, IOException, ClassNotFoundException, InterruptedException {
		ParchModel archiverInfo = new ParchModel();
		for(Tableinfo tTemp : tableList) {	
			switch(tTemp.getLevel()) {
			case 0 :
				if(tTemp.getHas_dependent()==0) {
					if(tTemp.getdate_check()==0) {
						if(tTemp.getDb_id()==0) {
							for(DataBaseInfo dTemp : dataBaseList) {
								archiverInfo.setSourceDataBaseName(dTemp.getDataBaseName());
								archiverInfo.setDestDataBaseName(dTemp.getDataBaseName());
								archiverInfo.setSourceTableName(tTemp.gettablename());
								archiverInfo.setDestTableName(tTemp.gettablename());
								
								new Thread(new Runnable() {
									@Override
									public void run() {
												try {
														Parchiver.fullTableCopyNoDelete(archiverInfo);
													} catch (Exception e) {
														e.printStackTrace();
													}
								
										}
					    }).start();
			}
		}
						else {
							 archiverInfo.setSourceDataBaseName(Conditions.getDbFromList(tTemp.getDb_id(), dataBaseList));
							 archiverInfo.setSourceTableName(tTemp.gettablename());
							 archiverInfo.setDestDataBaseName(Conditions.getDbFromList(tTemp.getDb_id(), dataBaseList));
							 archiverInfo.setDestTableName(tTemp.gettablename());
							 new Thread(new Runnable() {
								 @Override
								 public void run() {
									 try {
										 	Parchiver.fullTableCopyNoDelete(archiverInfo);
									 } catch(Exception e) {
										 e.printStackTrace();
									 }
								 }
							 }).start();
						}
						
					}
					else {
						
					}
				}
				else {
					List<Tableinfo> masterTableList = new ArrayList<>();
					masterTableList = ListAdd.getTableData(QueryUtil.masterTableQuery());
				}
				break;
			case 1 :
				break;
			case 2 : 
				break;
			}
		}
}
}