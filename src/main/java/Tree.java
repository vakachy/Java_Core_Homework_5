import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file - директория, содержимое которой требуется отобразить
     * @param indent - отступ первой строки для вывода в консоль
     * @param isLast - флаг конечного элемента в текущей директории
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null) return;

        for (int i = 0; i < files.length; i++) {
            print(files[i], indent, i == files.length - 1);
        }
    }
}
