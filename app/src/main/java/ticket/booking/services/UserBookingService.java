package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.utils.UserServiceUtil;

public class UserBookingService {

  private static final String USER_PATH = "app/src/main/java/ticket/booking/localDB/users.json";

  private User user;
  private List<User> userList;

  private ObjectMapper objectMapper = new ObjectMapper();

  public UserBookingService(User user) throws IOException {
    this.user = user;
    getUsers();
  }

  public UserBookingService() throws IOException {
    getUsers();
  }

  public Boolean loginUser() {
    Optional<User> foundUser = userList.stream()
        .filter(u -> u.getName().equals(user.getName())
            && UserServiceUtil.checkPassword(user.getPassword(), u.getHashedPass()))
        .findFirst();
    return foundUser.isPresent();
  }

  public Boolean signUpUser(User user) {
    try {
      userList.add(user);
      saveUserToLocalDB();
      return Boolean.TRUE;
    } catch (IOException e) {
      return Boolean.FALSE;
    }
  }

  public void fetchBookings() {
    if (user.getTicketsBooked().size() == 0) {
      System.out.println("There are no bookings currently...");
      return;
    }
    user.printTickets();
  }

  public Boolean cancelBooking(String tickedId) {
    List<Ticket> ticketBooked = user.getTicketsBooked();
    for (Ticket ticket : ticketBooked) {
      if (ticket.getTicketId().equals(tickedId)) {
        try {
          ticketBooked.remove(ticket);
          user.setTicketsBooked(ticketBooked);
          saveUserToLocalDB();
          return Boolean.TRUE;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return Boolean.FALSE;
  }

  private void getUsers() throws IOException {
    File users = new File(USER_PATH);
    this.userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
    });
  }

  private void saveUserToLocalDB() throws IOException {
    File file = new File(USER_PATH);
    objectMapper.writeValue(file, userList);
  }

  public List<Train> getTrains(String source, String dest) {
    List<Train> trains = user.getTicketsBooked().stream().map(ticket -> ticket.getTrain()).collect(Collectors.toList());
    return trains;
  }

}
