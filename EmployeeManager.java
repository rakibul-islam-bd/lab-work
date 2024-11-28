import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeManager {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error: Please provide exactly one command-line argument.");
            System.out.println("Usage:");
            System.out.println("  l  - List all employees");
            System.out.println("  s  - Show a random employee");
            System.out.println(" +<name> - Add a new employee");
            System.out.println(" ?<name> - Search for an employee");
            System.out.println("  c  - Count words and characters");
            System.out.println(" u<name> - Update an employee name");
            System.out.println(" d<name> - Delete an employee");
            return;
        }
        
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String employees[] = line.split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String line = reader.readLine();
                System.out.println(line);
                String employees[] = line.split(",");
                Random random = new Random();
                int index = random.nextInt(employees.length);
                System.out.println(employees[index]);
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("employees.txt", true));
                String n = args[0].substring(1);
                writer.write(", " + n);
                writer.close();
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String e[] = line.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String e[] = line.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (e[i].equals(n)) {
                        e[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("employees.txt"));
                    writer.write(String.join(",", e));
                    writer.close();
            } catch (Exception e) {}
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String e[] = line.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("employees.txt"));
                    writer.write(String.join(",", list));
                    writer.close();
            } catch (Exception e) {}
            System.out.println("Data Deleted.");
        }
    }
}