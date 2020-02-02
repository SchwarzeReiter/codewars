import java.util.List;
import java.util.ArrayList;

/*
Snail Sort
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */


public class Snail {

    public static int[] snail(int [][] array)
    {

        if(array[0].length==0){return new int[]{};};
        if(array.length == 1){ return from2DTo1Darray(array); }

        int x=0, y=0;

        List<Coordinates> base = new ArrayList<>();
        List <Integer> result = new ArrayList<>();

        int Steps = 1;
        while (true)
        {

            for(;x < array[0].length - Steps ;x++){ //Step right

                if(base.contains(new Coordinates(x,y))){return  ListToArray(result);}

                result.add(array[y][x]);
                base.add(new Coordinates(x,y));


            }

            for(;y < array.length - Steps ;y++){ //Step down

                if(base.contains(new Coordinates(x,y))){return  ListToArray(result);}

                result.add(array[y][x]);
                base.add(new Coordinates(x,y));

            }

            Steps--; //Step back

            for(; x > Steps; x--){ //Step left


                if(base.contains(new Coordinates(x,y))){return  ListToArray(result);}

                result.add(array[y][x]);
                base.add(new Coordinates(x,y));
            }

            Steps++; // Step forward

            for(;y != Steps;y--){  //Step up


                if(base.contains(new Coordinates(x,y))){return  ListToArray(result);}

                result.add(array[y][x]);
                base.add(new Coordinates(x,y));


            }
            Steps ++; // Step forward
        }

    }


    public static int[] ListToArray(List list)
    {
        int[] array =new int[list.size()];

        for(int i=0;i<list.size();i++)
        {
            array[i] = (int)list.get(i);
        }
        return array;
    }

    private static int[] from2DTo1Darray(int [][] matrix) {
        int countElem = 0;
        for (int [] tmpArr : matrix)
            countElem += tmpArr.length;
        int [] ret = new int[countElem];
        int indRet = 0;
        for (int [] tmpArr : matrix)
            for (int elemTmpArr : tmpArr)
                ret[indRet++] = elemTmpArr;
        return ret;
    }


    static class Coordinates
    {
        private int x;
        private int y;

        public Coordinates(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Coordinates)
            {
                if(((Coordinates) obj).x == this.x && ((Coordinates) obj).y == this.y )
                {
                    return true;
                }

                return false;
            }
            return false;
        }
    }
}