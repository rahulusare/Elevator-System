# 🚪 Elevator System (Java Console Project)

A simple console-based **elevator simulation system** built using Java and Maven. This project demonstrates how a single elevator can handle user floor requests in real time, including direction-based logic (up/down), door operations, and queue management.

---

## 📦 Project Structure

ElevatorSystem/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/rahul/elevator/ElevatorSystem/
│ │ │ ├── Elevator.java
│ │ │ ├── ElevatorController.java
│ │ │ ├── ElevatorRequest.java
│ │ │ ├── ElevatorSystem.java # Main entry point
│ │ │ └── Utils.java # Helper methods
│ ├── test/
│ │ └── java/ # (Optional) For unit tests
├── pom.xml # Maven configuration
├── README.md

---

## 🧠 Features

- ✅ Handles dynamic user input while elevator is moving
- ✅ Direction-aware logic: Up (🔼) and Down (🔽)
- ✅ Simulates floor-by-floor movement
- ✅ Door open/close logic at destination
- ✅ Object-oriented and modular design
- ✅ Ready for multithreading upgrade

---

## 🚀 How to Run

### 📋 Requirements
- Java 17 or 21 (as seen in your project)
- Maven installed
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### ▶️ Steps
1. Clone or download this repository
2. Open the project in your IDE
3. Run `ElevatorSystem.java` from:

com.rahul.elevator.ElevatorSystem
4. Or use terminal:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.rahul.elevator.ElevatorSystem.ElevatorSystem"

🖥️ Sample Output
mathematica
Copy
Edit
Enter floor number 0 to 9 (-1 for Exit): 7
🔼 Going Up to 7
🔼0
🔼1
🔼2
🔼3
🔼4
🔼5
🔼6
🔼7
Open Door
Close Door
Enter floor number 0 to 9 (-1 for Exit): 4
🔽 Going down to: 4
🔽7
🔽6
🔽5
🔽4
Open Door
Close Door


🔧 Technologies Used
Java 21
Maven
Java Collections (Queue, ArrayList)
OOP (Classes, Encapsulation, etc.)

🚀 Future Enhancements
Add support for multiple elevators
GUI using JavaFX or Swing
REST API using Spring Boot
Use BlockingQueue and threads for real-time simulation
Add unit testing with JUnit

👨‍💻 Author
Rahul Usare

📧 [rahulusare110@gmail.com]

📝 License
This project is for learning and educational use. Contributions and suggestions are welcome!