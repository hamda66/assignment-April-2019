package time;
/*
****Student database system which holders the names,ids, and marks of the student attending a school
**class assignment 
**student registration/database system
*/
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class student{
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
    public student(String ID, String name,String surname, int course1, int course2, int course3, int course4, int course5){
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

public String toString() {   //this is called when the object is being printed to a file
	return ID+"," + name+"," +surname+ "," +course1+ "," + course2 +","+ course3+ ","+ course4+","+ course5+System.lineSeparator();
}
	public static void main(String[] args) throws IOException{
		
		FileOutputStream f = new FileOutputStream(new File ("myRecord.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		FileWriter fw;
		
		   int x = 0;
		   int InputChoice = -1;
		   student[] students = new pupil[1000]; 
		   
		   Scanner input = new Scanner (System.in);
		   do{   // do loop the check the conditions of input choices
		       System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*welcome to school system*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
		       System.out.println("Choose the folowing options;");
		   	System.out.println(" ");
		   	System.out.println("1-Add student: ");
		   	System.out.println("2- View Student information:");
		   	System.out.println("3-Search a Student: ");
			System.out.println("4 -View students Gpa: ");
			 System.out.println("5-delete a student: ");
		   	System.out.println("6-exit: ");
		       System.out.println("Enter an option: ");
		       InputChoice = input.nextInt();

		       if (InputChoice==1){
		           if(x < 30) { //add new student.
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
		               student stud = new pupil(ID,name, surname, course1,course2,course3,course4,course5);

		               //Place the student information into an array
		               students[x] = stud;
				   try{
				   fw= new FileWriter("pupil.txt", true); //automatically saves the the info the students ont to a file
					   fw.write(stud.toString()); //saves the whole student onto file
					   fw.close();
				   }
				   catch (IOException e){
				   e.printStackTrace();
				   }
                       		  o.close();//file closer
		   		 f.close();//file closer
		   		 
		               //Increment x for next student input of information
		               x++;
		   		      
		   		        
		           } else {  
		               System.out.println("Can't add new student, School is over it's capacity limit. transfere to another school ");
		           }
		       }
		       else if (InputChoice==2) { //else statement to view student information
		           for (int i=0; i<x; i++) {
		               student stud = students[i];
		               System.out.println(stud.getiD()+" "+stud.getName() +" "+ stud.getSurname()+" " + stud.getCourse1()+" " 
		                                      + stud.getCourse2()+" " + stud.getCourse3()+" "+ stud.getCourse4()+" "+stud.getCourse5());
		           }
		       }
		       else if (InputChoice==3) { //the usage of binary screach by name
		    	   Scanner sc = new Scanner(System.in); //declarage of scanner
		    	   System.out.println("enter name of student: ");
		    	   String key=sc.next(); //input for key
		           for (int i=0; i<x; i++) {
		    	   student stud = students[i];
				   Array.sort(students); // sorting methord that sorts Array
		   		int index= Array.binarySearch(students,key); //binary search by name 
				   student stud2 = students[index] //new array that hold the position of screached student
				   System.out.println(stud2.ID + " "+ stud2.getName); // printing out the result
				  
			   }
		       }
		       else if (InputChoice==4) { //GPA viewer
		           for (int i=0; i<x; i++) { //loop through the whole students array
		               student stud = students[i];
		               System.out.println(stud.ID +" "+stud.getName()+" "+stud.getGpa()); //print ou average with student name
			   }}
			    else if (InputChoice==5){ //the act of removal of student
			    	System.out.println("Enter name: ");
		        	Scanner sc = new Scanner(System.in);
		        	String removal=sc.next();
		    	   for (int i=0; i<x; i++) {
		               student stud = students[i];
		               ArrayList<pupil> yey = new ArrayList<pupil>(); // new array list that copys the new content
		               yey.remove(stud); //removal of the student and its info
		       }
		        }
			    
		       else if(InputChoice < 1 || InputChoice > 6){
		           System.out.println("Incorrect choice. Please choose one of the above and re-enter");
		       }o.close(); //file closer
			f.close();//file closer	
		   } while(InputChoice != 6); //Statement that closes the do loop for good
	
		   }
		   
	}
					  


