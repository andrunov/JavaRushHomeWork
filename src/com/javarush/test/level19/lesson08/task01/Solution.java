package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //Запоминаем настоящий PrintStream в спец.переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем адаптер как текущий System.out
        System.setOut(stream);

        //вызываем функцию с sout
        testString.printSomething();

        //Преобразовываем записанные в ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем System.out как было изначально
        System.setOut(consoleStream);

        //Переводим все в большие буквы
        result = result.toUpperCase();

        //Вывод в консоль
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
