> A really simple ticket booking service implementation

---

With this project I basically learned serialization and deserialization of JSON
files from basic Java POJOs, through the use of `ObjectMapper` class from the
Jackson Library.




### Structure
``` shell
src
├── main
│   ├── java
│   │   └── ticket
│   │       └── booking
│   │           ├── App.java
│   │           ├── entitiesgigi
│   │           │   ├── Ticket.java
│   │           │   ├── Train.java
│   │           │   └── User.java
│   │           ├── List.java
│   │           ├── localDB
│   │           │   ├── trains.json
│   │           │   └── users.json
│   │           ├── services
│   │           │   └── UserBookingService.java
│   │           └── utils
│   │               └── UserServiceUtil.java
```
