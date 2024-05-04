import java.util.*;

public class PhoneBook {
	private static HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

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
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    displayContacts(); // Метод отсортированного вывода контактов
                    break;
                case 2:
                    addContact(scanner); // Метод добавления контакта
                    break;
                case 3:
                    deleteContact(scanner); // Метод удаления контакта
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите существующий пункт меню.\n");
            }
        }
	}

	/* Метод отсортированного вывода контактов */
	private static void displayContacts() {
		if (phoneBook.isEmpty()) {
            System.out.println("Телефонная книга пуста.\n");
            return;
        }

        // Создаем список записей для сортировки
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Вывод отсортированных записей
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            String name = entry.getKey();
            HashSet<String> phoneNumbers = entry.getValue();
            StringBuilder formattedNumbers = new StringBuilder();
            formattedNumbers.append("[");
            for (String number : phoneNumbers) {
                formattedNumbers.append(number).append(", ");
            }
            formattedNumbers.setLength(formattedNumbers.length() - 2); // Удаление последней запятой и пробела
            formattedNumbers.append("]");
            System.out.println(name + ": " + formattedNumbers);
        }
		System.out.println(); // Пустая строка для отделения нового меню от выведенного результата
	}

	/* Метод добавления контакта */
	private static void addContact(Scanner scanner) {
		System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();

        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine().trim();

        // Если имя уже есть в книге, добавляем новый телефон в существующий HashSet
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else { // Иначе создаем новую запись
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
        System.out.println("Контакт успешно добавлен.\n");
    }

	/* Метод удаления контакта */
	private static void deleteContact(Scanner scanner) {
		System.out.print("Введите имя контакта для удаления: ");
        String name = scanner.nextLine().trim();

        // Проверяем наличие контакта в книге
        if (!phoneBook.containsKey(name)) {
            System.out.println("Контакт с таким именем не найден.\n");
            return;
        }

        // Удаляем контакт
        phoneBook.remove(name);
        System.out.println("Контакт успешно удален.\n");        
    }
}