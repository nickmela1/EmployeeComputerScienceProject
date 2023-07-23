public class Employee
{
   private int _id;
   private String _name;
   
   /**   
      Constructor
      @param id the number passed as an argument will be come the employee id
      @param name the string passed as an argument will be the employee name
   **/
   
   public Employee(int id, String name)
   {
     _id = id;
     _name = name;  
   }
   
   /**   
      Default Constructor
   **/
   
   public Employee()
   {
      _id = 0;
      _name = "";
   }
   
   /**   
      Method getName
      @return _name employee name
   **/
   
   public String getName()
   {
      return _name;
   }
   
   /**   
      Method getId
      @return _id employee id
   **/
   
   public int getId()
   {
      return _id;
   }   
}