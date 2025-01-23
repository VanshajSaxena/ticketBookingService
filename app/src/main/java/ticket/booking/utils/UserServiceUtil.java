package ticket.booking.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {

  public static boolean checkPassword(String plainPassword, String HashedPassword) {
    return BCrypt.checkpw(plainPassword, HashedPassword);
  }

  public static String hashPassword(String plainPassword) {
    return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
  }
}
