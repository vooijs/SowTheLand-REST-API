package nl.novi.sowtheland.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.spel.spi.Function;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final static String  SECRET_KEY = "klaasvooijsklaasvooijsklaasvooijsklaasvooijsklaasvooijsklaasvooijs";
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String extractUsername (String token) {
      return extractClaim(token);
    }

    private <T> T extractClaim(String token, Function <Claims, T> claimsResolver) {

    }

    public Date extractExperation(String token) {
        return extractClaim(token);
    }


}
