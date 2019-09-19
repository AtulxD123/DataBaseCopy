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

import dCopy.CheckList.CheckList;
import dCopy.CheckList.test.Checktest;
import dCopy.DbNames.DataBaseInfo;
import dCopy.List.ListAdd;
import dCopy.model.Tableinfo;
import dCopy.queries.QueryUtil;


public class DataCopy {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
		
//		List <String> zeroTableList = ListAdd.tableidList(QueryUtil.zeroTables());
		List <DataBaseInfo> dbInfoList = ListAdd.allDbData(QueryUtil.fetchDataBaseNames());
//		List <Tableinfo> tableInfoList = ListAdd.getTableData(QueryUtil.fetchTableNames());
		List <Tableinfo> dependentTables = null;
		Checktest.checkList(dbInfoList);

		
		
		System.out.println(dbInfoList);
//		System.out.println(tableInfoList);
	}
}
