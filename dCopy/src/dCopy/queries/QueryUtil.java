package dCopy.queries;

public class QueryUtil {

	public static String fetchTableNames() {
		return "Select * from db_backup_tables";
	}
	public static String fetchDataBaseNames() {
		return "Select * from db_backup";
	}
	public static String zeroTables() {
		return "Select table_name from db_backup_tables where db_id=0";
	}
	public static String dbNameQuery() {
		return "Select db_name from db_backup where id =?";
	}
}
