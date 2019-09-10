package dCopy.archiver;

import java.io.IOException;

import dCopy.archiver.model.ParchModel;

public class Parchiver {
 

	public static void fullTableCopyNoDelete(ParchModel sourceDestination) throws InterruptedException {
		String sourceDataBaseName = sourceDestination.getSourceDataBaseName();
		String sourceTableName = sourceDestination.getSourceTableName();
		String destDataBaseName = sourceDestination.getDestDataBaseName();
		String destTableName = sourceDestination.getDestTableName();
		
		String[] command = {"cmd", "/c", "start cmd", "/K","pt-archiver --source h=104.43.210.216,P=3306,u=atul,p=UP23215@^GAQ,D="+sourceDataBaseName+",t="+sourceTableName+" --dest h=192.168.1.200,P=3306,u=atul,p=UAV432GvB3,D="+destDataBaseName+",t="+destTableName+" --where (1=1) --progress=100, --txn-size=1000 --no-delete"};

	
		ProcessBuilder processBuild = new ProcessBuilder();
		processBuild.command(command);
		try {
			
			Process process = processBuild.start();
			}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void fullTableCopyYesDelete(ParchModel sourceDestination) throws InterruptedException {
		
		
		String sourceDataBaseName = sourceDestination.getSourceDataBaseName();
		String sourceTableName = sourceDestination.getSourceTableName();
		String destDataBaseName = sourceDestination.getDestDataBaseName();
		String destTableName = sourceDestination.getDestTableName();
		
		
		String[] command = {"cmd", "/c", "start cmd", "/K","pt-archiver --source h=104.43.210.216,P=3306,u=atul,p=UP23215@^GAQ,D="+sourceDataBaseName+",t="+sourceTableName+" --dest h=192.168.1.200,P=3306,u=atul,p=UAV432GvB3,D="+destDataBaseName+",t="+destTableName+" --where (1=1) --progress=1000, --txn-size=1000 --limit=1000 --bulk-insert --dry-run"};
		ProcessBuilder processBuild = new ProcessBuilder();
		processBuild.command(command);
		try {
			
			Process process = processBuild.start();
			}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
