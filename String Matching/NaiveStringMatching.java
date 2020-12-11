//the naive string matching program!!

import java.util.Scanner;

public class NaiveStringMatching {

    public static void main(String[] args) {
       Scanner in = new Scanner (System.in); 
       System.out.println("Enter the String : ");
       String str = in.nextLine();
       
       System.out.println("Enter the pattern you want to Search:");
       String P = in.nextLine();
       
     
      int s,j;
      char m[] = str.toCharArray();
      char p[] = P.toCharArray(); 
       
      Integer limit = m.length - p.length;
      
         
           for (s = 0 ; s <= limit ; s++)
           {
                for (j = 0 ; j < p.length ; j++)
                    {
                     if (p[j] != m[s+j])
                        {break;} 
                    }
                    
            if (j == p.length )
               { 
                System.out.println("Pattern found at shift: " + s );
               }
            }
        }
    }
