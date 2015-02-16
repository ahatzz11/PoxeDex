/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordan Steffan, Alex Hatzenbuhler, Tom Cocozzello
 */

package beans;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DBCon 
{
    public DBCon()
    {
        //empty constructor
    }
    public boolean getRecords() throws SQLException, ClassNotFoundException
    {
                String tranData = "";
                ArrayList records = new ArrayList();
                try
                {
                    //Load Oracle driver
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                }
                catch(ClassNotFoundException cnfe)
                {
                    cnfe.printStackTrace();
                }
                //Initialize connection to database
                //      Remember to change username and password
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db1.chpc.ndsu.nodak.edu:1521:cs", 
                       "cocozzel", "Aug641992");// "jordaste", "Oct771992");

                //Create a statement and a query, execute the query
                Statement stmt = conn.createStatement();

                String query = "SELECT * FROM TYPES"; //Remember to change this to match your database

                try
                {
                    //stmt.executeUpdate("IF EXISTS(select * from sysobjects where name='TYPES') drop table TYPES");
                    stmt.executeUpdate("DROP TABLE TYPES cascade constraints");
                    stmt.executeUpdate("CREATE TABLE TYPES " + 
                            "(typeID INT NOT NULL, " + 
                            "name VARCHAR(10), " +
                            "PRIMARY KEY (typeID))");
                    System.out.println("types table created");
                    
                    
                    stmt.executeUpdate("DROP TABLE EGGTYPES cascade constraints");
                    stmt.executeUpdate("CREATE TABLE EGGTYPES " + 
                            "(eggID INT NOT NULL, " +
                            "eggName VARCHAR(20), " +
                            "PRIMARY KEY (eggID))");
                    
                    System.out.println("eggtypes table created");
                    
                    
                    stmt.executeUpdate("DROP TABLE MOVELIST CASCADE CONSTRAINTS");
                    stmt.executeUpdate("CREATE TABLE MOVELIST " +
                            "(moveID INT NOT NULL, " +
                            "name VARCHAR(30), " + 
                            "typeID INT, " + 
                            "power INT, " +
                            "accuracy INT, " +
                            "pp INT, " + 
                            "classification VARCHAR(10), " + 
                            "effect VARCHAR(255), " + 
                            "PRIMARY KEY (moveID), " + 
                            "FOREIGN KEY (typeID) REFERENCES TYPES(typeID))");
                    
                    System.out.println("moveList table created");
                    
                    stmt.executeUpdate("DROP TABLE LEVELMOVES cascade constraints");
                    stmt.executeUpdate("CREATE TABLE LEVELMOVES " + 
                            "(pkmnID INT NOT NULL, " +
                            "move1 INT, " +
                            "move2 INT, " +
                            "move3 INT, " +
                            "move4 INT, " + 
                            "move5 INT, " +
                            "move6 INT, " +
                            "move7 INT, " +
                            "move8 INT, " +
                            "move9 INT, " +
                            "move10 INT, " +
                            "move11 INT, " +
                            "move12 INT, " +
                            "move13 INT, " +
                            "move14 INT, " +
                            "move15 INT, " +
                            "move16 INT, " +
                            "move17 INT, " +
                            "move18 INT, " +
                            "move19 INT, " +
                            "move20 INT, " +
                            "move21 INT, " +
                            "move22 INT, " +
                            "move23 INT, " +
                            "move24 INT, " +
                            "move25 INT, " +
                            
                              "PRIMARY KEY (pkmnID), " +
                              "FOREIGN KEY (move1) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move2) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move3) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move4) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move5) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move6) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move7) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move8) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move9) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move10) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move11) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move12) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move13) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move14) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move15) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move16) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move17) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move18) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move19) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move20) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move21) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move22) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move23) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move24) REFERENCES MOVELIST(moveID), "
                            + "FOREIGN KEY (move25) REFERENCES MOVELIST(moveID))");
                            
                    System.out.println("levelmoves table created");
                    
                    stmt.executeUpdate("DROP TABLE POKEMONDEETS cascade constraints");
                    stmt.executeUpdate("CREATE TABLE POKEMONDEETS " + 
                            "(pkmnID INT NOT NULL, " +
                            "name VARCHAR(30), " +
                            "typeID1 INT, " +
                            "typeID2 INT, " + 
                            "height DECIMAL(4,1), " +
                            "weight DECIMAL(4,1), " +
                            "eggType1 int, " +
                            "eggType2 int, " +
                            "PRIMARY KEY (pkmnID), " +
                            "FOREIGN KEY (typeID1) REFERENCES TYPES(typeID), " + 
                            "FOREIGN KEY (typeID2) REFERENCES TYPES(typeID), " +
                            "FOREIGN KEY (eggType1) REFERENCES EGGTYPES(eggID), " +
                            "FOREIGN KEY (eggType2) REFERENCES EGGTYPES(eggID))");
                    
                    System.out.println("pokemondeets table created");
                    
                   stmt.executeUpdate("DROP TABLE BASESTATS cascade constraints");
                   stmt.executeUpdate("CREATE TABLE BASESTATS " +  
                            "(statsID INT NOT NULL, " + 
                            "hp INT, " +
                            "attack INT, " + 
                            "defense INT, " +
                            "spAttack INT, " +
                            "spDefense INT, " +
                            "speed INT, " + 
                            "PRIMARY KEY (statsID), " + 
                            "FOREIGN KEY (statsID) REFERENCES POKEMONDEETS(pkmnID) ON DELETE CASCADE)");
                   
                    System.out.println("basestats Table created");
                }
                catch(SQLException se)
                {
                    System.out.println("Table failed to create");
                    se.printStackTrace();
                }
                
                //Create a try block for reading from a file
                try
                {
                    //Read in file and initalize a scanner to it
                    File fileBaseStats = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\BaseStats.txt");
                    File fileEggTypes = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\EggTypes.txt");
                    File fileLevelUpMoveSets = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\LevelUpMoveSets.txt");
                    File fileMoveList = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\MoveList.txt");
                    File filePokemonDeets = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\PokemonDeets.txt");
                    File fileTypes = new File(
                      "C:\\Users\\Tom.Cocozzello\\Desktop\\PokeDexDB1.2\\PokeDexDB1.0\\web\\Types.txt");

                    Scanner scanBaseStats = new Scanner(fileBaseStats);
                    Scanner scanEggTypes = new Scanner(fileEggTypes);
                    Scanner scanLevelUpMoveSets = new Scanner(fileLevelUpMoveSets);
                    Scanner scanMoveList = new Scanner(fileMoveList);
                    Scanner scanPokemonDeets = new Scanner(filePokemonDeets);
                    Scanner scanTypes = new Scanner(fileTypes);
                    
                    while(scanTypes.hasNext())
                    {
                                             
                        //read in each line of the text file
                        String tempA = scanTypes.nextLine();
                        String [] ar = tempA.split(",");
                        int one = Integer.parseInt(ar[0].trim());
                        String two = ar[1].trim();

                        stmt.executeUpdate("INSERT INTO TYPES (typeID, name) VALUES"
                        + " (" + one + ", '" + two + "')"); 
                    } //loop while file has more data
                    
                    while(scanEggTypes.hasNext())
                    {                        
                        //read in each line of the text file
                        String tempA = scanEggTypes.nextLine();
                        String [] ar = tempA.split(",");
                        
                        int one = Integer.parseInt(ar[0].trim());
                        String two = ar[1].trim();
               
                        stmt.executeUpdate("INSERT INTO EggTypes (eggID, eggName) VALUES"
                        + " (" + one + ", '" + two + "')"); 
                    } //loop while file has more data
                     
                    while(scanMoveList.hasNext())
                    {
                        //read in each line of the text file
                        String tempA = scanMoveList.nextLine();
                        String [] ar = tempA.split(",");
                        
                        int one = Integer.parseInt(ar[0].trim());
                        String two = ar[1].trim();
                        int three = Integer.parseInt(ar[2].trim());
                        int four = Integer.parseInt(ar[3].trim());
                        int five = Integer.parseInt(ar[4].trim());
                        int six = Integer.parseInt(ar[5].trim());
                        String seven = ar[6].trim();
                        String eight = ar[7].trim();
         
                            stmt.executeUpdate("INSERT INTO MOVELIST (moveID, name, typeID, power, accuracy, pp, classification, effect) VALUES"
                        + " (" + one + ", '" + two + "', "  + three + ", " + four + ", " + five + ", " + six + ", '" + seven + "', '" + eight + "')"); 
                    } //loop while file has more data
                    
                    int counter = 0;
                    int counter1 = 1000;
                    while(scanLevelUpMoveSets.hasNext())
                    {   //read in each line of the text file
                        String tempA = scanLevelUpMoveSets.nextLine();
                        String [] ar = tempA.split(",");
                        counter1++;
                        String one = ar[0].trim();
                        String two = ar[1].trim();
                        String three = ar[2].trim();
                        String four = ar[3].trim();
                        String five = ar[4].trim();
                        String six = ar[5].trim();
                        String seven = ar[6].trim();
                        String eight = ar[7].trim();
                        String nine = ar[8].trim();
                        String ten = ar[9].trim();
                        String eleven = ar[10].trim();
                        String twelve = ar[11].trim();
                        String thirteen = ar[12].trim();
                        String fourteen = ar[13].trim();
                        String fifteen = ar[14].trim();
                        String sixteen = ar[15].trim();
                        String seventeen = ar[16].trim();
                        String eighteen = ar[17].trim();
                        String nineteen = ar[18].trim();
                        String twenty = ar[19].trim();
                        String twentyOne = ar[20].trim();
                        String twentyTwo = ar[21].trim();
                        String twentyThree = ar[22].trim();
                        String twentyFour = ar[23].trim();
                        String twentyFive = ar[24].trim();
                        String twentySix = ar[25].trim();
                        System.out.println(counter1);
                        stmt.executeUpdate("INSERT INTO LEVELMOVES (pkmnID, move1, move2, move3, move4, move5"
                        + ",  move6,  move7,  move8,  move9, move10, move11, move12, move13, move14,  move15"
                        + ",  move16, move17, move18, move19, move20, move21, move22, move23, move24, move25) VALUES"
                        + " ('" + one + "', '"+ two  + "', '" + three  + "', '"+ four  + "', '"+ five  + "', '"+ six  + "', '"
                        + ""+ seven  + "', '"+ eight  + "', '"+ nine  + "', '"+ ten  + "', '"+  eleven + "', '"+ twelve  + "', '"
                        + ""+ thirteen  + "', '"+ fourteen  + "', '"+ fifteen  + "', '"+ sixteen  + "', '"+ seventeen  + "', '"+ eighteen  + "', '"
                        + ""+ nineteen  + "', '"+ twenty  + "', '"+  twentyOne + "', '"+  twentyTwo + "', '"+ twentyThree  + "', '"+ twentyFour  + "', '"
                        + "" + twentyFive+ "', '"+  twentySix + "')"); 
                    } //loop while file has more data
                    
                    
                    while(scanPokemonDeets.hasNext())
                    {
                        String one = "";
                        String two = "";
                        String three = "";
                        String four = "";
                        String five = "";
                        String six = "";
                        String seven = "";
                        String eight = "";
                        counter++;
                        //read in each line of the text file
                        String tempA = scanPokemonDeets.nextLine();
                        String [] ar = tempA.split(",");
                        
                        one = ar[0];
                        two = ar[1];
                        three = ar[2];
                        four = ar[3];
                        five = ar[4];
                        six = ar[5];
                        seven = ar[6];
                        eight = ar[7];
                        
                        one = one.trim();
                        two = two.trim();
                        three = three.trim();
                        four = four.trim();
                        five = five.trim();
                        six = six.trim();
                        seven = seven.trim();
                        eight = eight.trim();
                        
                        System.out.println(counter);
                        stmt.executeUpdate("INSERT INTO POKEMONDEETS (pkmnID, name, typeID1, typeID2, height, weight, "
                                + "eggType1, eggType2) VALUES"
                        + " ('" + one + "', '" + two + "', '" + three + "', '" + four + "', '" + five + "', '" + six + "', '" + seven + "', '" + eight + "')"); 
                    } //loop while file has more data
                    
                    //populate scanBaseStats with entries from text file
                    int counter2 = 2000;
                    while(scanBaseStats.hasNext())
                    {
                        counter2++;
                        //read in each line of the text file
                        String tempA = scanBaseStats.nextLine();
                        String [] ar = tempA.split(",");
                        
                        String one = ar[0].trim();
                        String two = ar[1].trim();
                        String three = ar[2].trim();
                        String four = ar[3].trim();
                        String five = ar[4].trim();
                        String six = ar[5].trim();
                        String seven = ar[6].trim();
                        
                        System.out.println(counter2);
                        stmt.executeUpdate("INSERT INTO BASESTATS (statsID, hp, attack, defense, spAttack, spDefense, speed) VALUES"
                        + " ('" + one + "', '"+ two + "', '" + three + "', '" + four + "', '" + five + "', '" + six + "', '" + seven + "')"); 
                    } //loop while file has more data
                    
                    //populate scanEggTypes with entries from text file

                }
                
                //catch in case the file cannot be found
                catch(FileNotFoundException fnf)
                {
                    System.out.println("File not found.");
                }
                
                //run the query, return a result set
                

                //Iterate through all result rows
                //while(rset.next())
                //{
                    
                        //records.add(rset.getString(1));
                        //records.add(rset.getString(2));
                //}
               /* while(rset.next())
                {
                    for(int i = 1; i < 8; i++)
                    {
                        tranData += rset.getString(i) + " ";
                        //System.out.println(tranData);
                    }
                    tranData += "<br/>";
                } */
            
                //clean up
                stmt.close();
                //rset.close();
                conn.close();
                return true;
                
        }
}
