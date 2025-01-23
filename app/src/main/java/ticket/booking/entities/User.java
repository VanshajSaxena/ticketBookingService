package ticket.booking.entities;

import java.util.List;

public class User {
  private String name;
  private String userId;
  private String password;
  private String hashedPass;
  private List<Ticket> ticketsBooked;

  /**
   * @param name
   * @param userId
   * @param password
   * @param hashedPass
   * @param tickets
   */
  public User(String name, String userId, String password, String hashedPass, List<Ticket> tickets) {
    this.name = name;
    this.userId = userId;
    this.password = password;
    this.hashedPass = hashedPass;
    this.ticketsBooked = tickets;
  }

  public User() {

  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return the hashedPass
   */
  public String getHashedPass() {
    return hashedPass;
  }

  /**
   * @return the tickets
   */
  public List<Ticket> getTicketsBooked() {
    return ticketsBooked;
  }

  /**
   * Prints user tickets
   */
  public void printTickets() {
    for (Ticket ticket : ticketsBooked) {
      ticket.getTicketInfo();
    }
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @param hashedPass the hashedPass to set
   */
  public void setHashedPass(String hashedPass) {
    this.hashedPass = hashedPass;
  }

  /**
   * @param ticketsBooked the ticketsBooked to set
   */
  public void setTicketsBooked(List<Ticket> ticketsBooked) {
    this.ticketsBooked = ticketsBooked;
  }
}
