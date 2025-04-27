import java.util.Scanner;

public class SeatReservationSystem {
    private Seat[][] seats;
    private final int rows;
    private final int columns;
    private Scanner scanner;

    public SeatReservationSystem(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new Seat[rows][columns];
        this.scanner = new Scanner(System.in);

        // Initialize all seats
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                seats[row][col] = new Seat(row, col);
            }
        }
    }

    public boolean reserveSeat(int row, int column, String occupantName) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            System.out.println("Invalid seat position. Rows must be between 0 and " + (rows-1) +
                    ", columns between 0 and " + (columns-1));
            return false;
        }

        return seats[row][column].reserve(occupantName);
    }

    public boolean checkSeatStatus(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            System.out.println("Invalid seat position.");
            return false;
        }

        boolean isOccupied = seats[row][column].isOccupied();
        String status = isOccupied ? "filled" : "free";
        String occupant = isOccupied ? " (occupied by " + seats[row][column].getOccupantName() + ")" : "";

        System.out.println("Seat at row " + row + ", column " + column + " is " + status + occupant);
        return !isOccupied;
    }

    public void displaySeatingChart() {
        System.out.println("\nSeating Chart:");
        System.out.print("  ");
        for (int col = 0; col < columns; col++) {
            System.out.printf("%4d ", col);
        }
        System.out.println("\n");

        for (int row = 0; row < rows; row++) {
            System.out.printf("%2d ", row);
            for (int col = 0; col < columns; col++) {
                System.out.print(seats[row][col].isOccupied() ? " [X] " : " [ ] ");
            }
            System.out.println();
        }
    }

    public void startInteractiveMode() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Seat Reservation System ===");
            System.out.println("1. Display seating chart");
            System.out.println("2. Check if a seat is available");
            System.out.println("3. Reserve a seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row: ");
                    int checkRow = scanner.nextInt();
                    System.out.print("Enter column: ");
                    int checkCol = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    checkSeatStatus(checkRow, checkCol);
                    break;
                case 3:
                    System.out.print("Enter row: ");
                    int reserveRow = scanner.nextInt();
                    System.out.print("Enter column: ");
                    int reserveCol = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (checkSeatStatus(reserveRow, reserveCol)) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        reserveSeat(reserveRow, reserveCol, name);
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Seat Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        // Create a 5x10 grid for a total of 50 seats
        SeatReservationSystem theater = new SeatReservationSystem(5, 10);
        theater.startInteractiveMode();
    }
}

