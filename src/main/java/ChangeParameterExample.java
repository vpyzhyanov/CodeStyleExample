import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Примеры с изменением параметров функции
 *
 * @author Пыжьянов Вячеслав
 * @since 25.04.2024
 */
public class ChangeParameterExample {

    /**
     * НЕПРАВИЛЬНЫЙ вариант №1
     * <p>Объединить две Map в одну</p>
     */
    public <T, V> void unionWrong1(Map<T, V> map1, Map<T, V> map2) {
        // Очень плохо! Пользователь может не ожидать, что у него изменится один из параметров
        map1.putAll(map2);
    }

    /**
     * НЕПРАВИЛЬНЫЙ вариант №2 (уже чуть лучше)
     * <p>Объединить две Map в одну</p>
     */
    public <T, V> void unionWrong2(Map<T, V> map1, Map<T, V> map2, Map<T, V> result) {
        // Тоже плохо, т.к. ответственность за создание итоговой Map вынесена наружу
        result.putAll(map1);
        result.putAll(map2);
    }

    /**
     * Правильный вариант
     * <p>Объединить две Map в одну</p>
     */
    public <T, V> Map<T, V> union(Map<T, V> map1, Map<T, V> map2) {
        /*
         Обратите внимание, что создаётся Map сразу нужного размера,
         притом с учётом load factor, следовательно не произойдёт увеличения
         размера коллекции во время добавления элементов
        */
        Map<T, V> result = HashMap.newHashMap(map1.size() + map2.size());
        result.putAll(map1);
        result.putAll(map2);
        return result;
    }

    /**
     * Реальный пример, когда необходимо изменить переданный аргумент
     * <p>Добавляет объект в коллекцию</p>
     * @param collection коллекция, <b>в которую добавится объект</b>
     * @param object добавляемый объект, может быть либо коллекцией&lt;T&gt; либо объектом типа T
     */
    @SuppressWarnings("unchecked")
    public static <T> void add(Collection<T> collection, Object object) {
        if (object instanceof Collection) {
            collection.addAll((Collection<T>)object);
        }
        else {
            collection.add((T)object);
        }
    }
}
