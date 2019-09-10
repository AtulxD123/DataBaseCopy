package dCopy.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dCopy.Condition.Conditions;
import dCopy.DbNames.DataBaseInfo;
import dCopy.archiver.Parchiver;
import dCopy.archiver.model.ParchModel;
import dCopy.model.Tableinfo;

public class ListAdd {
	private static String url = "jdbc:mysql://192.168.1.200:3306";
	private static String username = "atul";
	private static String password = "Atul@2019800";
	private static Connection conn=null;
	private static PreparedStatement psmt=null;
	private static ResultSet rs=null;
	
//	xd1234
	
	
	public static List<DataBaseInfo> allDbData(String query) throws SQLException, ClassNotFoundException{
		List<DataBaseInfo> dbNameList = null;
		
//		DataSource ds = DBConfig.getMySqlUatDataSource();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,password);
		conn.setCatalog("pt_test");
		psmt = conn.prepareStatement(query);
		rs = psmt.executeQuery();
		dbNameList = new ArrayList<>();
		while(rs.next()) {
			DataBaseInfo dbmodel = new DataBaseInfo();
			dbmodel.setDataBaseId(rs.getInt("id"));
			dbmodel.setDataBaseName(rs.getString("db_name"));
			dbNameList.add(dbmodel);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dbNameList;
	}
	
	
	
	
	public static List<Tableinfo> getTableData(String query) throws SQLException, ClassNotFoundException{
		List<Tableinfo> table_data = new ArrayList<>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
		psmt = conn.prepareStatement(query);
		rs = psmt.executeQuery();
		while(rs.next()) {
			Tableinfo tab = new Tableinfo();
			tab.setId(rs.getInt("id"));
			tab.setPrimaryKey(rs.getString("pk_field_name"));
			tab.setDateField(rs.getString("date_field_name"));
			tab.setTableId(rs.getInt("table_id"));
			tab.setForiegnKey(rs.getString("fk_field_name"));
			tab.settablename(rs.getString("table_name"));
			tab.setDb_id(rs.getInt("db_id"));
			tab.setLevel(rs.getInt("level"));
			tab.setHas_dependent(rs.getInt("has_dependent"));
			tab.setdate_check(rs.getInt("date_check"));
			table_data.add(tab);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return table_data;
	}
	
	
	
	public static List<String> tableidList(String query) throws SQLException, ClassNotFoundException{
		List<String> tableAppendlist = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
		psmt = conn.prepareStatement(query);
		rs = psmt.executeQuery();
		tableAppendlist = new ArrayList<>();
		while(rs.next()) {
			
			tableAppendlist.add(rs.getString("table_name"));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return tableAppendlist;
	}
	
	
	public static String DbName(int dataBaseId,String query) {
		
		String dbName=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			psmt = conn.prepareStatement(query);
			psmt.setInt(1,dataBaseId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dbName = rs.getString("db_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbName;
	}

	
	public static void checkList(List<Tableinfo> tableList,List<DataBaseInfo> dataBaseList) throws SQLException, IOException {
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
					
				}
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
			 archiverInfo.setSourceDataBaseName(Conditions.getDbName(tTemp.getDb_id()));
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
//			if(tTemp.getDb_id()==0) { //present in all db;
//				if(tTemp.getLevel()==0) { //master table;
//					if(tTemp.getHas_dependent()==0) { //free table;
//						if(tTemp.getdate_check()==0) { //only copy;
//							for(DataBaseInfo dTemp : dataBaseList) {
//								Parchiver.fullTableCopyNoDelete(tTemp.gettablename(), dTemp.getDataBaseName(), tTemp.gettablename(), "pt-test");
//							}
//						}
//						else {
//							for(DataBaseInfo dTemp : dataBaseList) {
//								Parchiver.fullTableCopyYesDelete(tTemp.gettablename(), dTemp.getDataBaseName(), tTemp.gettablename(), "pt-test");
//							}
//						}
//					}
//				}
//			}
		
		
		
		}
		}
}
