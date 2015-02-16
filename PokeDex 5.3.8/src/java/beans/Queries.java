/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tom.Cocozzello
 */
public class Queries 
{
    private String query = "";
    private int transferItems = -1;
    private ArrayList transferArray = new ArrayList();
    
    //private ArrayList transferArray = new ArrayList();
    public ArrayList queries(String TextBoxEntry, int transferNumber)throws SQLException, ClassNotFoundException
    {
        
        
        //ArrayList transferArray = new ArrayList();

        String tranData = "";
        
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
        //Remembe r to change username and password
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db1.chpc.ndsu.nodak.edu:1521:cs", 
            "cocozzel", "Aug641992");// "jordaste", "Oct771992");

        //Create a statement and a query, execute the query
        Statement stmt = conn.createStatement();
          
         if(transferNumber == 1)
             transNumber1(TextBoxEntry);
        else if(transferNumber == 2)
             transNumber2(TextBoxEntry);
        else if(transferNumber == 3)
             transNumber3(TextBoxEntry);
        else if(transferNumber == 4)
             transNumber4(TextBoxEntry);
        else if(transferNumber == 5)
             transNumber5(TextBoxEntry);
        else if(transferNumber == 6)
             transNumber6(TextBoxEntry);
        else if(transferNumber == 7)
             transNumber7(TextBoxEntry);
        else if(transferNumber == 8)
             transNumber8(TextBoxEntry);
        else if(transferNumber == 9)
             transNumber9(TextBoxEntry);
        else if(transferNumber == 10)
             transNumber10(TextBoxEntry);
        else if(transferNumber == 11)
             transNumber11(TextBoxEntry);
        else if(transferNumber == 12)
             transNumber12(TextBoxEntry);
        //here i am going make query methods and return the query to records then pass them back to tableData
          
        /*
        if(transferItems2 != -1)
        {
            TableData td = new TableData();
            rset2 = stmt.executeQuery(query2);  
            if(transferArray2.isEmpty())
                transferArray2.add((transferItems2 - 1));
            
            while(rset2.next())
            for(int i = 1; i < transferItems2; i++)
            { 
                transferArray2.add(rset2.getString(i));
            }
           //td.setReturnQueryString2(transferArray2);
            
            rset2.close();
        }*/
        
        ResultSet rset = stmt.executeQuery(query);
        transferArray.clear();
        
        if(transferArray.isEmpty())
            transferArray.add((transferItems - 1));
        
        if(transferNumber == 1)
             transNumberHeader1();
        else if(transferNumber == 2)
             transNumberHeader2();
        else if(transferNumber == 3)
             transNumberHeader3();
        else if(transferNumber == 4)
             transNumberHeader4();
        else if(transferNumber == 5)
             transNumberHeader5();
        else if(transferNumber == 6)
             transNumberHeader6();
        else if(transferNumber == 7)
             transNumberHeader7();
        else if(transferNumber == 8)
             transNumberHeader8();
        else if(transferNumber == 9)
             transNumberHeader9();
        else if(transferNumber == 10)
             transNumberHeader10();
        else if(transferNumber == 11)
             transNumberHeader11();
        else if(transferNumber == 12)
             transNumberHeader12();
        transferNumber = 0;
        while(rset.next())
            for(int i = 1; i < transferItems; i++)
            { 
                transferArray.add(rset.getString(i));
            }
        stmt.close();
        conn.close();
        rset.close();
        
        return transferArray;
  }
    
    //move name
  public void transNumberHeader1()
  {
      
      transferArray.add("Move Name");
      transferArray.add("Type");
      transferArray.add("Base Power");
      transferArray.add("PP");
      transferArray.add("Accuracy");
      transferArray.add("Classification"); 
      transferArray.add("Effect");
      
  }
  public void transNumber1(String transData)
  { 
      transNumberHeader1();
      transferItems = 8;    
      query = "SELECT m.Name, t.name, m.power, m.accuracy, m.pp, m.classification, m.effect FROM MOVELIST m, TYPES t WHERE t.typeID = m.typeID AND m.name = '"+transData+"'";
  }
  
  public void transNumberHeader2()
  {
      transferArray.add("Move Name");
      transferArray.add("Type");
      transferArray.add("Power");
      transferArray.add("Accuracy");
      transferArray.add("PP");
      transferArray.add("Classification");
      transferArray.add("Effect");

  }
  //move type
  public void transNumber2(String transData)
  { 
      transferItems = 8;   
      query = "SELECT m.name, t.name, m.power, m.accuracy, m.pp, m.classification, m.effect FROM MOVELIST m, TYPES t WHERE m.typeID = t.typeID AND t.name = '"+transData+"' ORDER BY m.name";
  }
  
   public void transNumberHeader3()
  {
     
      transferArray.add("Pokemon Name");
  }
  public void transNumber3(String transData)
  { 
      transferItems = 2;   
      query = "SELECT p.name FROM POKEMONDEETS p, EGGTYPES e WHERE (p.eggType1 = e.eggID OR p.eggType2 = e.eggID) AND e.eggName = '" + transData + "' ORDER BY p.name";
  }
  
   public void transNumberHeader4()
  {
     
      transferArray.add("Pokemon Name");
      transferArray.add("Weight (kg)");
  }
  public void transNumber4(String transData)
  { 
      transferItems = 3;   
      query = "SELECT p.name, p.weight FROM POKEMONDEETS p WHERE p.weight >= " + transData + " ORDER BY p.weight";
  }
  
   public void transNumberHeader5()
  {
      
      transferArray.add("Pokemon Name");
      transferArray.add("Weight (Kg)");

  }
  public void transNumber5(String transData)
  { 
      transferItems = 3;   
      query = "SELECT p.name, p.weight FROM POKEMONDEETS p WHERE p.weight <= " + transData + " ORDER BY p.weight";
  }
  
   public void transNumberHeader6()
  {
      
      transferArray.add("Pokemon Name");
      transferArray.add("Height (m)");
  }
  public void transNumber6(String transData)
  { 
      transferItems = 3;   
      query = "SELECT p.name, p.height FROM POKEMONDEETS p WHERE p.height >= " + transData + " ORDER BY p.height";
  }
  
   public void transNumberHeader7()
  {

      transferArray.add("Pokemon Name");
      transferArray.add("Height (m)");
  }
  public void transNumber7(String transData)
  { 
      transferItems = 3;   
      query = "SELECT p.name, p.height FROM POKEMONDEETS p WHERE p.height <= " + transData + " ORDER BY p.height";
  }
  
  
   public void transNumberHeader8()
  {
      transferArray.add("Pokemon Name");
      transferArray.add("Type");
      transferArray.add("Type 2");
      transferArray.add("Egg Type");
      transferArray.add("Egg Type 2");

  }
  public void transNumber8(String transData)
  { 
      transferItems = 6;   
      query = "SELECT p.name, t.name, y.name, e.eggName, f.eggName FROM LEVELMOVES l, POKEMONDEETS p, TYPES t, TYPES y, EGGTYPES e, EGGTYPES f WHERE ((l.move1 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move2 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move3 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move4 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move5 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move6 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move7 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move8 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move9 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move10 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move11 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move12 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move13 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move14 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move15 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move16 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move17 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move18 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move19 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move20 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move21 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move22 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move23 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move24 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"')) OR (l.move25 = (SELECT moveID FROM MOVELIST WHERE name = '"+transData+"'))) AND p.pkmnID = l.pkmnID AND p.typeID1 = t.typeID AND p.typeID2 = y.typeID AND p.eggType1 = e.eggID AND p.eggType2 = f.eggID ORDER BY p.name";
  }
  
   public void transNumberHeader9()
  {
      transferArray.add("Pokemon Name");
      transferArray.add("Height (m)");
      transferArray.add("Weight (Kg)");
      transferArray.add("Type");
      transferArray.add("Type 2");
      transferArray.add("Egg Type");
      transferArray.add("Egg Type 2");
  }
  public void transNumber9(String transData)
  { 
      transferItems = 8;   
      query = "SELECT p.name, p.height, p.weight, t.name, y.name, e.eggName, f.eggName FROM POKEMONDEETS p, EGGTYPES e, EGGTYPES f, TYPES t, TYPES y WHERE p.typeID1 = t.typeID AND p.typeID2 = y.typeID AND p.eggType1 = e.eggID AND p.eggType2 = f.eggID AND p.name = '"+transData+"'";
  }
  
   public void transNumberHeader10()
  {
      transferArray.add("Pokemon Name");
      transferArray.add("Type");
      transferArray.add("Type 2");
  }
  public void transNumber10(String transData)
  { 
      transferItems = 4;   
      query = "SELECT p.name, t.name, y.name FROM POKEMONDEETS p, TYPES t, TYPES y WHERE (p.typeID1 = t.typeID AND p.typeID2 = y.typeID) AND (t.name = '"+transData+"' OR y.name = '"+transData+"') ORDER BY p.name";
  }
  
   public void transNumberHeader11()
  {
      
      transferArray.add("HP");
      transferArray.add("Attack");
      transferArray.add("Defense");
      transferArray.add("Special Attack");
      transferArray.add("Special Defense");
      transferArray.add("Speed");
    
  }
  public void transNumber11(String transData)
  { 
      transferItems = 7;   
      query = "SELECT b.hp, b.attack, b.defense, b.spAttack, b.spDefense, b.speed FROM BASESTATS b, POKEMONDEETS p WHERE p.pkmnID = b.statsID AND p.name = '"+transData+"'";
  }
  
   public void transNumberHeader12()
  {
      
      transferArray.add("Move 1");
      transferArray.add("Move 2");
      transferArray.add("Move 3");
      transferArray.add("Move 4");
      transferArray.add("Move 5");
      transferArray.add("Move 6");
      transferArray.add("Move 7");
      transferArray.add("Move 8");
      transferArray.add("Move 9");
      transferArray.add("Move 10");
      transferArray.add("Move 11");
      transferArray.add("Move 12");
      transferArray.add("Move 13");
      transferArray.add("Move 14");
      transferArray.add("Move 15");
      transferArray.add("Move 6");
      transferArray.add("Move 17");
      transferArray.add("Move 18");
      transferArray.add("Move 19");
      transferArray.add("Move 20");
      transferArray.add("Move 21");
      transferArray.add("Move 22");
      transferArray.add("Move 23");
      transferArray.add("Move 24");
      transferArray.add("Move 25");
      

  }
  public void transNumber12(String transData)
  { 
      transferItems = 26;   
      query = "SELECT m1.name, m2.name, m3.name, m4.name, m5.name, m6.name, m7.name, m8.name, m9.name, m10.name, m11.name, m12.name, m13.name, m14.name, m15.name, m16.name, m17.name, m18.name, m19.name, m20.name, m21.name, m22.name, m23.name, m24.name, m25.name FROM POKEMONDEETS p, LEVELMOVES l1, MOVELIST m1, MOVELIST m2, MOVELIST m3, MOVELIST m4, MOVELIST m5, MOVELIST m6, MOVELIST m7, MOVELIST m8, MOVELIST m9, MOVELIST m10, MOVELIST m11, MOVELIST m12, MOVELIST m13, MOVELIST m14, MOVELIST m15, MOVELIST m16, MOVELIST m17, MOVELIST m18, MOVELIST m19, MOVELIST m20, MOVELIST m21, MOVELIST m22, MOVELIST m23, MOVELIST m24, MOVELIST m25 WHERE p.pkmnID = l1.pkmnID AND l1.move1 = m1.moveID AND l1.move2 = m2.moveID AND l1.move3 = m3.moveID AND l1.move4 = m4.moveID AND l1.move5 = m5.moveID AND l1.move6 = m6.moveID AND l1.move7 = m7.moveID AND l1.move8 = m8.moveID AND l1.move9 = m9.moveID AND l1.move10 = m10.moveID AND l1.move11 = m11.moveID AND l1.move12 = m12.moveID AND l1.move13 = m13.moveID AND l1.move14 = m14.moveID AND l1.move15 = m15.moveID AND l1.move16 = m16.moveID AND l1.move17 = m17.moveID AND l1.move18 = m18.moveID AND l1.move19 = m19.moveID AND l1.move20 = m20.moveID AND l1.move21 = m21.moveID AND l1.move22 = m22.moveID AND l1.move23 = m23.moveID AND l1.move24 = m24.moveID AND l1.move25 = m25.moveID AND p.name = '"+transData+"'";
  }
}
