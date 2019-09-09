package dCopy.archiver;

import java.io.IOException;

import dCopy.archiver.model.ParchModel;

public class Parchiver {
 

	public static void fullTableCopyNoDelete(ParchModel sourceDestination) {
		String sourceDataBaseName = sourceDestination.getSourceDataBaseName();
		String sourceTableName = sourceDestination.getSourceTableName();
		String destDataBaseName = sourceDestination.getDestDataBaseName();
		String destTableName = sourceDestination.getDestTableName();
		
		
		String command = "cmd /c start cmd.exe /K \"pt-archiver --source h=104.43.210.216,P=3306,u=atul,p=UP23215@^GAQ,D="+sourceDataBaseName+",t="+sourceTableName+" --dest h=192.168.1.200,P=3306,u=atul,p=Atul@2019800,D="+destDataBaseName+",t="+destTableName+" --where (1=1) --progress=100, --txn-size=1000 --no-delete --dry-run";
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(command);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void fullTableCopyYesDelete(ParchModel sourceDestination) {
		
		
		String sourceDataBaseName = sourceDestination.getSourceDataBaseName();
		String sourceTableName = sourceDestination.getSourceTableName();
		String destDataBaseName = sourceDestination.getDestDataBaseName();
		String destTableName = sourceDestination.getDestTableName();
		
		
		String command = "cmd /c start cmd.exe /K \"pt-archiver --source h=104.43.210.216,P=3306,u=atul,p=UP23215@^GAQ,D="+sourceDataBaseName+",t="+sourceTableName+" --dest h=192.168.1.200,P=3306,u=atul,p=Atul@2019800,D="+destDataBaseName+",t="+destTableName+" --where (1=1) --progress=1000, --txn-size=1000 --limit=1000 --bulk-insert --dry-run";
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(command);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
}