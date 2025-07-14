package dsa;

public class AlignBuildings {
    public static void main(String[] args) {
        int[] input = new int[] {6,3,7,6,4,1};
        int ascStart = 0;
        for (int i = 0; i < input.length; i++) {
            ascStart = Math.max(ascStart, input[i] - i);
        }
        int ascOps = 0;
        for (int i = 0; i < input.length; i++) {
            int target = ascStart + i;
            ascOps+= target - input[i];
        }
        int descStart = 0;
        for (int i = 0; i < input.length; i++) {
            descStart = Math.max(descStart , input[i] + i);
        }
        int descOps = 0;
        for (int i = 0; i <input.length; i++) {
            int target = descStart - i;
            descOps+=target - input[i];
        }
        System.out.println(Math.min(ascOps, descOps));
//        int index = findIndexOfMaximum(input);
//        int count = 0;
//        //traverse to left..
//        for (int i = index; i > 0; i--) {
//            int temp = (input[i] - input[i - 1]);
//            if(temp != 1) {
//                input[i - 1] =  input[i - 1] + temp - 1;
//                count+=temp - 1;
//            }
//        }
//        //traverse to right..
//        for (int i = index; i < input.length -1 ; i++) {
//            if(input[i] < input[i+1]) {
//
//            } else {
//                int temp = (input[i] - input[i + 1]);
//                if (temp != 1) {
//                    input[i + 1] = input[i + 1] + temp - 1;
//                    count += temp - 1;
//                }
//            }
//        }
//        System.out.println(count);
    }

    private static int findIndexOfMaximum(int[] input) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if(max < input[i]) {
                index = i;
                max = input[i];
            }
        }
        return index;
    }
}
