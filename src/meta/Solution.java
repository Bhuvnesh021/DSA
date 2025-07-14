package meta;

import java.util.*;

class Solution {
  public static void main(String[] args) {
//    long maxAdditionalDinersCount = getMaxAdditionalDinersCount(10, 1, 2, List.of(2L, 6L));
//    System.out.println(maxAdditionalDinersCount);
//    long maxAdditionalDinersCount1 = getMaxAdditionalDinersCount(10, 1, 2, new long[]{2, 6});
//    System.out.println(maxAdditionalDinersCount1);
//    System.out.println(getArtisticPhotographCount(8, ".PBAAP.B", 1, 3));
    long minCodeEntryTime = getMinCodeEntryTime(6, 4, new int[]{4,4,4,1});
    System.out.println(minCodeEntryTime);
    // 1,2,3,4,5,6,7
    // 3,4,1
    // 3-1 = 2
    // 7 - 2 = 5

  }


  public static String getWrongAnswers(int N, String C) {
    // Write your code here
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : C.toCharArray()) {
      if(c == 'A') stringBuilder.append('B'); else stringBuilder.append('A');
    }
      return stringBuilder.toString();
  }
  public double getHitProbability(int R, int C, int[][] G) {
    // Write your code here
    int battleshipCounter = 0;
    for(int i = 0; i<G.length; i++) {
      for (int j = 0; j < G[i].length; j++) {
        if(G[i][j] == 1) battleshipCounter++;
      }
    }
      return (double) (R * C) / battleshipCounter;
  }
  private static long countNewDiners(long start, long end, long K) {
    if (start > end) return 0;
    long length = end - start + 1;
    return (length + K) / (K + 1); // every (K+1) seats, one diner can sit
  }
  public static long getMaxAdditionalDinersCount(long N, long K, int M, List<Long> S) {
//    Collections.sort(S);

    long count = 0;
    long prevBlockedEnd = 0;

    for (long seat : S) {
      long blockedStart = Math.max(1, seat - K);
      long blockedEnd = Math.min(N, seat + K);

      // Free space before this blocked area
      if (blockedStart > prevBlockedEnd + 1) {
        long freeStart = prevBlockedEnd + 1;
        long freeEnd = blockedStart - 1;
        count += countNewDiners(freeStart, freeEnd, K);
      }

      prevBlockedEnd = Math.max(prevBlockedEnd, blockedEnd);
    }

    // Free space after last blocked zone
    if (prevBlockedEnd < N) {
      count += countNewDiners(prevBlockedEnd + 1, N, K);
    }

    return count;
  }
  public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
    // Write your code here
    Arrays.sort(S);
    long count = 0;
    long previousBlockedEnd = 0;
    for (long l : S) {
      long start = Math.max(1, l - K);
      long end = Math.min(N, l + K);
      if(start > end + 1){
        start = end + 1;
        end = start -1 ;
        count +=countNewDiners(start, end, K);
      }
      previousBlockedEnd = Math.max(previousBlockedEnd, end);
    }
    if(previousBlockedEnd<N) {
      count+=countNewDiners(previousBlockedEnd+1 , N, K);
    }
    return count;
  }
  public static int countArtisticPhotos(int N, String C, int X, int Y) {
    int count = 0;

    // Loop through each character in the string
    for (int i = 0; i < N; i++) {
      // Only process if the current cell is an Actor ('A')
      if (C.charAt(i) == 'A') {

        // Case 1: Photographer on the left, Backdrop on the right
        for (int j = X; j <= Y; j++) {
          int photographerIndex = i - j;
          int backdropIndex = i + j;

          if (photographerIndex >= 0 && C.charAt(photographerIndex) == 'P') {
            if (backdropIndex < N && C.charAt(backdropIndex) == 'B') {
              count++;
            }
          }
        }

        // Case 2: Photographer on the right, Backdrop on the left
        for (int j = X; j <= Y; j++) {
          int photographerIndex = i + j;
          int backdropIndex = i - j;

          if (photographerIndex < N && C.charAt(photographerIndex) == 'P') {
            if (backdropIndex >= 0 && C.charAt(backdropIndex) == 'B') {
              count++;
            }
          }
        }
      }
    }

    return count;
  }
  public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
    // Write your code here
    char[] charArray = C.toCharArray();
    int counter = 0;
    for (int i = 0; i < charArray.length; i++) {
      if(charArray[i] != 'A') continue;

      // Let's scan the left index
      for (int j = X; j <= Y; j++) {
        if((i-j) >= 0 && charArray[i - j] == 'P') {
          // Let's Scan to right index for 'B'
          for (int k = X; k <= Y; k++) {
            if((i+k) <= charArray.length - 1 && charArray[i + k] == 'B') {
              counter++;
            }
          }
        }
        if((i+j) <= charArray.length - 1 && charArray[i + j] == 'P') {
          // Let's Scan to right index for 'B'
          for (int k = X; k <= Y; k++) {
            if((i-k) >= 0 && charArray[i - k] == 'B') {
              counter++;
            }
          }
        }
      }
    }
    return counter;
  }
  public int getMaximumEatenDishCount(int N, int[] D, int K) {

    // Write your code here

    Set<Integer> eaten = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    for (int i : D) {
      if(!eaten.contains(i)) {
        eaten.add(i);
        queue.add(i);
        count++;

        if(queue.size() > K) {
          Integer poll = queue.poll();
          eaten.remove(poll);
        }
      }
    }
    return count;
  }
  public static long getMinCodeEntryTime(int N, int M, int[] C) {
    // Write your code here
    int current = 1;
    int time = 0;
    for (int i = 0; i < C.length; i++) {
      int first = Math.abs(current - C[i]);
      int second = Math.abs(N - first);
      time+=Math.min(first,second);
      current = C[i];
    }
    return time;
  }
  private static String[][] addNewFloor(String[][] apartments, String[] newFloor) {
    String[][] buildingWithNewFloor = new String[apartments.length + 1][apartments[0].length];
    for (int apartments2 = 0; apartments2 < apartments.length; apartments2++) {
      buildingWithNewFloor[apartments2] = Arrays.copyOf(apartments[apartments2], apartments[apartments2].length);
    }
    buildingWithNewFloor[buildingWithNewFloor.length - 1] = newFloor;
    return buildingWithNewFloor;
  }
}