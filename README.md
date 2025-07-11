# 🚪 Elevator System (Java Console Project)

A simple console-based **elevator simulation system** built using Java and Maven. This project demonstrates how a single elevator can handle user floor requests in real time, including direction-based logic (up/down), door operations, and queue management, sound system.

---

## 📦 Project Structure

ElevatorSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── rahul/
│   │   │           └── elevator/
│   │   │               ├── app/
│   │   │               │   └── ElevatorSystemApp.java
│   │   │               ├── controller/
│   │   │               │   └── ElevatorController.java
│   │   │               ├── model/
│   │   │               │   └── ElevatorRequest.java
│   │   │               ├── service/
│   │   │               │   └── Elevator.java
│   │   │               └── util/
│   │   │                   ├── SoundPlayer.java
│   │   │                   └── Utils.java
│   │   └── resources/
│   │       └── sounds/
│   │           ├── AtFloor.wav
│   │           ├── DoubleDing.wav
│   │           ├── Down.wav
│   │           ├── EnterFloor.wav
│   │           └── Up.wav
│   │           
│   ├── test/
│   │   ├── java/
│   │   └── resources/
├── pom.xml
├── README.md


---

## 🧠 Features

- ✅ Handles dynamic user input while elevator is moving
- ✅ Direction-aware logic: Up (🔼) and Down (🔽)
- ✅ Sound System in hindi
- ✅ Simulates floor-by-floor movement
- ✅ Door open/close logic at destination
- ✅ Object-oriented and modular design
- ✅ multithreading 

---

## 🚀 How to Run

### ▶️ Steps
1. Clone or download this repository
2. Open the project in your IDE
3. Run `ElevatorSystem.java` from:

com.rahul.elevator
4. Or use terminal:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.rahul.elevator.ElevatorSystem"

🖥️ Sample Output
mathematica
Copy
Edit
Enter floor number 0 to 49 (-1 for Exit): 30
✔️ Received request for floor: 30
🔼 Going Up to: 30
🔼 0
🔼 1
🔼 2
🔼 3
🔼 4
🔼 5
...

✔️ Received request for floor: 20
🔼 6
🔼 7
🔼 8
...
🔼 20

✔️ Received request for floor: 4
🔼 13
🔼 14
...
🔼 20

✔️ Received request for floor: 23
🚪 Door opening...
🚪 Door closed
⬅️ 21
⬅️ 22

✔️ Received request for floor: 4
🚪 Door opening...
🚪 Door closed
⬇️ Going Down to: 4
⬇️ 30
⬇️ 29
⬇️ 28
⬇️ 27
...
⬇️ 5
⬇️ 4
🚪 Door opening...
🚪 Door closed



🔧 Technologies Used
Java 21
Maven
Java Collections (BlockingQueue, LinkedList)
OOP (Classes, Encapsulation, etc.)

🚀 Future Enhancements
Add support for multiple elevators
GUI using HTML, CSS, JS
REST API using Spring Boot

👨‍💻 Author
Rahul Usare

📧 [rahulusare110@gmail.com]

📝 License
This project is for learning and educational use. Contributions and suggestions are welcome!