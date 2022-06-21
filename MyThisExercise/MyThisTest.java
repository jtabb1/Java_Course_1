
/**
 * Write a description of MyThisTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyThisTest {
    private int a;
    
    public MyThisTest(){
        this(42);
    }
    
    public MyThisTest(int a){
        this.a = a;
    }
    
    public void doThingsWithThis(){
        int a = 1;
        System.out.println(a);        
        System.out.println(this.a);
        System.out.println(this);
    }
    
    @Override
    public String toString(){
        return "MyThisTest a= "+ a;
    }

}
