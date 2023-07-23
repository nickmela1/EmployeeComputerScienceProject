import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class EmployeeDriver
{
   public static void main(String[] args) throws IOException
   {
      // try catch 
      try
      {
         // prompts user to enter file name
         String typeYourFile = JOptionPane.showInputDialog("Enter the name of the file: ");
         // file object
         File file = new File(typeYourFile);
         // array list 
         ArrayList<String> array = loadArray(file, typeYourFile);
         // length is the size of the array list
         int length = array.size();
         // to be used to create the id numbers
         int accumulator = 0;
         // the array
         String[] array2 = new String[length];
         // to hold the contents of the array
         String contents = "";
         // to increment and print the contents of the array
         String contents2 = "";
         // will be used to convert a string to an int
         int search2 = 0;
         // will be used as the reference varaible for a JOptionPane input to search for another id
         String search3 = "";
         // will be used to search3 to an int
         int search4 = 0;
         // will be used for input validation
         boolean true1 = false;
         // hash map
         Map<Integer, String> employeeMap = new HashMap<Integer, String>();
         // EmployeeMap object
         EmployeeMap eMap = new EmployeeMap(employeeMap);
         // an array of Employee objects
         Employee[] newEmployee = new Employee[length];
         // for loop        
         for(int i = 0; i < length; i++)
         {
            array2[i] = array.get(i);
            contents = array2[i];
            // as the loop iterates the accumulator increments ultimately serving as the id for each element in the file
            contents2 += "ID: " + (accumulator++) + " " + " |  " + contents + "\n";
            // as the loop iterates a new Employee object is made per iteration
            newEmployee[i] = new Employee(i, array2[i]);
            // each Employee object is added to the map 
            eMap.putEmployee(newEmployee[i]);
         }
         // do while loop for input validation
         do
         {
            JOptionPane.showMessageDialog(null, "The contents of the array w/keys are: " + "\n\n" + contents2);
            // do while loop for input validation
            do
            {
               String search = JOptionPane.showInputDialog("Enter the ID number you wish to search for: ");
               search2 = Integer.parseInt(search);
               if (search2 > accumulator - 1 || search2 < 0)
               {
                  JOptionPane.showMessageDialog(null, "ID not in directory");
               }
            } while(search2 > accumulator - 1 || search2 < 0);
            JOptionPane.showMessageDialog(null, "You searched for ID #" + search2 + "\n\n" + eMap.getEmployeeById(search2).getName() + "\n\n");
            do
            {
               search3 = JOptionPane.showInputDialog("Search for another ID? \n1 = yes \n2 = no");
               search4 = Integer.parseInt(search3);
               if (search4 > 2)
               {
                  JOptionPane.showMessageDialog(null, "Must type 1 or 2");
               }            
            } while(search4 > 2);        
            if(search4 == 1)
            {
               true1 = true;
            }
            else if(search4 == 2)
            {
               JOptionPane.showMessageDialog(null, "Goodbye");
               true1 = false;
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Must type 1 or 2");
            }
         } while(true1 != false);          
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Oops... something went wrong!");
      }
   }
   
   /**
      Method loadArray to load the array from the file and read vertically
      @param file to hold the file object
      @param theFile to hold the name of the file the user will enter
      @return toReturn an ArrayList
   **/
      
   public static ArrayList<String> loadArray(File file, String theFile) throws IOException
   {
      file = new File(theFile);
      Scanner inputFile = new Scanner(file);
      ArrayList<String> toReturn = new ArrayList<String>();
      while(inputFile.hasNextLine())
      {
         String arr1 = inputFile.nextLine();
         toReturn.add(arr1);
      }
      return toReturn;
   } 
}