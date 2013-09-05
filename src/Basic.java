import java.util.Scanner;

public class Basic {

    final int DEFAULT_SIZE = 3;
    final char DEFAULT_ERASE = ' ';
    final int DEFAULT_ZERO = 0;

    public char[][] field;

    public void erase() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                System.out.print("[" + field[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void show() {
        for (int i = DEFAULT_ZERO; i < DEFAULT_SIZE; i++) {
            for (int j = DEFAULT_ZERO; j < DEFAULT_SIZE; j++) {
                field[i][j] = DEFAULT_ERASE;
            }
        }
    }
           //commit
    public boolean row() {

        char first = 0;
        int i;
        int j;

        for (i = DEFAULT_ZERO; i < DEFAULT_SIZE; i++) {
            first = field[i][DEFAULT_ZERO];
            if (first == DEFAULT_ERASE) {

                return false;
            }
            for (j = 1; j < DEFAULT_SIZE; j++) {

                if (field[i][j] != first) {
                    return false;

                }
            }
        }

        return true;
    }

    public boolean column() {

        char first = 0;
        int i;
        int j;

        for (i = DEFAULT_ZERO; i < DEFAULT_SIZE; i++) {

            first = field[DEFAULT_ZERO][i];
            if (first == DEFAULT_ERASE) {
                return false;
            }
            for (j = 1; j < DEFAULT_SIZE; j++) {
                if (field[j][i] != first) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean victory() {

        boolean oneVictory, twoVictory;

        oneVictory = row();
        twoVictory = column();

        if (oneVictory || twoVictory) {

        }

        return true;
    }

    public void nextStep(char nextInput) {

        System.out.println("Ходить" + nextInput + ".");
        Scanner read = new Scanner(System.in);
        int lineNumber = 0;
        int columnNumber = 0;
        boolean check = true;

        while (check) {

            System.out.print("Ввести номер строки ячейки");
            lineNumber = read.nextInt() - 1;
            System.out.print("Введите номер столбкца");
            columnNumber = read.nextByte() - 1;

            if (lineNumber >= DEFAULT_SIZE || columnNumber >= DEFAULT_SIZE || lineNumber < 0 || columnNumber < 0 ||
                    field[lineNumber][columnNumber] != DEFAULT_ERASE) {
                System.out.println("Неверные значения");
            } else {

                check = false;

            }

        }

        field[lineNumber][columnNumber] = nextInput;

    }

}
