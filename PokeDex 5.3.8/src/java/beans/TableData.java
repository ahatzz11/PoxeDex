    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jordan Steffan, Alex Hatzenbuhler, Tom Cocozzello
 */
public class TableData 
{
    String classMoveType;
    String classMoveName;
    String classDisplayEggType;
    String classDisplayHeavierWeight;
    String classDisplayLighterWeight;
    String classDisplayTallerHeight;
    String classDisplaySmallerHeight;
    String classMoveLearnMove;
    String classDetailsNameDeets;
    String classDisplayPokemonType;
    String classDetailsNameBaseStats;
    String classDetailsNameMoveList;
    
    public void setClassMoveName(String value)
    {
        classMoveName  = value;
    }
    public void setClassMoveType(String value)
    {
        classMoveType  = value;
    }
    public void setClassDisplayEggType(String value)
    {
        classDisplayEggType  = value;
    }
    public void setClassDisplayHeavierWeight(String value)
    {
        classDisplayHeavierWeight  = value;
    }
    public void setClassDisplayLighterWeight(String value)
    {
        classDisplayLighterWeight  = value;
    }
    public void setClassDisplayTallerHeight(String value)
    {
        classDisplayTallerHeight  = value;
    }
    public void setClassDisplaySmallerHeight(String value)
    {
        classDisplaySmallerHeight  = value;
    }
    
    public void setClassMoveLearnMove(String value)
    {
        classMoveLearnMove  = value;
    }
    
    public void setClassDetailsNameDeets(String value)
    {
        classDetailsNameDeets  = value;
    }
    public void setClassDisplayPokemonType(String value)
    {
        classDisplayPokemonType  = value;
    }
    
    public void setClassDetailsNameBaseStats(String value)
    {
        classDetailsNameBaseStats  = value;
    }
    public void setClassDetailsNameMoveList(String value)
    {
        classDetailsNameMoveList  = value;
    }

    public ArrayList returnQueryString() throws SQLException, ClassNotFoundException
    {
        Queries tempDb = new Queries();
        
        ArrayList results = new ArrayList();
        
        
            if(classMoveName != null)
            {
                results = tempDb.queries(classMoveName, 1);
                classMoveName = null;
                return results;
            }
            else if(classMoveType != null)
            {
                results = tempDb.queries(classMoveType, 2);
                classMoveType = null;
                return results;
            }
            else if(classDisplayEggType != null)
            {
                results = tempDb.queries(classDisplayEggType, 3);
                classDisplayEggType = null;
                return results;
            }
            else if(classDisplayHeavierWeight != null)
            {
                results = tempDb.queries(classDisplayHeavierWeight, 4);
                classDisplayHeavierWeight = null;
                return results;
            }
            else if(classDisplayLighterWeight != null)
            {
                results = tempDb.queries(classDisplayLighterWeight, 5);
                classDisplayLighterWeight = null;
                return results;
            }
            else if(classDisplayTallerHeight != null)
            {
                results = tempDb.queries(classDisplayTallerHeight, 6);
                classDisplayTallerHeight = null;
                return results;
            }
            else if(classDisplaySmallerHeight != null)
            {
                results = tempDb.queries(classDisplaySmallerHeight, 7);
                classDisplaySmallerHeight = null;
                return results;
            }
            else if(classMoveLearnMove != null)
            {
                results = tempDb.queries(classMoveLearnMove, 8);
                classMoveLearnMove = null;
                return results;
            }
            else if(classDetailsNameDeets != null)
            {
                results = tempDb.queries(classDetailsNameDeets, 9);
                classDetailsNameDeets = null;
                return results;
            }
            else if(classDisplayPokemonType != null)
            {
                results = tempDb.queries(classDisplayPokemonType, 10);
                classDisplayPokemonType = null;
                return results;
            }
            else if(classDetailsNameBaseStats != null)
            {
                results = tempDb.queries(classDetailsNameBaseStats, 11);
                classDetailsNameBaseStats = null;
                return results;
            }
            else if(classDetailsNameMoveList != null)
            {
                results = tempDb.queries(classDetailsNameMoveList, 12);
                classDetailsNameMoveList = null;
                return results;
            }          
            else 
            {
                results.add("No Items Are Available");
                return results;
            }     
    }
  
}











