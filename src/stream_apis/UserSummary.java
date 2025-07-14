package stream_apis;

import java.time.LocalDateTime;
import java.util.List;

class UserSummary {
            String username;
            long actionCount;
            LocalDateTime firstActivity;
            LocalDateTime lastActivity;
            List<Action> actionList;

    public UserSummary(String username, long actionCount, LocalDateTime firstActivity, LocalDateTime lastActivity, List<Action> actionList) {
        this.username = username;
        this.actionCount = actionCount;
        this.firstActivity = firstActivity;
        this.lastActivity = lastActivity;
        this.actionList = actionList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getActionCount() {
        return actionCount;
    }

    public void setActionCount(long actionCount) {
        this.actionCount = actionCount;
    }

    public LocalDateTime getFirstActivity() {
        return firstActivity;
    }

    public void setFirstActivity(LocalDateTime firstActivity) {
        this.firstActivity = firstActivity;
    }

    public LocalDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LocalDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    UserSummary(String username, long count, LocalDateTime first, LocalDateTime last) {
                this.username = username;
                this.actionCount = count;
                this.firstActivity = first;
                this.lastActivity = last;
            }

            @Override
            public String toString() {
                return String.format("%s | Actions: %d | First: %s | Last: %s | Actions: %s",
                        username, actionCount, firstActivity, lastActivity, actionList);
            }
        }