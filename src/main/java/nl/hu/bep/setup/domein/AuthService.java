package nl.hu.bep.setup.domein;


public interface AuthService {
    String authenticate(String username, String password);
    boolean validateToken(String token);
    UserDetails getUserDetailsFromToken(String token);
    void invalidateToken(String token);
}
