import java.lang.Exception;

class InvalidRadiusException extends Exception {

        private double r;

        public InvalidRadiusException(double radius){
                r = radius;
		}

        public InvalidRadiusException(String s){
                super(s);


        }
        public void printError(){
              System.out.println("Radius [" +  r + "] is not valid");
        }
}


class Circle
{
        double x, y, r;

        public Circle (double centreX, double centreY, double radius ) throws InvalidRadiusException
        {
                if (r <= 0 )
                {
                       throw new InvalidRadiusException("Radius tidak boleh negatif ..");
                }
                else
                {
                        x = centreX ; y = centreY;  r = radius;
                }
         }
}

public class CircleTest {
        public static void main(String[] args) {
                try {
                        Circle c1 = new Circle(10, 10, -1);
                        System.out.println("Circle created");
                }
                catch(InvalidRadiusException e)
                {
                        System.out.println(e.getMessage());
                        e.printError();
                        e.printStackTrace();
                }
        }
}
