# Seat Reservation System

## Overview
This project implements a simple seat reservation system in Java. The system manages a grid of seats arranged in rows and columns. Users can choose a seat, and the system will notify them if the seat is already reserved or if the coordinates are invalid.

## Classes
The project consists of two main classes:
1. **Seat**: Represents an individual seat in the reservation system.
2. **SeatReservationSystem**: Manages a grid of seats and provides methods to interact with them.

### Seat
The `Seat` class represents an individual seat. It has the following methods:
- `chooseSeat()`: Attempts to reserve the seat. Returns `true` if successful, `false` if the seat is already reserved.
- `isReserved()`: Checks if the seat is reserved. Returns `true` if reserved, `false` otherwise.

### SeatReservationSystem
The `SeatReservationSystem` class manages a grid of seats. It has the following methods:
- `chooseSeat(int row, int column)`: Attempts to reserve the seat at the specified row and column. Returns `true` if successful, `false` if the seat is already reserved or the coordinates are invalid.
- `isSeatReserved(int row, int column)`: Checks if the seat at the specified row and column is reserved. Returns `true` if reserved, `false` otherwise.
- `chooseSeatWithStatus(int row, int column)`: Attempts to reserve the seat at the specified row and column and returns a message indicating the result.

## How to Run

** Using an IDE (Integrated Development Environment):**

- Clone or download the repository.
- Import the project into your favorite Java IDE (e.g., Eclipse, IntelliJ IDEA, VS Code with Java extensions).
- Locate the `SeatReservationSystem.java` file.
- Right-click on `SeatReservationSystem.java` and select "Run" or "Run As Java Application". The output will appear in the IDE's console.
