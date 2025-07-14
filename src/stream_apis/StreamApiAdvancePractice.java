package stream_apis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApiAdvancePractice {
    public static void main(String[] args) {

        List<UserActivity> userActivityData = getUserActivityData();
        // Find Top 5 most active users
        top5ActiveUsers(userActivityData);
        findUsersWhoLoggedInButNotLoggedout(userActivityData);

        System.out.println("All Unique user names are below!");
        findAllUniqueUsers(userActivityData);
        System.out.println("Count how many actions each user performed.");
        countActionPerUser(userActivityData);
        System.out.println("Find users who performed at least one CLICK action.");
        userWhoClickedOnce(userActivityData);
        System.out.println("List all activities sorted by timestamp.");
        listAllActivitiesSortedByTime(userActivityData);
        System.out.println("Group activities by action type.");
        groupActivitiesByActionType(userActivityData);
        // Intermediate Level
        System.out.println("Count how many users performed a LOGIN action on a specific day (e.g., 2025-05-21).");
        countNumberOfUsersLoggedInOnGivenDay(userActivityData);

        System.out.println("Find the user with the most activities");
        userWithMostActivities(userActivityData);

        System.out.println("Get the most recent activity for each user.");
        mostRecentActivityForEachUser(userActivityData);

        System.out.println("List users who logged in but also clicked during the same session (i.e., login before logout).");

        listUsersWithClickedAction(userActivityData);




    }

    private static void listUsersWithClickedAction(List<UserActivity> userActivityData) {
//        userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getUsername))
//                .entrySet().stream()
//                .filter(e ->
//                {
//
//                })
    }

    private static void mostRecentActivityForEachUser(List<UserActivity> userActivityData) {
        Map<String, Optional<UserActivity>> collect = userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getUsername, Collectors.maxBy(Comparator.comparing(UserActivity::getTimestamp))));
        System.out.println(collect);

    }

    private static void top5ActiveUsers(List<UserActivity> userActivityData) {
        Map<String, List<UserActivity>> userActivities = userActivityData.stream().
                collect(Collectors.groupingBy(
                        UserActivity::getUsername
                ));
        List<UserSummary> collect = userActivities.entrySet().stream()
                .map(entry -> {
                            String userName = entry.getKey();
                            int count = entry.getValue().size();
                            List<Action> list = entry.getValue().stream().map(UserActivity::getAction).toList();
                            LocalDateTime first = entry.getValue().stream().map(UserActivity::getTimestamp).min(LocalDateTime::compareTo).orElse(null);
                            LocalDateTime last = entry.getValue().stream().map(UserActivity::getTimestamp).max(LocalDateTime::compareTo).orElse(null);
                            return new UserSummary(userName, count, first, last, list);
                        }

                )
                .sorted(Comparator.comparingLong(UserSummary::getActionCount).reversed())
                .limit(5)
                .toList();
        System.out.println(collect);
    }

    private static void userWithMostActivities(List<UserActivity> userActivityData) {
        Optional<Map.Entry<String, Long>> max = userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getUsername, Collectors.counting())).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        System.out.println(max.get().getKey());
    }

    private static void countNumberOfUsersLoggedInOnGivenDay(List<UserActivity> userActivityData) {
        long count = userActivityData.stream().filter(e -> e.action == Action.LOGIN && Objects.equals(e.timestamp.toLocalDate(), LocalDate.of(2025, 5, 21
        ))).map(UserActivity::getUsername)
                        .distinct().count();
        System.out.println(count);
    }

    private static void groupActivitiesByActionType(List<UserActivity> userActivityData) {
        Map<Action, List<String>> collect = userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getAction, Collectors.mapping(UserActivity::getUsername, Collectors.toList())));
        System.out.println(collect);
    }

    private static void listAllActivitiesSortedByTime(List<UserActivity> userActivityData) {
        List<UserActivity> list = userActivityData.stream().sorted(Comparator.comparing(UserActivity::getTimestamp)).toList();
        list.stream().forEach(System.out::println);
    }

    private static void userWhoClickedOnce(List<UserActivity> userActivityData) {
        List<String> list = userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getUsername)).entrySet().stream()
                .filter(e -> e.getValue().stream().anyMatch(u -> u.action == Action.CLICK)).map(Map.Entry::getKey).toList();
        System.out.println(list);
    }

    private static void countActionPerUser(List<UserActivity> userActivityData) {
        Map<String, Long> collect = userActivityData.stream().collect(Collectors.groupingBy(UserActivity::getUsername, Collectors.counting()));
        System.out.println(collect);
    }

    private static void findAllUniqueUsers(List<UserActivity> userActivityData) {
        List<String> list = userActivityData.stream().map(UserActivity::getUsername).distinct().toList();
        System.out.println(list);
    }

    private static void findUsersWhoLoggedInButNotLoggedout(List<UserActivity> userActivityData) {

        Map<String, List<UserActivity>> userActivities = userActivityData.stream().
                collect(Collectors.groupingBy(
                        UserActivity::getUsername
                ));
        List<String> list = userActivities.entrySet().stream()
                .filter(data -> {
                    return data.getValue().stream().anyMatch(it -> it.action == Action.LOGIN) &&
                            data.getValue().stream().noneMatch(it -> it.action == Action.LOGOUT);
                }).map(Map.Entry::getKey).toList();
        System.out.println(list);
    }

    private static List<UserActivity> getUserActivityData() {
        List<UserActivity> activities = List.of(
                new UserActivity("alice", LocalDateTime.of(2025, 5, 20, 9, 0), Action.LOGIN),
                new UserActivity("alice", LocalDateTime.of(2025, 5, 20, 9, 5), Action.CLICK),
                new UserActivity("bob", LocalDateTime.of(2025, 5, 20, 10, 0), Action.LOGIN),
                new UserActivity("bob", LocalDateTime.of(2025, 5, 20, 10, 15), Action.SCROLL),
                new UserActivity("charlie", LocalDateTime.of(2025, 5, 20, 11, 30), Action.LOGIN),
                new UserActivity("dave", LocalDateTime.of(2025, 5, 21, 14, 10), Action.CLICK),
                new UserActivity("eve", LocalDateTime.of(2025, 5, 21, 14, 12), Action.SCROLL),
                new UserActivity("frank", LocalDateTime.of(2025, 5, 21, 15, 0), Action.LOGIN),
                new UserActivity("alice", LocalDateTime.of(2025, 5, 21, 15, 5), Action.SCROLL),
                new UserActivity("bob", LocalDateTime.of(2025, 5, 21, 15, 10), Action.CLICK),
                new UserActivity("charlie", LocalDateTime.of(2025, 5, 21, 15, 15), Action.LOGOUT),
                new UserActivity("dave", LocalDateTime.of(2025, 5, 21, 15, 20), Action.SCROLL),
                new UserActivity("eve", LocalDateTime.of(2025, 5, 21, 15, 25), Action.CLICK),
                new UserActivity("george", LocalDateTime.of(2025, 5, 21, 15, 30), Action.LOGIN),
                new UserActivity("harry", LocalDateTime.of(2025, 5, 21, 15, 35), Action.SCROLL),
                new UserActivity("isaac", LocalDateTime.of(2025, 5, 21, 15, 40), Action.CLICK),
                new UserActivity("jenny", LocalDateTime.of(2025, 5, 21, 15, 45), Action.LOGOUT),
                new UserActivity("frank", LocalDateTime.of(2025, 5, 21, 16, 0), Action.CLICK),
                new UserActivity("alice", LocalDateTime.of(2025, 5, 21, 16, 5), Action.LOGOUT),
                new UserActivity("bob", LocalDateTime.of(2025, 5, 21, 16, 10), Action.LOGOUT)
        );
        return activities;
    }

}
