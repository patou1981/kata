package before;


public enum Player {
    A,
    B;

    public static Player valueOf(char command) {
        return switch (command) {
            case 'A' -> A;
            case 'B' -> B;
            default -> throw new IllegalArgumentException("The provided command is nor A nor B but was: " + command);
        };
    }
}

