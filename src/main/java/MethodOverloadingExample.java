/**
 * Как правильно реализовать перегрузку методов для классов связанных наследованием
 *
 * @author Пыжьянов Вячеслав
 * @since 25.04.2024
 */
public class MethodOverloadingExample {
    public class A {}
    public class B extends A {}
    public class C {}

    public void method(A a) {
        // Сначала самые вложенные классы
        if (a instanceof B) {
            System.out.println("B");
        }
        System.out.println("A");
    }

    public void method(C c) {
        System.out.println("C");
    }

    /**
     * Должно быть разное поведение для разных классов
     */
    public void test() {
        A a = new A();
        A b = new B();
        C c = new C();
        method(a); // Напечатает A
        method(b); // Напечатает B
        method(c); // Напечатает C
    }
}
