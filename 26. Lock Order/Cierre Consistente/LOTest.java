
public class LOTest extends Thread{

	public static void main(String[] args) {
		Directory src = new Directory("src");
		Directory des = new Directory("des");
		FileSysUtil_Rev flur = new FileSysUtil_Rev();
		
		
		new MoveContentsManager(flur, src, des, "LOT1");
		new MoveContentsManager(flur, des, src, "LOT2");
	}
	
	

}
