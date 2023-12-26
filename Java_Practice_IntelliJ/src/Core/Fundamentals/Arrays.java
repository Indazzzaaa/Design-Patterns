package Core.Fundamentals;

public class Arrays {
    public static void show(){
        // array in Java always allocated on heap
        var arr = new int[10];
        System.out.println(java.util.Arrays.toString(arr));

        System.out.print("After filling array: ");
        java.util.Arrays.fill(arr,10);
        System.out.println(java.util.Arrays.toString(arr));


        var array2D = new int[10][10];
        System.out.println(java.util.Arrays.deepToString(array2D));

        System.out.print("After filling 2DArray: ");
        for(int i=0;i<array2D.length;i++){
            java.util.Arrays.fill(array2D[i],1);
        }
        System.out.println(java.util.Arrays.deepToString(array2D));

        System.out.printf("1D Length : %d , 2D Length : %d\n",arr.length,array2D.length);

        // won't work with var
        int[] array1DWithValue = {1,2,3,4,5};
        System.out.println(java.util.Arrays.toString(array1DWithValue));

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println(java.util.Arrays.deepToString(matrix));

    }


}
