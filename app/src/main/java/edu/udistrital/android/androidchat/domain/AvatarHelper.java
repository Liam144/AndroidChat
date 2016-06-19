package edu.udistrital.android.androidchat.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*http://www.kospol.gr/204/create-md5-hashes-in-android/
 *s=72 tamaño de la imagen
 * Created by ASUS on 18/06/2016.
 */
public class AvatarHelper {

    private final static String GRAVATAR_URL = "https://www.gravatar.com/avatar/";

    public static String getAvatarUrl(String email){
    return GRAVATAR_URL + md5(email) + "?s=72";
    }

    public static final String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
