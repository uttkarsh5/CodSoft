import java.util.Scanner;
public class Recommendation_System {
    public static void main(String[] args) {
        String [][] item={

                // Movie
                {"Inception","Sci-Fi","Movie"},
                {"Titanic","Romance","Movie"},
                {"The Matrix","Sci-Fi","Movie"},
                {"The Notebook","Romance","Movie"},
                {"John Wick","Action","Movie"},

                // Book
                {"The Alchemist","Motivational","Book"},
                {"Harry Potter","Fantasy","Book"},
                {"Atomic Habits","Self-Help","Book"},
                {"Twilight","Romance","Book"},
                {"The Hobbit","Fantasy","Book"},

                // products

                {"Laptop","Electronics","Product"},
                {"Smartphone","Electronics","Product"},
                {"T-Shirt","Clothing","Product"},
                {"Microwave","Home Appliances","Product"},
                {"Blender","Home Appliances","Product"}

        };

        Scanner SC=new Scanner(System.in);

        // User
        System.out.println("Welcome to the Recommendation System!");
        System.out.println("Available Types: Movie, Book, Product");
        System.out.print("Enter the type you're interested: ");
        String user=SC.nextLine().trim();

        // user - category preference
        System.out.println("\nAvailable Categories: Sci-Fi, Romance, Action, Fantasy, Motivational, Self-Help, Electronics, Clothing, Home-Appliances");
        System.out.print("Enter your preferred category:");
        String userCategory=SC.nextLine().trim();

        System.out.println("\nRecommended"+user+"s in category'"+userCategory+"':");
        boolean found=false;

        for (int i = 0; i < item.length; i++) {
            if (item[i][1].equalsIgnoreCase(userCategory) && item[i][2].equalsIgnoreCase(user)) {
                System.out.println("- "+item[i][0]);
                found=true;
            }
        }
        if(!found){
            System.out.println("NO "+user+"s found in this category.");
        }
        SC.close();
    }
}