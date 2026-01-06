package Ex03;

import java.util.Random;

public class UserSessionManager {

    private static UserSessionManager instance;

    private int sessionToken;
    private String lastAccess;

    private UserSessionManager(int sessionToken, String lastAccess) {
        this.sessionToken = sessionToken;
        this.lastAccess = lastAccess;
    }

    public int getSessionToken() {
        return sessionToken;
    }

    public String getLastAccess() {
        return lastAccess;
    }


    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    private static int randomToken(){
        Random random = new Random();
        return random.nextInt(1500);
    }

    public static void updateLastAccess(UserSessionManager sessionManager){
        Long updatedTime = System.currentTimeMillis();
        sessionManager.setLastAccess(String.valueOf(updatedTime));
    }

    public static UserSessionManager getInstance(int sessionToken, String lastAccess){
        sessionToken = randomToken();
        lastAccess = String.valueOf(System.currentTimeMillis());

        if (instance == null) {
            instance = new UserSessionManager(sessionToken, lastAccess);
        }
        return instance;
    }
}

