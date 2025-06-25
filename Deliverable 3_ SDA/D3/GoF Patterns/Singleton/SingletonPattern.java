// SingletonPattern.java
public class SingletonPattern {
    public static void main(String[] args) {
        // Fetching the single instance of StreamingEngine
        StreamingEngine engine = StreamingEngine.getInstance();
        engine.startStream("Team A vs Team B");
    }
}

class StreamingEngine {
    // Static variable to hold the single instance
    private static StreamingEngine instance;

    // Private constructor to prevent external instantiation
    private StreamingEngine() {
        System.out.println("Streaming Engine Initialized");
    }

    // Public static method to provide access to the single instance
    public static synchronized StreamingEngine getInstance() {
        if (instance == null) {
            instance = new StreamingEngine();
        }
        return instance;
    }

    // Example method to simulate streaming
    public void startStream(String match) {
        System.out.println("Streaming match: " + match);
    }
}
