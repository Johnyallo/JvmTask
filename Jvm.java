package TaskOfJvm;

public class Jvm {
    public static void main(String[] args) { //в Stack'у создаётся блок памяти под примтивные типаы данных метода main
        int i = 1;                      // 1 Так как "i" примит. ТД, то отправляется в Stack в блок main
        Object o = new Object();        // 2 Переменная "o" отправляется в Stack (как ссылка на объект Object),
                                        // а сам объект отправляется в Heap
        Integer ii = 2;                 // 3 Ссылка "ii" отпраляется в Stack, а Integer идёт в Heap
        printAll(o, i, ii);             // 4 В Stack создаётся блок памяти под метод printAll c 3 переменными "о", "i", "ii"
        System.out.println("finished"); // 7 В Stack создаётся блок памяти под метод println от статич. переменной в классе
                                        // System, строка "finished" будет храниться в StringPool (область Heap)
    }
    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 К блоку памяти printAll в Stack'e  добавляется uselessVar,
                                                    // а Integer отправляется в Heap
        System.out.println(o.toString() + i + ii);  // 6 В Stack создаётся блок памяти под метод println с переменными o, i, ii
    }
//    После происходит загрузка классов в JVM через ApplicationClassLoader
//    После идёт связывание (проверка что код валиден, подготовка примитивов в статич. полях, разрешение симв.ссылок)
//    После происходит инициализация и всё отправляется в Метаспейс(если я правильно понял)
//    создание байт-классов и дальше в JVM
    // после отработки программы работает garbage collector

}
