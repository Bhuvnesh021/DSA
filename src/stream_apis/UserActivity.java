package stream_apis;

import java.time.LocalDateTime;

class UserActivity {
    String username;
    LocalDateTime timestamp;
    Action action;

    @Override
    public String toString() {
        return username + " - " + action + " at " + timestamp;
    }
    public UserActivity(String username, LocalDateTime timestamp, Action action) {
        this.username = username;
        this.timestamp = timestamp;
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}