

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head><style>
        #background {
            position: fixed;
            top: 0;
            left: 0;
            z-index: 0;
            width: 100%;
            height: 100%;
        }
        #background img{
            width: 100%;
            height: 100%;
        }
        #tables {
            z-index: 1;
            position: absolute;
            top: 3%;
            left: 3%;
        }
    </style>
</head>
<jsp:useBean id="beans" class="beans.TableData" scope="session"/> 
<jsp:setProperty name="beans" property="*"/> 

<html>
    
    <body>
        
        <div id='background' ><img src='pokemonD.jpg'/> </div>
        <div id='tables'>
        <A HREF="WelcomePage.html">Another Search</A> <BR>
        <%             
        ArrayList tempReturnQueryString;
        int sizeOfTable;
        tempReturnQueryString = beans.returnQueryString();
        
        
        int tempSize = (tempReturnQueryString.size() - 1);
        System.out.println("size       "+tempReturnQueryString.size());
        if(tempReturnQueryString.size() > 1)
        {
            sizeOfTable = Integer.parseInt(tempReturnQueryString.get(0).toString());
        }
        else
            sizeOfTable = 1;
        tempReturnQueryString.remove(0);
        
        
        out.println("<table bgcolor=\"White\" style= 'z-index: 1;' border=\"1\">");
        out.println("<tr>");
        for(int i = 0; i < tempSize; i++)
        {
            if(!tempReturnQueryString.get(i).equals("NULL"))
            {
                if(i>0 && i% sizeOfTable==0)
                  out.println("</tr><tr>");
                out.println("<td>" + tempReturnQueryString.get(i) + "</td>");
            }
            else
                out.println("<td>"+ "None" + "</td>");
        }

          out.println("</tr>");
          out.println("</table>");
          
        /*try
        {
            
          ArrayList tempReturnQueryString2 = beans.getReturnQueryString2();
          int temp2Size = tempReturnQueryString2.size();
          int sizeOfTable1 = Integer.parseInt(tempReturnQueryString2.get(0).toString());
          tempReturnQueryString2.remove(0);
          
          out.println("<table bgcolor=\"White\" border=\"1\">");
          out.println("<tr>");
          for(int i = 0; i < temp2Size; i++)
          {
              if(!tempReturnQueryString2.get(i).equals("NULL"))
              {
                if(i>0 && i% sizeOfTable1==0)
                  out.println("</tr><tr>");
                out.println("<td>" + tempReturnQueryString2.get(i) + "</td>");
              }
              else
                out.println("<td>"+ "None" + "</td>");
          }
          out.println("</tr>");
          out.println("</table>");
          
        }
        catch(Exception a)
        {
            
        }*/
                
        
        %>
        </div>
        <div>
    </body>
</html>






