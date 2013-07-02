class SomeData {
  private int number;
  private String name;
  
  public SomeData(int number, String name){
    this.number = number;
    this.name = name;
  }

  public int getNumber(){
    return number;
  }
  
  public void setNumber(int number){
    this.number = number;
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }

  public String toString(){
    return "Number: "+number+", name: "+name;
  }
}
