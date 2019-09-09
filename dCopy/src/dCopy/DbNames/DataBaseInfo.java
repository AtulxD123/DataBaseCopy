package dCopy.DbNames;

public class DataBaseInfo {

	
	private int dataBaseId;
	private String dataBaseName;
	public int getDataBaseId() {
		return dataBaseId;
	}
	public void setDataBaseId(int dataBaseId) {
		this.dataBaseId = dataBaseId;
	}
	public String getDataBaseName() {
		return dataBaseName;
	}
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	@Override
	public String toString() {
		return "DataBaseInfo [dataBaseId=" + dataBaseId + ", dataBaseName=" + dataBaseName + "]";
	}

	
}
