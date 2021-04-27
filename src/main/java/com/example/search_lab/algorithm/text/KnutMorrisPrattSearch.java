package com.example.search_lab.algorithm.text;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class KnutMorrisPrattSearch implements PreciseSubstringSearch {

    @Override
    public List<Integer> search(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;
        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            } else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = compliedPatternArray[patternIndex - 1];
                }else {
                    textIndex = textIndex + 1;
                }
            }
        }
        return foundIndexes;
    }

    public static int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];
        compliedPatternArray[0] = 0;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compliedPatternArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = compliedPatternArray[len - 1];
                } else {
                    compliedPatternArray[i] = len;
                    i++;
                }
            }
        }
        return compliedPatternArray;
    }
    //Алгоритм КМП осуществляет поиск текста по заданному шаблону.
    //
    //В этом поиске сначала компилируется заданный шаблон. Компилируя шаблон,
    //мы пытаемся найти префикс и суффикс строки шаблона. Это поможет в случае
    //несоответствия – не придётся искать следующее совпадение с начального индекса.
    //
    //Вместо этого мы пропускаем часть текстовой строки, которую уже сравнили,
    // и начинаем сравнивать следующую. Необходимая часть определяется по префиксу
    // и суффиксу, поэтому известно, какая часть уже прошла проверку и может быть
    // безопасно пропущена.
    //
    // КМП работает быстрее алгоритма перебора благодаря пропускам.
    //Скомпилированный массив Java можно рассматривать как массив, хранящий шаблон
    // символов. Цель – найти префикс и суффикс в шаблоне. Зная эти элементы, можно
    // избежать сравнения с начала текста после несоответствия и приступать
    // к сравнению следующего символа.
    //
    //Скомпилированный массив сохраняет позицию предыдущего местонахождения текущего
    // символа в массив шаблонов.
    //
    //Здесь мы последовательно сравниваем символы в шаблоне и текстовом массиве.
    // Мы продолжаем двигаться вперёд, пока не получим совпадение. Достижение конца
    // массива при сопоставлении означает нахождение шаблона в тексте.
    //
    //Но! Есть один момент.
    //
    //Если обнаружено несоответствие при сравнении двух массивов, индекс символьного
    // массива перемещается в значение compiledPatternArray(). Затем мы переходим
    // к следующему символу в текстовом массиве. КМП превосходит метод грубой силы
    // однократным сравнением текстовых символов при несоответствии.
    //
    //С помощью этого массива КМП ищет заданный шаблон в тексте, не возвращаясь в
    // начало текстового массива.
}
