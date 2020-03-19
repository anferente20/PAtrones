
public class LoggerManager extends Thread {

	private FileLogger fl;
	private String name;
	
	LoggerManager(String nm ){
		fl = FileLogger.getFileLogger();
		name = nm;
		start();
	}
	
	public void run() {
		System.out.println("->"+name);
		fl.log("A message to log from "+name);
		System.out.println(name+" has written a new message.");
		System.out.println(name+"<-");
	}
	
}
