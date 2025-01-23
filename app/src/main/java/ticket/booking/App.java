package ticket.booking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.utils.UserServiceUtil;

public class App {
  static Scanner scanner = new Scanner(System.in);
  static UserBookingService userBookingService;

  public static void main(String[] args) {
    System.out.println("Service Starting...");
    System.out.println("Working directory: " + new File(".").getAbsolutePath());

    int option = 0;

    try {
      userBookingService = new UserBookingService();
    } catch (Exception e) {
      System.out.println("There is something wrong.\nERROR: " + e.getLocalizedMessage());
      return;
    }

    while (option != 6) {
      printOptions();
      option = Integer.parseInt(scanner.nextLine());
      switch (option) {
        case 1:
          signUp();
          break;
        case 2:
          logIn();
          break;
        case 3:
          userBookingService.fetchBookings();
          break;
        case 4:
          searchTrains();
          break;
        case 5:
          cancelBooking();
          break;
        default:
          System.out.println("Please enter valid no.");
          break;
      }
    }
  }

  private static void cancelBooking() {
    String ticketId = scanner.nextLine();
    userBookingService.cancelBooking(ticketId);
  }

  private static void searchTrains() {
    System.out.println("Source station: ");
    String source = scanner.nextLine();
    System.out.println("Destination station: ");
    String dest = scanner.nextLine();
    List<Train> trains = userBookingService.getTrains(source, dest);
    for (Train train : trains) {
      train.printTrainInfo();
    }
  }

  private static void logIn() {
    System.out.print("Enter the username to LogIn: ");
    String nameToLogIn = scanner.nextLine();
    System.out.print("Enter the password to LogIn: ");
    String plainPassword = scanner.nextLine();
    User newUser = new User(nameToLogIn,
        UUID.randomUUID().toString(),
        plainPassword,
        UserServiceUtil.hashPassword(plainPassword),
        new ArrayList<>());
    try {
      userBookingService = new UserBookingService(newUser);
    } catch (IOException e) {
      return;
    }
  }

  private static void signUp() {
    System.out.print("Enter the username to SignUp: ");
    String nameToSignUp = scanner.nextLine();
    System.out.print("Enter the password to SignUp: ");
    String plainPassword = scanner.nextLine();
    User newUser = new User(nameToSignUp,
        UUID.randomUUID().toString(),
        plainPassword,
        UserServiceUtil.hashPassword(plainPassword),
        new ArrayList<>());
    userBookingService.signUpUser(newUser);
  }

  private static void printOptions() {
    System.out.println("Choose option: ");
    System.out.println("1. Sign Up");
    System.out.println("2. Log In");
    System.out.println("3. Fetch Bookings");
    System.out.println("4. Search Trains");
    System.out.println("5. Cancel My Booking");
    System.out.println("6. Exit");
  }

}
