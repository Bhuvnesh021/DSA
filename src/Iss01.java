import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iss01 {
    public static void main(String[] args) {
            int[] array = new int[]{-1,0,1,2,-1,4};
        Arrays.sort(array);
        List<Integer[]> result = new CopyOnWriteArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int i1 = i + 1; i1 < array.length; i1++) {
                for (int j = i1 +1; j < array.length; j++) {
                    if(array[i] + array[i1] + array[j] == 0) {
                        Integer[] sum = new Integer[]{array[i], array[i1], array[j]};
                        if(result.isEmpty()) result.add(sum);
                       else if(!checkExistance(result, sum)) result.add(sum);
                    }
                }
            }
        }
        for (Integer[] integers : result) {
            System.out.println(Arrays.toString(integers));
        }
    }
    private static boolean checkExistance(List<Integer[]> result, Integer[] sum) {
        for (Integer[] integers : result) {
            if(Arrays.equals(integers, sum)){
                return true;
            }
        }
        return false;
    }
}