[< Назад](..%2F..%2FREADME.md)

# Руководство по String pool в Java

[Оригинал статьи](https://topjava.ru/blog/rukovodstvo-po-string-pool-v-java#5)

## Класс String

Класс _String_ отвечает за создание строк, состоящих из символов. А если быть точнее, заглянув в реализацию и посмотрев
способ их хранения, то строки представляют собой массив символов (так было до Java 9):

```
private final char value[];
```

Начиная с Java 9 строки хранятся как массив байт:

```
private final byte[] value;
```

Причину смены используемого типа вы можете узнать тут: [Компактные строки в Java 9](compact_strings_in_java_9.md)