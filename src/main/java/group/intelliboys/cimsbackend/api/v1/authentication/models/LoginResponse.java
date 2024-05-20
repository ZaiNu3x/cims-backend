package group.intelliboys.cimsbackend.api.v1.authentication.models;

public class LoginResponse {
    private final String token;
    private final String message;

    public LoginResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
