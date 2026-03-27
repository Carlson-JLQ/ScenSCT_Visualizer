// User input obtained but not used in Bean Validation constraint message should not be flagged as EL injection.
package scensct.core.neg;

import javax.validation.constraints.NotNull;

public class NegCase1 {
    public static class User {
        @NotNull(message = "Name is required") // Literal message, no user input
        private String name;
        
        private String userInput; // Simulated user input field
        
        public void setUserInput(String input) {
            this.userInput = input; // User input obtained but not used in constraint message
        }
        
        public String getUserInput() {
            return userInput;
        }
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setUserInput(args.length > 0 ? args[0] : "test"); // Obtain user input from request parameter
        // User input flows only to non-message sink (field assignment), not to any constraint message
        System.out.println("User input: " + user.getUserInput());
    }
}