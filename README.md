SportyGroupHomeTest

SportyGroupHomeTest is a simple backend service that processes betting feed messages from two providers (**Alpha** and **Beta**) and transforms them into a standard format.


Requirements

- Java 21
- Gradle 8.x
- Spring Boot 3.5.x
- Postman

How to run the project locally

1 Clone the repository

git clone https://github.com/yourusername/SportyGroupHomeTest.git
cd SportyGroupHomeTest


2 Check your Java version

java -version
Should show Java 21


3 Run the application

./gradlew bootRun


By default the application will be running at:

http://localhost:8080


Run all unit and integration tests with:

./gradlew test

Test reports will appear in the console output.  
You can also open `build/reports/tests/test/index.html` for a full HTML report.


Main Endpoints

| Endpoint                  | Method | Description                                      |
|---------------------------|--------|--------------------------------------------------|
| `/provider-alpha/feed`    | POST   | Accepts `odds_update` or `settlement` messages from Alpha |
| `/provider-beta/feed`     | POST   | Accepts `ODDS` or `SETTLEMENT` messages from Beta |

Example Requests

Provider Alpha - Odds Update

```json
{
  "msg_type": "odds_update",
  "event_id": "ev123",
  "values": {
    "1": 2.0,
    "X": 3.1,
    "2": 3.8
  }
}


Provider Alpha - Settlement

json
{
  "msg_type": "settlement",
  "event_id": "ev123",
  "outcome": "1"
}


Provider Beta - Odds Change

json
{
  "type": "ODDS",
  "event_id": "ev456",
  "odds": {
    "home": 1.95,
    "draw": 3.2,
    "away": 4.0
  }
}

Provider Beta - Settlement

json
{
  "type": "SETTLEMENT",
  "event_id": "ev456",
  "result": "away"
}


Using Postman

A Postman Collection file `SportyGroupHomeTest.postman_collection.json` is included to help you test all endpoints easily.

How to use:
1. Open Postman.
2. Click Import.
3. Select the `SportyGroupHomeTest.postman_collection.json` file.
4. Run each request to verify the expected response.

Project details

- This is a stateless demo backend.
- No database is needed feeds are parsed, transformed, and simulated as if sent to a queue.
Useful Gradle Commands

| Command                   | What it does                               |
|---------------------------|--------------------------------------------|
| `./gradlew bootRun`       | Run the application locally                |
| `./gradlew test`          | Run all unit and integration tests         |
| `./gradlew build`         | Build the full project JAR                 |

Author
@Nestor Alduey - Candidate for Java Backend Position
Sporty Group Home Assignment Solution  
Contact: nalduey@gmail.com
