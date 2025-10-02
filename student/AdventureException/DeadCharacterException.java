public class DeadCharacterException extends Exception {
    private final Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        // Get the simple class name in lowercase
        String type = character.getClass().getSimpleName().toLowerCase();
        return "The " + type + " " + character.getName() + " is dead.";
    }
}

