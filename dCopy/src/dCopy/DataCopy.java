package dCopy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dCopy.DbNames.DataBaseInfo;
import dCopy.List.ListAdd;
import dCopy.model.Tableinfo;
import dCopy.queries.QueryUtil;


public class DataCopy {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
//		List <String> zeroTableList = ListAdd.tableidList(QueryUtil.zeroTables());
		List <DataBaseInfo> dbInfoList = ListAdd.allDbData(QueryUtil.fetchDataBaseNames());
		List <Tableinfo> tableInfoList = ListAdd.getTableData(QueryUtil.fetchTableNames());
//		Iterator<Tableinfo> i1 = tableInfoList.iterator();
//		System.out.println(zeroTableList);
		ListAdd.checkList(tableInfoList,dbInfoList);
//		System.out.println(tableName);
//		for (String k : zero_table) {
//			for(String m : db_names) {
//				singleTableCopy(k,m);
//			}
//			
//		}
//		System.out.println(dbInfoList);
//		System.out.println(tableInfoList);
	}
}
