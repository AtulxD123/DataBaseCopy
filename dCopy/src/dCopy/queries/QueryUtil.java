package dCopy.queries;

public class QueryUtil {

	public static String fetchTableNames() {
		return "Select * from db_backup_tables";
	}
	public static String fetchTablesByDB(int dataBaseId) {
		return String.format("Select * from db_backup_tables where db_id=0 or db_id=%d",dataBaseId);
	}
	public static String fetchDataBaseNames() {
		return "Select * from db_backup";
	}
	public static String zeroTables() {
		return "Select * from db_backup_tables where db_id=0";
	}
	public static String dbNameQuery() {
		return "Select db_name from db_backup where id =?";
	}
	public static String masterTableQuery() {
		return "Select * from db_backup_tables where level=0 and has_dependent=1";
	}
	public static String fetchFreeTables(){
		return "Select * from db_backup_tables where level=0 and has_dependent=0 and date_check=0 and db_id=0";
			}
	public static String fetchFreeTablesSpecifiedByDb(){
		return "Select * from db_backup_tables where level=0 and has_dependent=0 and date_check=0 and not db_id=0";
	}
	public static String fetchSecondaryMasterTable(){
		return "Select * from db_backup_tables where level=1 and has_dependent=1";
	}
}
