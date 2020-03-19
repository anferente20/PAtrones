
public class LoggerManager extends Thread{

	private FileLogger fl;
	private String name;
	
	LoggerManager(String nm){
		name = nm;
		fl  = FileLogger.getFileLogger();
		start();
	}
	
	public void run() {
		System.out.println("-> "+name);
		fl.log("A Messagger to Log from "+name);
		System.out.println("<- "+name);
		System.out.println(name+" has written on the file");
	}
}
