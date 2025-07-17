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

========================================
Enter floor number (0 to 100) or -1 to Exit
To call elevator:
  • For DOWN  =>  <floor_number
  • For UP    =>  >floor_number
========================================
45
 You Hava Entered : [0m45
 🔼 Going Up to: [0m45
   🔼  0[0m
   🔼  1[0m
   🔼  2[0m
>23   🔼  3[0m
   🔼  4[0m
   🔼  5[0m

 ✔️ Received request for floor: [0m> 23
   🔼  6[0m
   🔼  7[0m
    .
    .
    .
    .
    .
    .
   🔼 22[0m
   🔼 23[0m
 🚪 Door opening... [0m
 🔒 Door closed [0m
In_Requests_Pending: 0
Out_Request_Pending: 0
Current_Floor: 24
   🔼 24[0m
   🔼 25[0m
    .
    .
    .
    .
    .
   🔼 45[0m
   🔼 44[0m
 🚪 Door opening... [0m
 🔒 Door closed [0m
In_Requests_Pending: 0
Out_Request_Pending: 0
Current_Floor: 46



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