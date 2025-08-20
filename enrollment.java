import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;  
import java.util.TimerTask;  

public class enrollment {
    public static void main(String[] args) {
        /*This part contains all the methods the will be utilized accordingly.*/
        ArrayList<String> contain1 = new ArrayList<>();
        ArrayList<String> contain2 = new ArrayList<>();
        ArrayList<String> contain3 = new ArrayList<>();
        Database(contain1);
        System.out.println();
        System.out.println();
        Interview(contain2);
        System.out.println();
        System.out.println();
        Program(contain3);
        System.out.println();
        System.out.println();
        Payment();
        System.out.println();
        System.out.println();
        Portfolio(contain1, contain2, contain3);
}
    public static void Database(ArrayList<String> container){
            /*This are all the initiated variables, constructor, and scanners*/
            database hau = new database();
            Scanner inAge = new Scanner(System.in);
            Scanner bcinp = new Scanner(System.in);
            Scanner bcinp1 = new Scanner(System.in);
            Scanner inp2 = new Scanner(System.in);
            Scanner inp3 = new Scanner(System.in);
            Scanner inp4 = new Scanner(System.in);
            Scanner inp5 = new Scanner(System.in);
            int askAge = 0;
            String parentApproval = "null";
            String bc = "null";
            String bc1 = "null";
            String certificate = "null";
            String certificate1 = "null";
            String name;
            /*ArrayList to contain the answers*/
            ArrayList<String> requirements = new ArrayList<>();
            for (int ask = 0; ask < 1; ask++){
                /*Try-catch block that will be asking for the information, this also uses exceptions handling and OOP from the database.java file*/
                try{
                    System.out.print("Enter your name: ");
                    name = inp4.nextLine();
                    String capitalize = name.substring(0, 1).toUpperCase() + name.substring(1);
                    hau.setName(capitalize);
                    requirements.add(hau.getName());
                    System.out.print("Input your age: ");
                    askAge = inAge.nextInt();
                    hau.setAge(askAge);
                    
                }catch(Exception e){
                    System.out.println("Error with age or name");
                    continue;
                }
                /*Follow up questions depending on the answers*/
                if (askAge < 18){
                    while (!parentApproval.equalsIgnoreCase("yes")){
                        System.out.print("Do you acquire Parent/Guardian approval sheet (Yes/No): ");
                        parentApproval = bcinp.nextLine();
                        if (parentApproval.equalsIgnoreCase("yes")){
                            hau.setParent("With parent/Guardian approval");
                            requirements.add(hau.getAge() + " " + hau.getParent());
                        }
                        else if(parentApproval.equalsIgnoreCase("No")){
                            hau.setParent("Without parent/Guardian approval");
                            requirements.add(hau.getAge() + " " + hau.getParent());
                            break;
                        }else{
                            System.out.println("Enter a valid answer");
                        }
                    }
                }
                else if (askAge >= 18){
                    requirements.add(Integer.toString(hau.getAge()));
                }
                /*Another question that will be needed*/
                System.out.print("Do you acquire a Birth Certificate? (Yes/No): ");
                while(!bc.equalsIgnoreCase("Yes")){
                    bc = bcinp1.nextLine();
                    if (bc.equalsIgnoreCase("Yes")){
                        requirements.add("Birth certificate");
                    }
                    else if (bc.equalsIgnoreCase("No")){
                            System.out.print("Would you like to follow it up? (Yes/No): ");
                            bc1 = inp2.nextLine();
                            if (bc1.equalsIgnoreCase("Yes")){
                                break;
                            }
                            else if (bc1.equalsIgnoreCase("No")){
                                System.out.println("A Birth Certificate is needed. Follow it up.");
                                break;
                            }
                            else{
                                System.out.print("Enter a valid answer: ");
                            }
                        
                    }
                    else{
                           System.out.print("Enter a valid answer: ");
                           continue;
                    }
                }
                /*Last question for this method, these loops are looping until we get a valid answer*/
                System.out.print("Do you acquire Senior High School Certificate of graduation? (Yes/No): ");
                while(!certificate.equalsIgnoreCase("Yes")){
                    certificate = inp3.nextLine();
                    if (certificate.equalsIgnoreCase("Yes")){
                        requirements.add("Graduation Certificate");
                    }
                    else if (certificate.equalsIgnoreCase("No")){
                            System.out.print("Would you like to follow it up? (Yes/No): ");
                            certificate1 = inp5.nextLine();
                            if (certificate1.equalsIgnoreCase("Yes")){
                                break;
                            }
                            else if (certificate1.equalsIgnoreCase("No")){
                                System.out.println("A graduation certificate is needed. Follow it up.");
                                break;
                            }
                            else{
                                System.out.print("Enter a valid answer: ");
                            }
                        
                    }
                    else{
                           System.out.print("Enter a valid answer: ");
                           continue;
                    }
                }
                
            }
                /*Transfers all the answers to the container in the parameter*/
                container.addAll(requirements);
    }

    public static void Interview(ArrayList<String> container1){
        /*Initiate all the needed variables and scanners and lists*/
        Scanner input1 = new Scanner(System.in);
        Scanner inp1 = new Scanner(System.in);
        Scanner inp2 = new Scanner(System.in);
        Scanner inp3 = new Scanner(System.in);

        String scholarship = "null";
        String dorm;
        String ask = "null";
        String ask1;
        int age = 0;
        ArrayList<String> Dorms = new ArrayList<>();
        /*First question for this method*/
        System.out.print("Are you considering to take a scholarship? (Yes/No): ");
        /*Looping until getting a valid answer*/
        while(!scholarship.equalsIgnoreCase("Yes")){
            scholarship = input1.nextLine();
            if (scholarship.equalsIgnoreCase("Yes")){
                Dorms.add("Yes");
                System.out.println("Scholarship Requirements \n FULL SCHOLAR \n    95 UP GWA \n    HALF Scholar \n    GWA 93 above \nDIFFERENT REQUIREMENTS:\n -GOOD MORAL\n -FORM 137/138 \n -PARENT SOURCE OF INCOME \n -CERTIFICATE  OF REGISTRATION(COR)");
            }
            else if (scholarship.equalsIgnoreCase("No")){
                Dorms.add("No");
                break;
            }
            else{
                System.out.print("Enter a valid answer: ");
                continue;
            }
        }
        /*Next question that needed to be answered*/
        System.out.print("Do you live outside of Angeles City? (Yes/No): ");
        dorm = inp1.nextLine();
        /*Follow up questions depending on the answers*/
        if (dorm.equalsIgnoreCase("Yes")){
            System.out.print("Would you like to use a dorm? (Yes/No): ");
            ask1 = inp3.nextLine();
            Dorms.add("Yes");
            if (ask1.equalsIgnoreCase("Yes")){
                System.out.print("Enter your age again for confirmation: ");
                age = inp2.nextInt();
                if (age < 21){
                    while(!ask.equalsIgnoreCase("Yes")){
                        System.out.print("Do you have a letter considered as parent's approval? (Yes/No): ");
                        ask = inp3.nextLine();

                        if (ask.equalsIgnoreCase("Yes")){
                            System.out.println("We are offering limited on-campus dormitories! Your request will be put to the list.");
                            Dorms.add("Yes");
                            break;
                        }
                        else if (ask.equalsIgnoreCase("no")){
                            System.out.print("We will need a copy of your parent's approval before we process your request, thank you!");
                            Dorms.add("No");
                            break;
                        }
                        else {
                            System.out.print("Enter either Yes or No: ");
                            continue;
                        }
                }
                }else if (age >= 21){
                        System.out.println("We will add you to the waitlist, wait an announcement in your email");
                    }
            /*Response depending on the answers*/
            }else if (ask1.equalsIgnoreCase("No")){
                System.out.println("If you reconsider, feel free to visit the office of dormitory");
                Dorms.add("No");
            }

        }
        /*Response depending on the answers*/
        else if (dorm.equalsIgnoreCase("No")){
            System.out.println("If you consider staying at a dorm, feel free to visit the office of dormitory");
            Dorms.add("No");
        }
        else {
            System.out.print("Enter a valid answer: ");
        }
        /*Transfers all the answers to the container in the parameter*/
        container1.addAll(Dorms);
    }

    public static void Program(ArrayList<String> container2){
        /*Initiate all the needed variables and scanners*/
        Scanner inp1 = new Scanner(System.in);
        Scanner inp2 = new Scanner(System.in);
        Scanner inp3 = new Scanner(System.in);
        database soc = new database();
        String course;
        int  sem = 0;
        int year = 0;
        System.out.println("A = Network Admintrator\nB = Web Development\nC = Computer Science\nD = Cyber Security\nE = MultiMedia");
        System.out.print("Enter your program: ");
        course = inp3.nextLine();
        System.out.print("Enter what year you are enrolling in (1|2|3|4): ");
        year = inp1.nextInt();
        System.out.print("Enter which semester you are enrolling in (1|2): ");
        sem = inp2.nextInt();
        /*The OOP in the program*/
        soc.setYear(year);
        soc.setSem(sem);
        String year1 = Integer.toString(soc.getYear());
        String sem1 = Integer.toString(soc.getSem());
        /*This is a huge conditional statement or if-else statement depending on the course, year, and sem provided*/
        /*a for Network Administrator, this contains all the year and sem for the program*/
        if (course.equalsIgnoreCase("a")){
            if (year1.equals("1")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                    System.out.println("A total of 23 units");
                    /*Pass it on to the 3rd list in the main method*/
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Civic Welfare Training Services 2 (3 units) \n-Special Issues in Catholic Theology (3 units) \n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Civic Welfare Training Services 2 (3 units) \n-Special Issues in Catholic Theology (3 units) \n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                }
        }
            else if (year1.equals("2")){
                if(sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n-The Contemporary World (3 units) \n\nMajor Subjects: \n-Basic Programming in Web (3 units)\n-Object-Oriented Programming  (3 units) \n-Operating Systems Application (3 units) \n-Data Structures and Algorithms ");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n-The Contemporary World (3 units) \n\nMajor Subjects: \n-Basic Programming in Web (3 units)\n-Object-Oriented Programming  (3 units) \n-Operating Systems Application (3 units) \n-Data Structures and Algorithms ");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Readings in Philippine History (3 units) \n\nMajor Subjects: \n-Server Technologies (3 units)\n-Introduction to Networks  (3 units) \n-Information Management (3 units) \n-Ethics for Computing Professionals ");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Readings in Philippine History (3 units) \n\nMajor Subjects: \n-Server Technologies (3 units)\n-Introduction to Networks  (3 units) \n-Information Management (3 units) \n-Ethics for Computing Professionals ");
                }
        }
            else if (year1.equals("3")){
                if(sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 1  (3 units) \n-Linear Algebra (3 units) \n-Calculus-based Physics (3 units) \n-Calculus-based Physics Laborator (3 units) \n\nMajor Subjects: \n-Project Management  (3 units)\n-Advance Server Management (3 units) \n-Information Assurance and Security (3 units) \n-Switching, Routing, and Wireless Essentials ");
                    System.out.println("A total of 22 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 1  (3 units) \n-Linear Algebra (3 units) \n-Calculus-based Physics (3 units) \n-Calculus-based Physics Laborator (3 units) \n\nMajor Subjects: \n-Project Management  (3 units)\n-Advance Server Management (3 units) \n-Information Assurance and Security (3 units) \n-Switching, Routing, and Wireless Essentials ");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 2  (3 units) \n-IT Elective 3 (3 units) \n-Understanding the Self (3 units) \n-Technical Writing of Information Technology Education (3 units) \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-Enterprise Networking, Security, and Automation (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                    System.out.println("A total of 21 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 2  (3 units) \n-IT Elective 3 (3 units) \n-Understanding the Self (3 units) \n-Technical Writing of Information Technology Education (3 units) \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-Enterprise Networking, Security, and Automation (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                }
        }
            else if (year1.equals("4")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 4  (3 units) \n-Art Appreciation (3 units) \n-Life and Works of Rizal  (3 units) \n\nMajor Subjects: \n-Network Independent Study 1 (3 units)\n-Network Security Implementation (3 units)");
                    System.out.println("A total of 15 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 4  (3 units) \n-Art Appreciation (3 units) \n-Life and Works of Rizal  (3 units) \n\nMajor Subjects: \n-Network Independent Study 1 (3 units)\n-Network Security Implementation (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMajor Subjects: \n-Network Independent Study 2 (3 units)\n-On-the-Job Training (486 hours) (6 units)");
                    System.out.println("A total of 9 units");
                    container2.add("The needed courses for your program are: \nMajor Subjects: \n-Network Independent Study 2 (3 units)\n-On-the-Job Training (486 hours) (6 units)");
                }
        }
    }
        /*b for Web Development, this contains all the year and sem for the program*/
        else if (course.equalsIgnoreCase("b")){
            if (year1.equals("1")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                }
            }
            else if (year1.equals("2")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n\nMajor Subjects: \n-Object-Oriented Programming  (3 units)\n-Operating Systems Application (3 units) \n-Data Structures and Algorithms (3 units) \n-Introduction to Web Programming (3 units) \n-Ethics for Computing Professionals (3 units) ");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n\nMajor Subjects: \n-Object-Oriented Programming  (3 units)\n-Operating Systems Application (3 units) \n-Data Structures and Algorithms (3 units) \n-Introduction to Web Programming (3 units) \n-Ethics for Computing Professionals (3 units) ");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Calculus-based Physics (3 units) \n-Readings in Philippine History (3 units) \n-Calculus-based Physics Laboratory (1 unit) \n-Christian Spirituality in the Contemporary World (3 units) \n\nMajor Subjects: \n-Introduction to Networks (3 units)\n-Information Management (3 units) \n-Dynamic Web Applications and Development Tools (3 units)");
                    System.out.println("A total of 24 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Calculus-based Physics (3 units) \n-Readings in Philippine History (3 units) \n-Calculus-based Physics Laboratory (1 unit) \n-Christian Spirituality in the Contemporary World (3 units) \n\nMajor Subjects: \n-Introduction to Networks (3 units)\n-Information Management (3 units) \n-Dynamic Web Applications and Development Tools (3 units)");
                }
            }
            else if (year1.equals("3")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 1 (3 units) \n-Linear Algebra (3 units) \n\nMajor Subjects: \n-Advanced Database Systems (3 units)\n-Systems Analysis and Design (3 units) \n-Web Server and Client Services (3 units) \n-Information Assurance and Security (3 units) \n-Web and Advertising Publishing Concepts");
                    System.out.println("A total of 21 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 1 (3 units) \n-Linear Algebra (3 units) \n\nMajor Subjects: \n-Advanced Database Systems (3 units)\n-Systems Analysis and Design (3 units) \n-Web Server and Client Services (3 units) \n-Information Assurance and Security (3 units) \n-Web and Advertising Publishing Concepts");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 2 (3 units) \n-Understanding the Self (3 units) \n-Technical Writing of Information Technology Education \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-Advanced Dynamic Web Applications (3 units) \n-Web Search Engine Optimization and Analytics (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                    System.out.println("A total of 21 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 2 (3 units) \n-Understanding the Self (3 units) \n-Technical Writing of Information Technology Education \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-Advanced Dynamic Web Applications (3 units) \n-Web Search Engine Optimization and Analytics (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                }
            }
            else if (year1.equals("4")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Web Development Capstone 1  (3 units)\n-On-the-Job Training (486 hours) (6 units)");
                    System.out.println("A total of 9 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Web Development Capstone 1  (3 units)\n-On-the-Job Training (486 hours) (6 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 3  (3 units) \n-IT Elective 4 (3 units) \n-Life and Works of Rizal (3 units) \n-The Contemporary World (3 units)\n\nMajor Subjects: \n-Web Development Capstone 2 (3 units)");
                    System.out.println("A total of 18 units");   
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-IT Elective 3  (3 units) \n-IT Elective 4 (3 units) \n-Life and Works of Rizal (3 units) \n-The Contemporary World (3 units)\n\nMajor Subjects: \n-Web Development Capstone 2 (3 units)");
                }
            }
    }
        /*c for computer science, this contains all the year and sem for the program*/
        else if (course.equalsIgnoreCase("c")){
            if (year1.equals("1")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units) \n-Ethics for Computing Professionals \n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units) \n-Ethics for Computing Professionals \n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                }
            }
            else if (year1.equals("2")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Linear Algebra (3 units) \n-Readings in Philippine History (3 units) \n\nMajor Subjects: \n-Systems Analysis and Design (3 units)\n-Object-Oriented Programming (3 units) \n-Data Structures and Algorithms (3 units) \n-Advanced Discrete Mathematics and Structures (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Linear Algebra (3 units) \n-Readings in Philippine History (3 units) \n\nMajor Subjects: \n-Systems Analysis and Design (3 units)\n-Object-Oriented Programming (3 units) \n-Data Structures and Algorithms (3 units) \n-Advanced Discrete Mathematics and Structures (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Differential Calculus (3 units) \n-Understand the Self (3 units) \n-Christian Spirituality in the Contemporary World \n\nMajor Subjects: \n-Introduction to Networks \n-Information Management (3 units) \n-Systems Analysis and Design \n-Design and Analysis of Algorithms (3 units) \n-Design and Implementation of Programming Languages (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Differential Calculus (3 units) \n-Understand the Self (3 units) \n-Christian Spirituality in the Contemporary World \n\nMajor Subjects: \n-Introduction to Networks \n-Information Management (3 units) \n-Systems Analysis and Design \n-Design and Analysis of Algorithms (3 units) \n-Design and Implementation of Programming Languages (3 units)");
                }
            }
            else if (year1.equals("3")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Integral Calculus (3 units) \n-Probability and Statistics (3 units) \n-Technical Writing for Information Technology Education (3 units)\n\nMajor Subjects: \n-Information Assurance and Security (3 units)\n-Introduction to Modelling and Simulation (3 units) \n-Automata Theory and Formal Languages (3 units) \n-Application Development and Emerging Technologies (3 units) \n-Implementation and Management of Software Engineering (3 units)");
                    System.out.println("A total of 24 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Integral Calculus (3 units) \n-Probability and Statistics (3 units) \n-Technical Writing for Information Technology Education (3 units)\n\nMajor Subjects: \n-Information Assurance and Security (3 units)\n-Introduction to Modelling and Simulation (3 units) \n-Automata Theory and Formal Languages (3 units) \n-Application Development and Emerging Technologies (3 units) \n-Implementation and Management of Software Engineering (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Ethics (3 units) \n-CS Elective 1 (3 units) \n-CS Elective 2 (3 units)\n-Calculus-based Physics (3 units)\n-Calculus-based Physics Laboratory \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-CS Independent Study 1 (3 units) \n-Operating Systems Fundamentals (3 units)");
                    System.out.println("A total of 22 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Ethics (3 units) \n-CS Elective 1 (3 units) \n-CS Elective 2 (3 units)\n-Calculus-based Physics (3 units)\n-Calculus-based Physics Laboratory \n\nMajor Subjects: \n-Cloud Computing (3 units)\n-CS Independent Study 1 (3 units) \n-Operating Systems Fundamentals (3 units)");
                }
            }
            else if (year1.equals("4")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Art Appreciation (3 units) \n-CS Elective 3 (3 units) \n-Life and Works of Rizal (3 units) \n-The Contemporary World (3 units)\n\nMajor Subjects: \n-CS Independent Study 2 (3 units)\n-Application and Systems Integration (3 units)");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Art Appreciation (3 units) \n-CS Elective 3 (3 units) \n-Life and Works of Rizal (3 units) \n-The Contemporary World (3 units)\n\nMajor Subjects: \n-CS Independent Study 2 (3 units)\n-Application and Systems Integration (3 units)");
                }           

                else if (sem1.equals("2"))
                    System.out.println("The needed courses for your program are: \n\nMajor Subject/s: On-the-Job Training (486 hours) (6 units)");
                    System.out.println("A total of 18 units");     
                    container2.add("The needed courses for your program are: \n\nMajor Subject/s: On-the-Job Training (486 hours) (6 units)");
                }
            }
        /*d for Cyber Security, this contains all the year and sem for the program, all the way up to 5th year*/
        else if (course.equalsIgnoreCase("d")){
            System.out.println("Cyber Security reaches 5th year, and starting from 4th year, it will be considered as tri-sem");
            System.out.print("Enter what year you will be enrolling in (1|2|3|4|5): ");
            year = inp1.nextInt();
            System.out.print("Enter which semester you are enrolling in (1|2|3): ");
            sem = inp2.nextInt();
            soc.setYear(year);
            soc.setSem(sem);
            year1 = Integer.toString(soc.getYear());
            sem1 = Integer.toString(soc.getSem());            
            if (year1.equals("1")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computing Fundamentals (3 units)\n-Logic Formulation and Introductory Programming (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Analytic Geometry (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 2: Looking through the Lens of Big History (3 units)\n\nMajor Subjects: \n-Discrete Mathematics and Structures (3 units)\n-Programming with Structured Data Types (3 units) \n-Principles of Human Computer Interaction (3 units)");
                }
            }
            else if (year1.equals("2")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n-The Contemporary World \n\nMajor Subjects: \n-Basic Programming in Web (3 units)\n-Object-Oriented Programming (3 units) \n-Data Structures and Algorithms (3 units) \n-Operating Systems Fundamentals \n- Cyber Security & Emerging Technology & Threats to Cyber Security (3 units)");
                    System.out.println("A total of 26 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Ethics (3 units) \n-Calculus (3 units) \n-The Contemporary World \n\nMajor Subjects: \n-Basic Programming in Web (3 units)\n-Object-Oriented Programming (3 units) \n-Data Structures and Algorithms (3 units) \n-Operating Systems Fundamentals \n- Cyber Security & Emerging Technology & Threats to Cyber Security (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Readings in Philippine History (3 units) \n-Christian Spirituality in the Contemporary World \n\nMajor Subjects: \n-Information Management (3 units)\n-Introduction to Networks (3 units) \n-Design and Analysis of Algorithms (3 units) \n-Dynamic Web Applications and Development Tools");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Probability and Statistics (3 units) \n-Readings in Philippine History (3 units) \n-Christian Spirituality in the Contemporary World \n\nMajor Subjects: \n-Information Management (3 units)\n-Introduction to Networks (3 units) \n-Design and Analysis of Algorithms (3 units) \n-Dynamic Web Applications and Development Tools");
                }
            }
            else if (year1.equals("3")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Linear Algebra (3 units) \n-Art Appreciation (3 units) \n-Life and Works of Rizal (3 units) \n\nMajor Subjects: \n-Internet of Things (3 units)\n- Introduction to Network Forensics (3 units) \n-Cloud Computing for Cybersecurity (3 units) \n-Server Administration and Security 1 (3 units)\n-Switching, Routing, and Wireless Essentials (3 units)");
                    System.out.println("A total of 20 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Linear Algebra (3 units) \n-Art Appreciation (3 units) \n-Life and Works of Rizal (3 units) \n\nMajor Subjects: \n-Internet of Things (3 units)\n- Introduction to Network Forensics (3 units) \n-Cloud Computing for Cybersecurity (3 units) \n-Server Administration and Security 1 (3 units)\n-Switching, Routing, and Wireless Essentials (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Understanding the Self (3 units) \n-Calculus-based Physics (3 units) \n-Calculus-based Physics Laboratory (1 units) \n-Technical Writing for Information Technology Education \n\nMajor Subjects: \n-Software and Hardware Security (1 units)\n-Server Administration and Security 2 (1 units) \n-Enterprise Networking, Security, and Automation (3 units)");
                    System.out.println("A total of 15 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Understanding the Self (3 units) \n-Calculus-based Physics (3 units) \n-Calculus-based Physics Laboratory (1 units) \n-Technical Writing for Information Technology Education \n\nMajor Subjects: \n-Software and Hardware Security (1 units)\n-Server Administration and Security 2 (1 units) \n-Enterprise Networking, Security, and Automation (3 units)");
                }
            }
            else if (year1.equals("4")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Applied Cryptography (3 units)\n-Network & Security (3 units) \n-Cyber Security in Cloud Computing (3 units)");
                    System.out.println("A total of 9 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Applied Cryptography (3 units)\n-Network & Security (3 units) \n-Cyber Security in Cloud Computing (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Ethical Hacking and Countermeasures (3 units)\n-Information Systems and Security Management (3 units) \n-Cybercrime Investigation, Digital Forensics and Incident Response (3 units)");
                    System.out.println("A total of 9 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Ethical Hacking and Countermeasures (3 units)\n-Information Systems and Security Management (3 units) \n-Cybercrime Investigation, Digital Forensics and Incident Response (3 units)");
                }
                else if (sem1.equals("3")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Project Management (3 units)\n-Leadership and Communication (3 units) \n-Cybersecurity and Privacy: Law, Policies, and Compliance (3 units)");
                    System.out.println("A total of 9 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Project Management (3 units)\n-Leadership and Communication (3 units) \n-Cybersecurity and Privacy: Law, Policies, and Compliance (3 units)");
                }
            }
            else if (year1.equals("5")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Accounting & Finance (3 units)\n-Management & Security of Enterprise Systems (3 units)");
                    System.out.println("A total of 6 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Accounting & Finance (3 units)\n-Management & Security of Enterprise Systems (3 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Written Comprehensive Examination (0 units)\n-Capstone Project 1 (Internship and Integration Research) (3 units)");
                    System.out.println("A total of 3 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Written Comprehensive Examination (0 units)\n-Capstone Project 1 (Internship and Integration Research) (3 units)");
                }
                else if(sem1.equals("3")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Capstone Project 2 (Product/System Development) (6 units)");
                    System.out.println("A total of 6 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Capstone Project 2 (Product/System Development) (6 units)");
                }
            }
        }
        /*e for Multimedia, this contains all the year and sem for the program*/
        else if (course.equalsIgnoreCase("e")){
            if (year1.equals("1")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computer Programming 1 (3 units)\n-Introduction to Entertainment and Multimedia Computing (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE (2 units) \n-Theological Foundations (3 units) \n-Science, Technology and Society (3 units) \n-Mathematics in the Modern World (3 units)\n-Civic Welfare Training Services 1 (3 units)\n-Big History 1: Big Bang to the Future (3 units)\n\nMajor Subjects: \n-Computer Programming 1 (3 units)\n-Introduction to Entertainment and Multimedia Computing (3 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Art Appreciation (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units) \n-Big History 2: Looking through the Lens of Big History (3 units)\n-Civic Welfare Training Services 2 (3 units) \n\nMajor Subjects: \n-Computer Programming 2 (3 units)\n-Freehand and Digital Drawing (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE2 (2 units) \n-Art Appreciation (3 units) \n-Purposive Communication (3 units)\n-Special Issues in Catholic Theology (3 units) \n-Big History 2: Looking through the Lens of Big History (3 units)\n-Civic Welfare Training Services 2 (3 units) \n\nMajor Subjects: \n-Computer Programming 2 (3 units)\n-Freehand and Digital Drawing (3 units)");
                }
            }
            else if (year1.equals("2")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Physics for Animation (3 units) \n-The Contemporary World (3 units) \n\nMajor Subjects: \n-Principles of 2D Animation (3 units)\n-Data Structures and Algorithms (3 units) \n-Creative Writing and Story Board Design (3 units) \n-Usability, HCI and User Interaction Design (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE3 (2 units) \n-Physics for Animation (3 units) \n-The Contemporary World (3 units) \n\nMajor Subjects: \n-Principles of 2D Animation (3 units)\n-Data Structures and Algorithms (3 units) \n-Creative Writing and Story Board Design (3 units) \n-Usability, HCI and User Interaction Design (3 units) \n-Applications Development and Emerging Technologies (3 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Readings in Philippine History (3 units) \n-Christian Spirituality in the Contemporary World (3 units) \n\nMajor Subjects: \n-Information Management (3 units)\n-Principles of 3D Animation (3 units) \n-Computer Graphics Programming (3 units)\n-Advanced 2D Animation (Scripting for 2D) (3 units) \n-Introduction to Game Design and Development (3 units)");
                    System.out.println("A total of 23 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-PE4 (2 units) \n-Readings in Philippine History (3 units) \n-Christian Spirituality in the Contemporary World (3 units) \n\nMajor Subjects: \n-Information Management (3 units)\n-Principles of 3D Animation (3 units) \n-Computer Graphics Programming (3 units)\n-Advanced 2D Animation (Scripting for 2D) (3 units) \n-Introduction to Game Design and Development (3 units)");
                }
            }
            else if(year1.equals("3")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-EMC Elective 1 (3 units) \n-Understanding the Self (3 units) \n\nMajor Subjects: \n-Modeling and Rigging (3 units)\n-Image and Video Processing (3 units) \n-Design and Production Process (3 units)\n-Audio Design and Sound Engineering (3 units) \n-Advanced 3D Animation (Scripting for 3D) (3 units)");
                    System.out.println("A total of 21 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-EMC Elective 1 (3 units) \n-Understanding the Self (3 units) \n\nMajor Subjects: \n-Modeling and Rigging (3 units)\n-Image and Video Processing (3 units) \n-Design and Production Process (3 units)\n-Audio Design and Sound Engineering (3 units) \n-Advanced 3D Animation (Scripting for 3D) (3 units)");
                }
                else if (sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-Ethics (3 units) \n-Great Books (3 units) \n-EMC Elective 2 (3 units)\n\nMajor Subjects: \n-Lighting and Effects (3 units)\n-Texture and Mapping (3 units) \n-Compositing and Rendering (3 units)\n-Advanced Sound Production (3 units)");
                    System.out.println("A total of 21 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-Ethics (3 units) \n-Great Books (3 units) \n-EMC Elective 2 (3 units)\n\nMajor Subjects: \n-Lighting and Effects (3 units)\n-Texture and Mapping (3 units) \n-Compositing and Rendering (3 units)\n-Advanced Sound Production (3 units)");
                }
            }
            else if(year1.equals("4")){
                if (sem1.equals("1")){
                    System.out.println("The needed courses for your program are: \n\nMajor Subjects: \n-Internship/OJT (486 hours) (3 units)\n-Capstone Project 1 for Animation (9 units)");
                    System.out.println("A total of 12 units");
                    container2.add("The needed courses for your program are: \n\nMajor Subjects: \n-Internship/OJT (486 hours) (3 units)\n-Capstone Project 1 for Animation (9 units)");
                }
                else if(sem1.equals("2")){
                    System.out.println("The needed courses for your program are: \nMinor Subjects: \n-EMC Elective 3 (3 units) \n-Life and Works of Rizal (3 units) \n\nMajor Subjects: \n-Capstone Project 2 for Animation (3 units)\n-Animation Design and Production (3 units) \n-Ethics for Computing Professionals (3 units)");
                    System.out.println("A total of 15 units");
                    container2.add("The needed courses for your program are: \nMinor Subjects: \n-EMC Elective 3 (3 units) \n-Life and Works of Rizal (3 units) \n\nMajor Subjects: \n-Capstone Project 2 for Animation (3 units)\n-Animation Design and Production (3 units) \n-Ethics for Computing Professionals (3 units)");
                }
            }
        }
    }  
    public static void Payment(){
        /*Initiate all the variables, scanners, and OOP for this method*/
        Scanner pay = new Scanner(System.in);
        Scanner pay1 = new Scanner(System.in);
        database it = new database();
        String answer1;
        String answer2;
        int price = 200;
        int paid = 0;
        System.out.println("The reservation/processing fee of your enrollment is worth PHP200.");
        System.out.print("Would you like to pay now? (Yes/No): ");
        answer1 = pay.nextLine();
        /*Conditional statement based on the answers*/
        if (answer1.equalsIgnoreCase("Yes")){
            System.out.print("Enter the amount they paid: ");
            paid = pay.nextInt();
            it.setPs(paid);
            int total = price - it.getPs();
            /*Calculates and bring back the remaining balance for this conditional statement*/
            while (true){
                if (total == 0){
                    System.out.println("Thank you for enrolling! Please wait while the teller prints out your student file.");
                    break;
                }
                else if (total > 0){
                    System.out.println("Your remaining balance is: " + total);
                    System.out.print("Would you like to follow-up the remaining balance? (Yes/No): ");
                    answer2 = pay1.nextLine();
                    if (answer2.equalsIgnoreCase("Yes")){
                        System.out.println("Your remaining balance will be added to your student tuition. Thank you for enrolling! Please wait while the teller prints out your student e-portfolio.");
                        break;
                    }
                    else if (answer2.equalsIgnoreCase("No")){
                        System.out.println("Your remaining balance will now be automatically added to your student tuition");
                        break;
                    }
                    else{
                        System.out.println("Enter a valid input.");
                        continue;
                    }
                }
                else if (total < 0){
                    System.out.println("The excess will be deducted from your student tuition");
                    break;

                }
            }
        }else if (answer1.equalsIgnoreCase("No")){
            System.out.println("The reservation fee will automatically be added to your student tuition once you receive your student e-portfolio.");
        }else{
            System.out.println("Enter a valid input");
        }
    }
    public static void Portfolio(ArrayList<String> con1, ArrayList<String> con2, ArrayList<String> con3){
        /*Timer to represent a visual image of the processing time*/
        Timer counter = new Timer();
        TimerTask task = new TimerTask() {
            int currentNum = 1;
            int passed = 6;

            @Override
            public void run() {
                if (currentNum < passed) {
                    System.out.println("Processing... " + currentNum);
                    currentNum++;
                } else {
                    System.out.println("Congratulations! You're officially enrolled! Here is a copy of your student portfolio");
                    counter.cancel();
                }
            }
        };
        counter.scheduleAtFixedRate(task, 0, 1000); 
        /*Prints out the student portfolio on a .txt file using a filewriter, try-catch, and conditional statements*/
        int i = 1;
        try {
            FileWriter writer = new FileWriter("Student Portfolio.txt");

            for (int j = 1; j < 2; j++){
                writer.write("Name: " + con1.get(0) + "\n");
                writer.write("Age: " + con1.get(1) + "\n");
                writer.write("Requirements available: \n");
                if (con1.size() > 2){
                    writer.write("\t-"+con1.get(2) + "\n");
            }   
                if (con1.size() > 3){
                writer.write("\t-"+con1.get(3) + "\n");
            }
            writer.write("\n");
            if (con2.size() <= 2){
                for (int k = 1; k < 2; k++){
                    writer.write("\nApplying for scholarship? (Yes/No): " + con2.get(0) + "\n");
                    writer.write("\nLiving outside of Angeles City? (Yes/No): " + con2.get(1) + "\n");
                }
            }
            else{
                for (int k = 1; k < 2; k++){
                    writer.write("\nApplying for scholarship? (Yes/No): " + con2.get(0) + "\n");
                    writer.write("\nLiving outside of Angeles City? (Yes/No): " + con2.get(1) + "\n");
                    writer.write("\nWilling to take a dorm? (Yes/No): " + con2.get(2) + "\n");
                }
            }
            writer.write("\n ");
            while (i != 2){
                writer.write(con3.get(0));
                i++;
            }

            writer.write(" \n");
            writer.write(" \n");
            writer.write("\nSection for all subjects: A-" + con1.get(0).length() + "1");
            writer.close();
        } 
    }
        catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println();
    }
}


