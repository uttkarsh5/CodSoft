import java.util.Scanner;
public class Chatbot {

    public static void main(String[] args) {
        Scanner SC= new Scanner(System.in);
        String input;

        System.out.println("Chatbot: Hello! I'm your virtual assistant. Type 'exit' to end the chat");

        while (true){
            System.out.print("You: ");
            input=SC.nextLine().toLowerCase();

            if (input.equals("exit")){
                System.out.println("Chatbot: Goodbye! Have a nice day");
                break;
            }

            // Rule

            if (input.contains("hello")||input.contains("hi")){
                System.out.println("Chatbot: Hello there! How can I help you?");
            }
            else if(input.contains("how are you")){
                System.out.println("Chatbot: I'm just a program, but I'm doing great! What about you?");
            }
            else if (input.contains("your name")) {
                System.out.println("Chatbot: I'm Chatbot, Your friendly assistant.");
            } else if (input.contains("time")) {
                System.out.println("Chatbot: Sorry i can't tell the time right now");
            } else if (input.contains(" creator")) {
                System.out.println("Chatbot: My creator name is Uttkarsh Raj.");
            } else if (input.contains("thank you")|| input.contains("thanks")) {
                System.out.println("Chatbot: You're welcome");
            } else if (input.contains("bye")) {
                System.out.println("Chatbot: Bye! Take care Have a nice day!");
                break;
            }else {
                System.out.println("Chatbot: Sorry, I didn't understand that. Can you rephrase?");

        }
        }
        SC.close();
    }
}
