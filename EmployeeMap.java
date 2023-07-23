import java.util.*;

public class EmployeeMap
{
   // field
   private Map<Integer, String> _employeeMap;
   
   /**
      Constructor
      @param map a map
   **/
   
   public EmployeeMap(Map<Integer, String> map)
   {
      _employeeMap = map;  
   }
   
   /**
      Method getEmployeeById to return an employee name
      @param id the employee id that will be searched for
      @return foundEmployee
   **/
   
   public Employee getEmployeeById(int id)
   {
      Employee foundEmployee = new Employee();
      for(int key: _employeeMap.keySet())
      {
         if(key == id)
         {
            foundEmployee = new Employee(key, _employeeMap.get(key));
            return foundEmployee;
         }
      }
      return foundEmployee;
   }
   
   /**
      Method getMap to return _employeeMap
      @return _employeeMap 
   **/
   
   public Map<Integer, String> getMap()
   {
      return _employeeMap;
   }
   
   /**
      Method putEmployee to add an Employee object to the map
      @param emp an Employee object
   **/
   
   public void putEmployee(Employee emp)
   {
      _employeeMap.put(emp.getId(), emp.getName());
   }   
}