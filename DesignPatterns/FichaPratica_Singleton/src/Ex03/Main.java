package Ex03;

public class Main {
    public static void main(String[] args) {
        UserSessionManager sessionManager = UserSessionManager.getInstance(0,"0");

        System.out.println("Token de Acesso: " + sessionManager.getSessionToken());
        System.out.println("Último Acesso: " + sessionManager.getLastAccess());

        sessionManager.updateLastAccess(sessionManager);

        System.out.println("---------------------");

        System.out.println("Token de Acesso: " + sessionManager.getSessionToken());
        System.out.println("Último Acesso: " + sessionManager.getLastAccess());

    }
}

