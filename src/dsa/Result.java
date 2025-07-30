package dsa;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     *  1 1 0
     *  1 1 0
     *  0 0 1
     */

    public static int countGroups(List<String> related) {
        // Write your code here
        int size = related.size();
        boolean[] visited = new boolean[size];
        int groups = 0;
        for (int i = 0; i < size; i++) {
            if(!visited[i]) {
                dfs(related, visited, i);
                groups++;
            }
        }
        return groups;
    }

    private static void dfs(List<String> related, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < related.size(); j++) {
            if(related.get(i).charAt(j)=='1' && !visited[j]) {
                dfs(related, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countGroups(Arrays.asList("110","110","001")));
        List<String> numberGroups = Arrays.asList(
                "274673668 451913864 507067818",
                "507336886 554316372 56172121",
                "56890051 615008389 76731002",
                "831696632 855293372 864250034"
        );
        List<String> strings = processLogs(numberGroups, 1);
        System.out.println(strings);
    }
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();

        for (String log : logs) {
            String[] array = log.split(" ");
            String senderUserId = array[0].trim();
            String receptientUserId = array[1].trim();
            map.put(senderUserId, map.getOrDefault(senderUserId, 0) + 1);
            if(!senderUserId.equals(receptientUserId)) {
                map.put(receptientUserId, map.getOrDefault(receptientUserId, 0) + 1);
            }
        }
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(threshold<= stringIntegerEntry.getValue()) {
                output.add(stringIntegerEntry.getKey());
            }
        }
        Collections.sort(output);
        return output;
    }

}
