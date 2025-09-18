import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Infos.getGreeting();
        gameStart();
    }

    public static void gameStart() {
        String[] words = Infos.getMasOfWords();
        String rndWord = chooseRndWord(words);
        StringBuilder bluredWord = new StringBuilder(makeBluredWord(rndWord.length()));
        int successTicker = 0;
        int sttsOfStickman = 0;
        int uniqueCharLength = uniqueCharLength(rndWord);
        String checkedCharsMas = "";

        while (true) {
            Infos.getPreScanText();
            Scanner scanner = new Scanner(System.in);
            String inputChar = String.valueOf(scanner.next().charAt(0));

            if (checkChar(rndWord, inputChar, bluredWord)) {
                if (checkDelay(inputChar, checkedCharsMas)) {
                    Infos.getStopDelayText();
                } else {
                    Infos.getSuccessText();
                    successTicker += 1;
                    checkedCharsMas += inputChar;
                    if (checkWin(successTicker, uniqueCharLength)) {
                        Infos.getWinText();
                        break;
                    }
                    printStickman(sttsOfStickman);
                }
            } else {
                if (sttsOfStickman == Infos.getStickman().length - 2) {
                    Infos.getEndText();
                    System.out.println("Загадaнное слово: " + rndWord);
                    sttsOfStickman += 1;
                    printStickman(sttsOfStickman);
                    Infos.getLine(1);
                    break;
                }
                if (checkDelay(inputChar, checkedCharsMas)) {
                    Infos.getStopDelayText();
                } else {
                    checkedCharsMas += inputChar;
                    sttsOfStickman += 1;
                    Infos.getFailText();
                    printStickman(sttsOfStickman);
                }
            }
            Infos.getLine(1);
        }
        ifuWantRestart();
    }

    public static boolean checkDelay(String inputChar, String checkedCharsMas) {
        for (int i = 0; i < checkedCharsMas.length(); i++) {
            if (inputChar.charAt(0) == checkedCharsMas.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void ifuWantRestart() {
        Infos.getIfuWantRestartText();
        Scanner scanner = new Scanner(System.in);
        String inputChar = String.valueOf(scanner.next().charAt(0));
        if (inputChar.equals("+")) {
            gameStart();
        } else if (inputChar.equals("-")) {
            System.exit(0);
        }
    }

    public static int uniqueCharLength(String rndWord) {
        int uniqueCharLength = 0;
        for (int i = 0; i < rndWord.length(); i++) {
            boolean isUniq = true;
            Character temp = rndWord.charAt(i);
            for (int j = i + 1; j < rndWord.length(); j++) {
                if (rndWord.charAt(j) == temp) {
                    isUniq = false;
                }
            }
            if (isUniq) {
                uniqueCharLength += 1;
            }
        }
        return uniqueCharLength;
    }

    public static void printStickman(int sttsOfStickman) {
        System.out.println(Infos.getStickman()[sttsOfStickman]);
    }

    public static boolean checkWin(int successTicker, int uniqueCharLength) {
        if (successTicker == uniqueCharLength) {
            return true;
        }
        return false;
    }

    public static boolean checkChar(String rndWord, String inputChar, StringBuilder bluredWord) {
        int temp = 0;
        for (int i = 0; i < rndWord.length(); i++) {
            if (inputChar.charAt(0) == rndWord.charAt(i)) {
                temp += 1;
                bluredWord.setCharAt(i, inputChar.charAt(0));
            }
        }

        printBluredWord(bluredWord);
        Infos.getLine(1);

        if (temp > 0) {
            return true;
        }

        return false;
    }

    public static String makeBluredWord(int wordLength) {
        String bluredWord = "";
        for (int i = 0; i < wordLength; i++) {
            bluredWord += "_";
        }
        return bluredWord;
    }

    public static void printBluredWord(StringBuilder bluredWord) {
        String strBluredWord = bluredWord.toString();
        System.out.println(strBluredWord);
    }

    public static String chooseRndWord(String[] words) {
        int rndWordIndex = new Random().nextInt(words.length);
        String rndWord = words[rndWordIndex];
        return rndWord;
    }

    public static class Infos {

        public static String[] getMasOfWords() {
            String[] words = {"программирование", "компьютер", "алгоритм", "виселица",
                    "джунгли", "методология", "переменная", "функция",
                    "объект", "класс", "интерфейс", "наследование",
                    "полиморфизм", "инкапсуляция", "абстракция",
                    "библиотека", "фреймворк", "приложение",
                    "база данных", "сервер", "клиент", "сеть",
                    "интернет", "браузер", "операционная",
                    "компилятор", "интерпретатор", "отладчик",
                    "тестирование", "разработка", "внедрение",
                    "обслуживание", "документация", "пользователь",
                    "интерфейс", "навигация", "аутентификация",
                    "авторизация", "безопасность", "шифрование",
                    "резерв", "восстановление",
                    "производительность", "оптимизация",
                    "масштабируемость", "надежность", "доступность",
                    "совместимость", "модульность", "компонент",
                    "плагин", "расширение", "интеграция", "миграция",
                    "адаптация", "локализация", "интернационализация",
                    "конфигурация", "установка", "обновление",
                    "запуск", "остановка", "перезагрузка", "мониторинг",
                    "логирование", "аналитика", "статистика",
                    "визуализация", "отчетность", "уведомление",
                    "сообщение", "ошибка", "исключение", "обработка",
                    "валидация", "санитизация", "нормализация",
                    "форматирование", "парсинг", "сериализация",
                    "десериализация", "кэширование", "буферизация",
                    "стриминг", "загрузка", "выгрузка", "синхронизация",
                    "репликация", "кластеризация", "балансировка",
                    "распределение", "параллелизм", "многопоточность",
                    "асинхронность", "обработка событий", "цикл",
                    "итерация", "рекурсия", "условие", "ветвление",
                    "переключение", "исключение", "дебаггинг",
                    "профилирование", "рефакторинг", "реинжиниринг",
                    "архитектура", "паттерн", "антипаттерн",
                    "шаблон", "стиль", "стандарт", "конвенция",
                    "руководство", "методика", "практика",
                    "методология", "дисциплина", "процесс",
                    "метрика", "показатель", "индикатор"};

            return words;
        }
        public static void getLine(int coefficient) {
            String line = "++++++++++++++++++++++++++++++++++++++++++++";
            for (int i = 0; i < coefficient; i++) {
                System.out.print(line);
            }
            System.out.println();
        }
        public static void getIfuWantRestartText() {
            String IfuWantRestartText = "Напишите + чтобы продолжить, - чтобы закончить игру.";
            System.out.println(IfuWantRestartText);
        }
        public static void getStopDelayText() {
            String StopDelayText = "Вы уже писали эту букву";
            System.out.println(StopDelayText);
        }
        public static void getSuccessText() {
            String SuccessText = "Успешно";
            System.out.println(SuccessText);
        }
        public static void getGreeting() {
            String greeting = "Приветствие";
            System.out.println(greeting);
        }
        public static void getPreScanText() {
            String preScanText = "Введи букву: ";
            System.out.println(preScanText);
        }
        public static void getEndText() {
            String endText = "Проигрыш";
            System.out.println(endText);
        }
        public static void getWinText() {
            String winText = "Выигрыш";
            System.out.println(winText);
        }
        public static void getFailText() {
            String winText = "Анлак";
            System.out.println(winText);
        }
        public static String[] getStickman() {
            String[] stickmanVars = {
                    "| = |\n|\n|\n|",
                    "| = |\n|   0\n|\n|",
                    "| = |\n|   0\n|   |\n|",
                    "| = |\n|   0\n|   |\\\n|",
                    "| = |\n|   0\n|  /|\\\n|",
                    "| = |\n|   0\n|  /|\\\n|  /",
                    "| = |\n|   0\n|  /|\\\n|  / \\"
            };
            return stickmanVars;
        }
    }
}

//Приветственные слова
// ТЕКСТ: поле ввода

//Вывод:
// - индикатор удачной/неудач попытки (состояние стикмена).
// - само заблюренное слово с отмеченными отгаданными буквами.
// - ТЕКСТ: поле ввода.


//Методы
//Метод с массивами стикмена и вобщем с сохранением всей информаций и еткстов.
//Метод с рандомным выбором слова из массива слов
//Метод с
