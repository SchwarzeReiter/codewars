package codewars_7kyu;

public class Is_this_a_triangle {

/*
Implement a method that accepts 3 integer values a, b, c. The method should return true if a triangle can be built with the sides of given length and false in any other case.

(In this case, all triangles must have surface greater than 0 to be accepted).
 */

    class TriangleTester{
        public  boolean isTriangle(int a, int b, int c){
            int  max = Math.max(Math.max(a,b),c);
            int sum = a+b+c;
            if((sum-max) <= max){return false;}
            return true;

        }
    }

}
