public class VerifyTextEntry {
    // Verifies the input based on its type and length constraints
    public void Verify(String input, String type, int currentLength, int limit) {
        if (type.equals("String")) { // Check if the input type is a string
            if (currentLength > limit) { // Validate the length of the string
                throw new IllegalArgumentException("Input too long; Max: " + limit); // Throw an error if the input exceeds the limit
            }
        } else if (type.equals("Int")) { // Check if the input type is an integer
            try {
                Integer.valueOf(input); // Attempt to parse the input as an integer
            } catch (Exception e) { // Catch any exceptions during parsing
                throw new IllegalArgumentException("Invalid integer input: " + input, e); // Throw an error for invalid integer input
            }
            if (currentLength > limit) { // Validate the length of the integer input
                throw new IllegalArgumentException("Input too long; Max: " + limit); // Throw an error if the input exceeds the limit
            }
        } else { // Handle unknown input types
            throw new IllegalArgumentException("Unknown type: " + type); // Throw an error for unsupported types
        }
    }
}
