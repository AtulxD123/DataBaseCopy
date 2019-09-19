package dCopy.CheckList.test;

import java.beans.DefaultPersistenceDelegate;
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

	
	
	public static void checkList(List<DataBaseInfo> dataBaseList) throws SQLException, IOException, ClassNotFoundException {
		for(DataBaseInfo tempDBData : dataBaseList){
			new Thread(new Runnable(){
				@Override
				public void run(){
					List<Tableinfo> tempTableList = new ArrayList<>();
					List<Tableinfo> dependentOnMasterTableList = new ArrayList<>();
					List<Tableinfo> freeTableList = new ArrayList<>();
					List<Tableinfo> masterTableList	= new ArrayList<>();
					try {
						tempTableList = ListAdd.getTableData(QueryUtil.fetchTablesByDB(tempDBData.getDataBaseId()));
						System.out.println(tempTableList);
						for(Tableinfo tTemp : tempTableList){
							if(tTemp.getLevel()==0 && tTemp.getHas_dependent()==1){
								masterTableList.add(tTemp);
								System.out.println("Master table data of "+tTemp.getId()+" is :"+tTemp);
								tTemp.setsubTable(ListAdd.fetchSubDependentTables(tempTableList,tTemp.getLevel(),tTemp.getId()));
//								dependentOnMasterTableList.addAll(tTemp.getsubTable());
								ListAdd.printTree(tTemp);
							}
						freeTableList.add(tTemp);
						}
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println("Master table List : " +masterTableList);
//					for(Tableinfo xyz : masterTableList){
//					System.out.println("master table  sublist: " + xyz.getsubTable());
//					for(Tableinfo abc : xyz.getsubTable()){
//						System.out.println("secondary sublist for"+xyz.getId()+":"+abc.getsubTable());
//						}
//					}
					
				}
			}).start();
		
		
		
		
		
		}
	}

}

