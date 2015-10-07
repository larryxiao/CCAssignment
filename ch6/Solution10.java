/*********************************************************************************
*     File Name           :     Solution10.java
*     Created By          :     larryxiao
*     Creation Date       :     [2015-10-07 19:13]
*     Last Modified       :     [2015-10-07 19:22]
*     Description         :     Poison  
**********************************************************************************/

public class Solution10
{
    static int interpretResult(String pattern) {
        return Integer.parseInt(pattern, 2);
    }
    
    public static void main (String [] args)
    {
        String result = "0010001001";  // the 137th soda
        System.out.println(interpretResult(result));

    }
}

