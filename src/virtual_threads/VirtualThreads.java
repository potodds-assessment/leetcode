package virtual_threads;

public class VirtualThreads {
    public static void main(String[] args) {
        Thread.startVirtualThread(() -> {
            System.out.println("Hello, Project Loom!");
        });
    }
}
