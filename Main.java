package Lesson1;

public class Main {
   public class Main {
        public static void main(String[] args) {
            Competitable[] competitors = {new Cat(1, 2), new Human(4, 5),
                    new Robot(4, 3)};

            Overcomable[] overcomables = {new Wall(10), new Road(2)};

            for (Competitable competitable : competitors) {
                for (Overcomable overcomable : overcomables) {
                    overcomable.overcome(competitable);
                }
            }
        }
    }

}
