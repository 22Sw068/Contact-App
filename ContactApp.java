import java.util.Scanner;
class Con_App {
    private final String[][] contacts;

    public Con_App(int row, int column) {
        this.contacts = new String[row][column];
    }

    public void All_Contacts_Display() {
        for (String[] contact : contacts) {
            if (contact[0] != null && contact[1] != null) {
                System.out.println("Name: " + contact[0] + ", Number: " + contact[1]);
            }
        }
    }

    public String searchContact(String name) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][0] != null && contacts[i][0].equalsIgnoreCase(name)) {
                System.out.println("Index: " + i + ", Name: " + contacts[i][0] + ", Number: " + contacts[i][1]);
                return contacts[i][1];
            }
        }
        return "Contact not found";
    }


    public void addContact(String name, String number, int index) {
        if (index >= 0 && index < contacts.length) {
            contacts[index][0] = name;
            contacts[index][1] = number;
           System.out.println("Contact added successfully.");
        } else {
            System.out.println("Invalid index. Contact not added.");
        }
    }

    public void updateContact(String oldName, String newName) {
        for (String[] contact : contacts) {
            if (contact[0] != null && contact[0].equalsIgnoreCase(oldName)) {
                contact[0] = newName;
                System.out.println("Contact updated successfully.");
                 return;
            }
        }
        System.out.println("Contact not found. Update failed.");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][0] != null && contacts[i][0].equalsIgnoreCase(name)) {
                for (int j = i; j < contacts.length - 1; j++) {
                    contacts[j][0] = contacts[j + 1][0];
                    contacts[j][1] = contacts[j + 1][1];
                }
                contacts[contacts.length - 1][0] = null;
                contacts[contacts.length - 1][1] = null;

                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found. Deletion failed.");
    }
}

public class ContactApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Con_App contactApp = new Con_App(10, 2);
        contactApp.addContact("ALI", "123456789", 1);
        contactApp.addContact("Sarmad", "987654321", 2);
        contactApp.addContact("Salam", "543216789", 3);
        contactApp.addContact("Mujahid", "10234567", 4);
        contactApp.addContact("Akram", "123498765", 5);

        while (true) {
            System.out.println("---------All Contacts:------------------");
            contactApp.All_Contacts_Display();
            System.out.println("-------Search Contacts------------------");
            System.out.print("Enter a name to search (or type 'exit' to stop searching): ");
            String searchName = scanner.nextLine();

            if (searchName.equalsIgnoreCase("exit")) {
                break;
            }

            String searchedNumber = contactApp.searchContact(searchName);
            System.out.println(searchName + "'s number: " + searchedNumber);

            System.out.println("-------Update Contact------------------");
            System.out.print("Enter the name to update (or type 'exit' to stop updating): ");
            String oldName = scanner.nextLine();

            if (oldName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter the new name: ");
            String newName = scanner.nextLine();

            contactApp.updateContact(oldName, newName);

            System.out.println("-------Delete Contact------------------");
            System.out.print("Enter the name to delete (or type 'exit' to stop deleting): ");
            String deleteName = scanner.nextLine();

            if (deleteName.equalsIgnoreCase("exit")) {
                break;
            }

            contactApp.deleteContact(deleteName);
        }
    }
}