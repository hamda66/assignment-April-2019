//package students;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pupil{
	private String ID;
    private String name;
    private String surname;
    private int course1;
    private int course2;
    private int course3;
    private int course4;
    private int course5;
 private double Gpa;
    /** Constructs a Student object with the given values 
     * @param course2 
     * @param course3 
     * @param course4 
     * @param course5 */
    public pupil(String ID, String name,String surname, int course1, int course2, int course3, int course4, int course5){
    	this.ID = ID;
    	this.name = name;
        this.surname = surname;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        
    }

    /** Returns the name of this Student */
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    public String getiD(){
        return ID;
    }

    /** Returns the coursepupil of this Student */
    public int getCourse1(){
        return course1;
    }
    public int getCourse2(){
        return course2;
    }
    public int getCourse3(){
        return course3;
    }
    
    public int getCourse4(){
        return course4;
    }
    
    public int getCourse5(){
        return course5;
    }
   

public double getGpa() {
		return Gpa = (double)((course1+course2+course3+course4+course5)/5);
	}

	public void setGpa(double gpa) {
		Gpa = gpa;
	}

public String toString() {
	return ID + name +surname +course1 + course1 + course1+ course1+ course1;
}

public void searchnames()  {

        Scanner sd;
		String searching =sd.nextLine().toLowerCase();

        for (String p  :  name)  {

            if (p != null && p.toLowerCase().indexOf(searching) > -1)  {

            List<String> list = Arrays.asList(name);

            int id = list.indexOf(p);

            System.out.println("\nName:" + p);}}

  

            }
	public static void main(String[] args) throws IOException{
		
		//PrintWriter pr = new PrintWriter("gg.txt");		
		 //BufferedWriter outputWriter = null;
		  //outputWriter = new BufferedWriter(new FileWriter("filename.txt"));
		FileOutputStream f = new FileOutputStream(new File ("my.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		
		   int x = 0;
		   int InputChoice = -1;
		   pupil[] students = new pupil[1000]; 
		   
		   Scanner input = new Scanner (System.in);
		   do{
		       System.out.println("\t\t\t\"*************welcome to school system****************\"");
		       System.out.println("Chose the folowing options;");
		   	System.out.println(" ");
		   	System.out.println("1-Add student ");
		   	System.out.println("2- View Student info");
		   	System.out.println("3-search Student ");
			System.out.println("4 -View students Gpa");
		   	System.out.println("5-exit");
		       System.out.println("Enter a option: ");
		       InputChoice = input.nextInt();

		       if (InputChoice==1){
		           if(x < 30) { //Able to add new student.
		        	   System.out.println("ID:");
		               String ID = input.next(); 
		               System.out.println("name:");
		               String name = input.next();    
		               System.out.println("surname:");
		               String surname = input.next();                                 
		  
		               System.out.println("Course:");
		               int course1 = input.nextInt();
		               System.out.println("Course2:");
		               int course2 = input.nextInt();
		               System.out.println("Course3:");
		               int course3 = input.nextInt();
		               System.out.println("Course4:");
		               int course4 = input.nextInt();
		               System.out.println("Course5:");
		               int course5 = input.nextInt();
		              
		               //Create the new student using the given inputs
		               pupil s = new pupil(ID,name, surname, course1,course2,course3,course4,course5);

		               //Place in array
		               students[x] = s;
o.writeObject(s.toString());
		   		   o.close();
		   		 f.close();
		   		 
		               //Increment x for next student input
		               x++;
		   		      
		   		        
		           } else {  
		               System.out.println("Can't add new student, School is full ");
		           }
		       }
		       else if (InputChoice==2) {
		           for (int i=0; i<x; i++) {
		               pupil s = students[i];
		               System.out.println(s.getiD()+" "+s.getName() +" "+ s.getSurname()+" " + s.getCourse1()+" " 
		                                      + s.getCourse2()+" " + s.getCourse3()+" "+ s.getCourse4()+" "+s.getCourse5());
		           }
		       }
		       else if (InputChoice==4) {
		           for (int i=0; i<x; i++) {
		               pupil s = students[i];
		               System.out.println(s.ID +" "+s.getName()+" "+s.getGpa());
		       }}
		       
		       else if (InputChoice==3) {
		    	   for (int i=0; i<x; i++) {
		               pupil s = students[i];
		    	   s.searchnames();}
		       }
		       
		       else if(InputChoice < 1 || InputChoice > 5){
		           System.out.println("Unrecognized menu choice; please re-enter");
		       }
		   } while (InputChoice != 5);
 
	
	}}



	

