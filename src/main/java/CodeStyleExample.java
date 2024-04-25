import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Пример стиля кода<br>
 * Строгих ограничений нет, главная цель форматирования - хорошая читаемость кода.
 * @author vpyzhyanov
 * @since 16.10.2023
 */
public class CodeStyleExample {
    private Collection<String> collection = new ArrayList<>();

    /**
     * <b>Пример форматирования тернарного оператора</b>
     * <p>Возвращает текстовое описание размера коллекции</p>
     * <p><i>Операторы "?" и ":" начинаются с новой строки</i></p>
     */
    public String ternaryOperatorFormat() {
        return collection.isEmpty()
                ? "Пустая коллекция"
                : "Коллекция состоит из %d элементов".formatted(collection.size());
    }

    /**
     * <b>Пример форматирования лямбда выражения</b>
     * <p>Возвращает текстовое описание размера коллекции</p>
     * <p><i>Каждая новая операция начинается с новой строки</i></p>
     */
    public String lambdaFormat() {
        return collection.stream()
                .filter(Predicate.not(String::isEmpty))
                .map(s -> s + "(" + s.length() + ")")
                .collect(Collectors.joining(", "));
    }


    /**
     * <b>Пример использования var</b>
     * <p><i>Использование var допустимо только в одном случае,
     * когда в этой же строчке происходит инстанцирование класса</i></p>
     */
    public void varProhibited(Integer number, List<Integer> list) {

        // определение TreeMap без var
        SortedMap<String, Function<?,?>> sortedMap = new TreeMap<>();
        // определение TreeMap с использованием var (допустимо)
        // В чём тут недостаток?
        var sortedMapWithVar = new TreeMap<String, Function<?,?>>();

        // Запрещено:
        var num = getNumber();
        var elements = getElements(num);
        // Как понять какой это тип?
    }

    /**
     * <b>Пример уменьшения вложенности условий (if)</b>
     * <p><i>В самом начале надо отбросить все неподходящие случаи и завершить
     * выполнение метода/цикла</i></p>
     */
    public void minimumNestingOfConditions(Collection<String> strings) {
        // Сразу отсекаем неподходящие случаи
        if (strings == null || strings.isEmpty()) {
            return;
        }
        // И основные действия делаем вне if'а
        strings.forEach(System.out::println);

        // А не так:
        if (strings != null && !strings.isEmpty()) {
            strings.forEach(System.out::println);
        }
    }






//    Вспомогательные методы
    private Long[] getElements(Long num) {
        return new Long[] {getNumber()};
    }

    private Long getNumber() {
        return 100L;
    }
}
