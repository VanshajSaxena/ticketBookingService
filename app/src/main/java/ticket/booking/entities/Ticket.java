package ticket.booking.entities;

public class Ticket {
  private String ticketId;
  private String userId;
  private String source;
  private String destination;
  private String dateOfTravel;
  private Train train;

  /**
   * @param ticketId
   * @param userId
   * @param source
   * @param destination
   * @param dateOfTravel
   * @param train
   */
  public Ticket(String ticketId, String userId, String source, String destination, String dateOfTravel, Train train) {
    this.ticketId = ticketId;
    this.userId = userId;
    this.source = source;
    this.destination = destination;
    this.dateOfTravel = dateOfTravel;
    this.train = train;
  }

  public Ticket() {

  }

  /**
   * @return the ticketId
   */
  public String getTicketId() {
    return ticketId;
  }

  /**
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * @return the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * @return the dateOfTravel
   */
  public String getDateOfTravel() {
    return dateOfTravel;
  }

  /**
   * @return the train
   */
  public Train getTrain() {
    return train;
  }

  /**
   * Prints ticket info to stdout
   */
  public void getTicketInfo() {
    System.out.printf("The ticket ID is: %s, for user ID: %s, from source: %s, to destination: %s, at time: %s",
        ticketId, userId, source, destination, dateOfTravel);
  }
}
