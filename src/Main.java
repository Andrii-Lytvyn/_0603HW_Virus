/*
Для каждого файла известно, с какими действиями можно к нему обращаться:
запись W,
чтение R,
запуск X.

Файл files.txt

В первой строке содержится число N — количество файлов, содержащихся в данной файловой системе.
В следующих N строчках содержатся имена файлов и допустимых с ними операций, разделенные пробелами.

Файл operations.txt
Далее указано чиcло M — количество запросов к файлам. В последних M строках указан запрос вида
Операция Файл.

К одному и тому же файлу может быть применено любое колличество запросов.

Вам требуется восстановить контроль над правами доступа к файлам.

Файл results.txt
Ваша программа для каждого запроса должна будет выводить
Файл: Операция: OK, если над файлом выполняется допустимая операция, или же Файл:
Операция: Access denied, если операция недопустима.

Пример входных данных
4
helloworld.exe R X
pinglog W R
nya R
goodluck X W R
5
read nya
write helloworld.exe
execute nya
read pinglog
write pinglog
Пример выходных данных
nya: read: OK
helloworld.exe: write: Access denied
nya: execute: Access denied
pinglog: read: OK
pinglog: write: OK

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  enum permission {
    WRITE,
    READ,
    EXECUTE,
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int position;
    Map<String, List<String>> fileName = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<String> fileOperations = new LinkedList<>();
      String nameAndOperation = br.readLine();
      position = nameAndOperation.indexOf(" ");
      String name = nameAndOperation.substring(0, position);
      String operations = nameAndOperation.substring(position + 1);

      if (operations.contains("W")) {
        fileOperations.add(permission.WRITE.toString());
      }
      if (operations.contains("X")) {
        fileOperations.add(permission.EXECUTE.toString());
      }
      if (operations.contains("R")) {
        fileOperations.add(permission.READ.toString());
      }
      fileName.put(name, fileOperations);
    }
    for (Map.Entry<String, List<String>> entry : fileName.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

  }


}
