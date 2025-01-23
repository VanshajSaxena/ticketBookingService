package ticket.booking.entities;

import java.util.List;
import java.util.Map;

public class Train {
  private String trainId;
  private String trainNo;
  private List<List<Boolean>> seats;
  private Map<String, String> stationTimes;
  private List<String> stations;

  /**
   * @param trainId
   * @param trainNo
   * @param seats
   * @param stationTimes
   * @param stations
   */
  public Train(String trainId, String trainNo, List<List<Boolean>> seats, Map<String, String> stationTimes,
      List<String> stations) {
    this.trainId = trainId;
    this.trainNo = trainNo;
    this.seats = seats;
    this.stationTimes = stationTimes;
    this.stations = stations;
  }

  public Train() {

  }

  /**
   * @return the trainId
   */
  public String getTrainId() {
    return trainId;
  }

  /**
   * @return the trainNo
   */
  public String getTrainNo() {
    return trainNo;
  }

  /**
   * @return the seats
   */
  public List<List<Boolean>> getSeats() {
    return seats;
  }

  /**
   * @return the stationTimes
   */
  public Map<String, String> getStationTimes() {
    return stationTimes;
  }

  /**
   * @return the stations
   */
  public List<String> getStations() {
    return stations;
  }

  /**
   * Prints train info
   */
  public void printTrainInfo() {
    System.out.printf("Train ID: %s, Train No: %s, Total Stations: %s", trainId, trainNo, stations);
  }
}
