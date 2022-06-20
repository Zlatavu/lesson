package Lesson3;

import java.util.Arrays;

    public class Main {

        public static void main(String[] args) {
            Box<Apple> appleBox = new Box<>();
            appleBox.addFruit(new Apple(1));
            appleBox.addFruit(new Apple(1));
            appleBox.addFruit(new Apple(1));
            System.out.println(appleBox.getWeight());

            Box<Apple> appleBox2 = new Box<>();
            appleBox.addFruit(new Apple(1));
            appleBox.addFruit(new Apple(1));

            appleBox.pourOver(appleBox2);
            System.out.println(appleBox.getFruitList());
            System.out.println(appleBox2.getFruitList());
        }

        public static void changeArrElements(Object[] array, int a, int b) {
            Object tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
    }
}
