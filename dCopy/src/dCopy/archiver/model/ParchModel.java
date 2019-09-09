package dCopy.archiver.model;

public class ParchModel {

	
	private String sourceTableName;
	private String sourceDataBaseName;
	private String destTableName;
	private String destDataBaseName;
	
	
	
	public String getSourceTableName() {
		return sourceTableName;
	}



	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}



	public String getSourceDataBaseName() {
		return sourceDataBaseName;
	}



	public void setSourceDataBaseName(String sourceDataBaseName) {
		this.sourceDataBaseName = sourceDataBaseName;
	}



	public String getDestTableName() {
		return destTableName;
	}



	public void setDestTableName(String destTableName) {
		this.destTableName = destTableName;
	}



	public String getDestDataBaseName() {
		return destDataBaseName;
	}



	public void setDestDataBaseName(String destDataBaseName) {
		this.destDataBaseName = destDataBaseName;
	}
}
