import java.sql.*;

import java.util.Scanner;
class First_JDBC{
    public static void main(String[] args) {
        System.out.println("\nTrying the JDBC connection\n\n");
        
        // Loading the driver.
        // But it gives Exception So...
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            // Creating a connection.
            // url, username, password.

            String url = "jdbc:mysql://localhost:3306/teacher";
            String username = "root";
            String password = "Asdf@1234";
            
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();



            // Statical hard code to insert the data into the database.

            // int result = stmt.executeUpdate("insert into student(id,name,address) values(1,'Rahul','Delhi')");

            // if(result > 0){
            //     System.out.println("Record Inserted Successfully");
            // }
            // else{
            //     System.out.println("Record Not Inserted");
            // }



            // Take the input from user by using Scanner class.
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the id: ");
            int id = input.nextInt();
            System.out.print("Enter the name: ");
            String name = input.next();
            System.out.print("Enter the address: ");
            String address = input.next();
            int result1 = stmt.executeUpdate("insert into student(id,name,address) values("+id+",'"+name+"','"+address+"')");

            if(result1 > 0){
                System.out.println("Record Inserted Successfully");
            }
            else{
                System.out.println("Record Not Inserted");
            }

            // use the loop to take the input over and over, as per your choice.




            input.close();

            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection is open");
            }

        }
        catch(Exception e){
            System.err.println("Driver is Not Loaded\n");
            e.printStackTrace();
        } 
    }
}
