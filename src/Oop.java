public class Oop {
    interface Vehicle {

        // all are the abstract methods.
        void changeGear(int a);
        void speedUp(int a);
        void applyBrakes(int a);
        default void display() {

            System.out.println("we are in display");
        }
    }

    static class Bicycle implements Vehicle {

        //
        int speed;
        int gear;

        // to change gear
        @Override
        public void changeGear(int newGear){

            gear = newGear;
        }

        // to increase speed
        @Override
        public void speedUp(int increment){

            speed = speed + increment;
        }

        // to decrease speed
        @Override
        public void applyBrakes(int decrement){

            speed = speed - decrement;
        }

        public void printStates() {
            System.out.println("speed: " + speed
                    + " gear: " + gear);
        }
    }

    static class Bike implements Vehicle {

        int speed;
        int gear;

        // to change gear
        @Override
        public void changeGear(int newGear){

            gear = newGear;
        }

        // to increase speed
        @Override
        public void speedUp(int increment){

            speed = speed + increment;
        }

        // to decrease speed
        @Override
        public void applyBrakes(int decrement){

            speed = speed - decrement;
        }

        public  void printStates() {
            System.out.println("speed: " + speed
                    + " gear: " + gear);
        }

    }


        public static void main (String[] args) {

            // creating an instance of Bicycle
            // doing some operations
            Vehicle bicycle = new Bicycle();
            bicycle.changeGear(2);
            bicycle.speedUp(3);
            bicycle.applyBrakes(1);

            System.out.println("Bicycle present state :");
            //bicycle.printStates(); // THIS IS NOT VALID since it is type Vehicle
            bicycle.display();

            // creating instance of the bike.
            Bike bike = new Bike();
            bike.changeGear(1);
            bike.speedUp(4);
            bike.applyBrakes(3);

            System.out.println("Bike present state :");
            bike.printStates();
        }
    }




