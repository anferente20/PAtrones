

public class MoveContentsManager extends Thread {
    private FileSysUtil_Rev  fsu;
    private Directory src;
    private Directory des;
    private String name;

    public MoveContentsManager(FileSysUtil_Rev des, Directory objDir_1, Directory objDir_2,String name) {
        this.fsu = des;
        this.src = objDir_1;
        this.des = objDir_2;
        this.name = name;
        start();
    }
    
    @Override
    public void run(){
    	System.out.println("->"+name);
        fsu.moveContents(src, des);
        System.out.println("<-"+name);
    }
}