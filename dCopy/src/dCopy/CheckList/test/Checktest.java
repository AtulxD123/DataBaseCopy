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
		ParchModel archiverInfo = new ParchModel();
		for(Tableinfo tTemp : tableList) {	
		 if(tTemp.getDb_id()==0) {
			switch (tTemp.getLevel()) {
			case 0:
				if(tTemp.getHas_dependent()==0) {
					if(tTemp.getdate_check()==0) {
						for(DataBaseInfo dTemp : dataBaseList) {
							
							archiverInfo.setSourceTableName(tTemp.gettablename());
							archiverInfo.setSourceDataBaseName(dTemp.getDataBaseName());
							archiverInfo.setDestTableName(tTemp.gettablename());
							archiverInfo.setDestDataBaseName(dTemp.getDataBaseName());
							
							new Thread(new Runnable() {
								@Override
								public void run() {
									try {
										Parchiver.fullTableCopyNoDelete(archiverInfo);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}).start();
						}
				}
					else { 
						for(DataBaseInfo dTemp : dataBaseList) {
							
							archiverInfo.setSourceTableName(tTemp.gettablename());
							archiverInfo.setSourceDataBaseName(dTemp.getDataBaseName());
							archiverInfo.setDestTableName(tTemp.gettablename());
							archiverInfo.setDestDataBaseName(dTemp.getDataBaseName());
							
							new Thread(new Runnable() {
								@Override
								public void run() {
									try {
										Parchiver.fullTableCopyYesDelete(archiverInfo);
									}
						           catch (InterruptedException e) {
									e.printStackTrace();
								}
						}
							}).start();
					}
				}	
            }
				else {
					List<Tableinfo> Master = new ArrayList<>();
					Master = ListAdd.getTableData(QueryUtil.masterTableQuery());
				}
				break;
			case 1: 
				if(tTemp.getHas_dependent()==0) {
					if(tTemp.getdate_check()==0) {
						continue;
					}
					else {
						continue;
					}
				} 
				else {
					continue;
				}
   }
			break;
}
		 else {
//			 archiverInfo.setSourceDataBaseName(Conditions.getDbName(tTemp.getDb_id()));
			 archiverInfo.setSourceDataBaseName(Conditions.getDbFromList(tTemp.getDb_id(), dataBaseList));
			 switch(tTemp.getLevel()) {
			 case 0:
				 if(tTemp.getHas_dependent()==0) {
					 if(tTemp.getdate_check()==0) {
						 archiverInfo.setSourceTableName(tTemp.gettablename());
						 archiverInfo.setDestTableName(tTemp.gettablename());
						 archiverInfo.setDestDataBaseName(Conditions.getDbName(tTemp.getDb_id()));
						 new Thread (new Runnable() {
							 @Override
							 public void run() {
								 try {
									Parchiver.fullTableCopyNoDelete(archiverInfo);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							 }
						 }).start();
					 }
				 }
				 else {
					 continue;
				 }
			 }
		 }		
		
		}
		}
}

