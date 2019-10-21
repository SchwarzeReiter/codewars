package codewars_6kyu;

/*
Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.
 */

public class CamelCaseMethod {

    public static String camelCase(String str) {
        // your code here
        String[] strArray = str.split(" ");
        StringBuilder answer= new StringBuilder();
        for(String s : strArray)
        {

            if(!s.equals("")){
                answer.append(Character.toUpperCase(s.charAt(0)) + s.substring(1));
            }


        }

        return answer.toString();
    }

}
