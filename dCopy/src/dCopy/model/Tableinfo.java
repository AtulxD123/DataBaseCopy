package dCopy.model;

import java.util.List;

public class Tableinfo {

	private int id;
	private String tablename;
	private int db_id;
	private String primaryKey;
	private String dateField;
	private int tableId;
	private String foriegnKey;
	
	private int level;
	private int has_dependent;
	private int date_check;
	private List<Tableinfo> subTable;
	
	public List<Tableinfo> getsubTable(){
		return subTable;
	}
	public void setsubTable(List<Tableinfo> subTable){
		this.subTable = subTable;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getDateField() {
		return dateField;
	}
	public void setDateField(String dateField) {
		this.dateField = dateField;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getForiegnKey() {
		return foriegnKey;
	}
	public void setForiegnKey(String foriegnKey) {
		this.foriegnKey = foriegnKey;
	}
	
	public int getdate_check() {
		return date_check;
	}
	public void setdate_check(int date_check) {
		this.date_check = date_check;
	}
	public String gettablename() {
		return tablename;
	}
	public void settablename(String tablename) {
		this.tablename = tablename;
	}
	public int getDb_id() {
		return db_id;
	}
	public void setDb_id(int db_id) {
		this.db_id = db_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHas_dependent() {
		return has_dependent;
	}
	public void setHas_dependent(int has_dependent) {
		this.has_dependent = has_dependent;
	}
	
	@Override
	public String toString() {
		return "Tableinfo [id=" + id + ", tablename=" + tablename + ", db_id=" + db_id + ", primaryKey="
				+ primaryKey + ", dateField=" + dateField + ", tableId=" + tableId + ", foriegnKey=" + foriegnKey
				+ ", level=" + level + ", has_dependent=" + has_dependent + ", date_check=" + date_check + "]";
	}

}
