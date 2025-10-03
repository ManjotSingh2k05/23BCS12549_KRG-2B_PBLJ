class SeatReservation {
    private boolean reserved = false;

    public synchronized void reserveSeat(String userRole, String threadName) {
        if (!reserved) {
            System.out.println(userRole + " [" + threadName + "] successfully reserved the seat.");
            reserved = true;
        } else {
            System.out.println(userRole + " [" + threadName + "] failed. Seat already taken.");
        }
    }
}

class User implements Runnable {
    private SeatReservation reservationSystem;
    private String role;

    public User(SeatReservation reservationSystem, String role) {
        this.reservationSystem = reservationSystem;
        this.role = role;
    }

    @Override
    public void run() {
        reservationSystem.reserveSeat(role, Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        SeatReservation reservation = new SeatReservation();

        Thread basicUser = new Thread(new User(reservation, "Basic User"), "Thread-A");
        Thread vipUser = new Thread(new User(reservation, "VIP User"), "Thread-B");

        basicUser.setPriority(Thread.MIN_PRIORITY);
        vipUser.setPriority(Thread.MAX_PRIORITY);

        basicUser.start();
        vipUser.start();
    }
}
