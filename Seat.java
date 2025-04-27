class Seat {
    private final int row;
    private final int column;
    private boolean occupied;
    private String occupantName;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.occupied = false;
        this.occupantName = null;
    }

    public boolean reserve(String occupantName) {
        if (occupied) {
            System.out.println("Seat at row " + row + ", column " + column +
                    " is already occupied by " + this.occupantName);
            return false;
        } else {
            this.occupied = true;
            this.occupantName = occupantName;
            System.out.println("Seat at row " + row + ", column " + column +
                    " has been successfully reserved by " + occupantName);
            return true;
        }
    }

    public void release() {
        this.occupied = false;
        this.occupantName = null;
        System.out.println("Seat at row " + row + ", column " + column + " has been released");
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getOccupantName() {
        return occupantName;
    }

    @Override
    public String toString() {
        return "Seat [" + row + "," + column + "]: " +
                (occupied ? "Occupied by " + occupantName : "Available");
    }
}