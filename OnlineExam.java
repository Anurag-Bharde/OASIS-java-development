import java.util.*;

class OnlineExam{
    HashMap<String,Integer> loginto=new HashMap<>();
    public static String userID;
    Scanner sc=new Scanner(System.in);
    
    public void login()
    {
    	System.out.println("---------------- WELCOME TO ONLINE EXAM SYSTEM ----------------");
        System.out.print("Enter User-Id: ");
        userID = sc.next();
        System.out.print("Enter Password: ");
        int password = sc.nextInt();
        loginto.put("Soumya",13579);
        loginto.put("Soumyadip",20026);
        loginto.put("Soumy",12345);
        
        if (loginto.containsKey(userID) && loginto.get(userID) == password)
        {
            System.out.println("\n" + "LOGIN SUCCESSFULLY...!");
            homepage();
        }
        else{
            System.out.println("\n" + "Invalid login credentials.!!! Please try again...");
            login();
        }
    }
    
    public void homepage()
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("Online Examination System ---> Welcome " + OnlineExam.userID + "!");
        System.out.println("-----------------------------------------------------");
        System.out.println("Select 1 to Update password...");
        System.out.println("Select 2 to Start the test...");
        System.out.println("Select 3 to Logout...");
        System.out.println("-----------------------------------------------------");
        System.out.print("Select Option: ");
        int sp=sc.nextInt();
        switch(sp){
            case 1: 
            	loginto = update();
            	homepage();
            	break;
            case 2: 
            	solve();
            	homepage();
            	break;
            case 3: 
                System.out.println("\n" + "Logout Successfully...!");
                System.out.println("Thank You for Attending the Test...");
                System.out.println("-----------------------------------------------------");
            	System.exit(0);
            	break;
            default: 
            	System.out.println("\n" + "Invalid Option Choice.! Try again...");
            	homepage();
            	break;
        }
    }
    
    public HashMap<String,Integer> update()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n------------------ UPDATE PASSWORD ------------------");
        System.out.print("Enter Username: ");
        String uid = sc.nextLine();
        System.out.print("Enter Old Password: ");
        int pass = sc.nextInt();
        if(loginto.containsKey(uid))
        {
            if(pass == loginto.get(uid))
            {
                System.out.println("Old Password Verified...");
                while(true)
                {
                    System.out.print("\n" + "Enter New Password: ");
                    int newpass = sc.nextInt();
                    System.out.print("ReEnter/Verify New Password: ");
                    int connewpass = sc.nextInt();
                    if(connewpass == newpass)
                    {
                        System.out.println("Password matched...");
                        loginto.replace(uid,newpass);
                        System.out.println("\n" + "Password Update Successfully...!");
                        break;
                    }
                    else{
                        System.out.println("\n" + "Password did't match.!!! Please try again...");
                        System.out.println("-----------------------------------------------------");
                    }
                }
            }
            else{
                System.out.println("\n" + "Wrong Password.!!! Try again later...");
                update();
            }
        }
        else
        {
            System.out.println("\n" + "User does not exist...");
            System.out.println("Profile Update Failed.!");
        }
        return loginto;
    }
    
    public void solve(){
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n\n----------------- STARTING THE TEST -----------------");
        System.out.println("You have 1 Minute to answer each question. Select the options wisely... ");
        System.out.println("Each question gives +5 marks for a correct answer and -1 mark for a wrong answer.");
        System.out.println("All the very best.!!");
        
        while(System.currentTimeMillis() < terminate)
        {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q1. System.out.println(?; ===> Here System & out is...?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. System & out both are classes\nb. System is class and out is object reference of OutputPrintStream\nc. System is class and out is object reference of PrintStream\nd. System is class and out is object reference of FilePrintStream");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'c')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q2. Which of the following interface must contain a unique element?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. Set\nb. Collection\nc. List\nd. Array");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'a')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q3. After performing these set of operations, what does the final list look contain?\n\nInsertFront(10);\nInsertFront(20);\nInsertRear(30);\nDeleteFront();\nInsertRear(40);\nInsertRear(10);\nDeleteRear();\nInsertRear(15);\ndisplay();");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. 20 30 40 10\nb. 10 30 10 15\nc. 10 30 40 15\nd. 20 30 40 15");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'c'){
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q4. Find the output of the following program...\n\npublic class Solution{\n    public static void main(String[] args){\n        byte x = 127;\n        x++;\n        x++;\n        System.out.print(x);\n    }\n}");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. 127\nb. -127\nc. 129\nd. 2");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'b')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Aptitude)-Q5. What is the least number to be subtracted from 945 to make it a perfect square?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. 45\nb. 16\nc. 30\nd. 24");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'a') 
            {
                c += 1;
            }
            else
                w += 1;
            break;
        }
        
        System.out.println("\n" + "Test Completed.!");
        score = ((c * 5) - w);
        System.out.println("Number of correct answers: " + c);
        System.out.println("Congratulations!! Your scored " + score + " points...");
    }
    
    public static void main(String args[]){
    	OnlineExam exam = new OnlineExam();
        exam.login();
    }
}