import java.util.*;

public class PhoneBook
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Вывести все контакты.");
            System.out.println("2. Добавить запись.");
            System.out.println("3. Удалить запись.");
            System.out.println("4. Выход из программы.");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    // displayContacts(); будет отсортированный вывод
                    break;
                case 2:
                    // addContact(scanner); будет добавление нового контакта
                    break;
                case 3:
                    // deleteContact(scanner); удаление контакта
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите существующий пункт меню.");
            }
        }
	}
}