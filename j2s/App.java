import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class App {
  public static void main(String[] args){
    System.out.println("Hello World");
    System.out.println();
    
    SomeData data = new SomeData(17, "foo");
    data.setNumber(data.getNumber() + 1);
    System.out.println(data);
    System.out.println();
    
    for(int i = 1, j=1; i < 10; i++){
      System.out.println(j);
      j*=i;
    }
    System.out.println(j);
    
    String[] names = new String[]{"blaz", "luka", "andraz"};
    
    List<String> updatedNames = new ArrayList<String>();
    for(String name : names){
      if(name.length() < 5){
        updatedNames.add("osebek "+name);
      }
    }
    
    for(String name : updatedNames){
      System.out.println(name);
    }
  }
}
