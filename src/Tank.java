
public class Tank {

    private int x, y, direction, fuel, n; // положительное направление х - вправо, положительное направление у - вниз.
    private static int tankCounter;
    static final String MODEL = "T-34";

    public Tank(int a,int b, int f) { //конструктор со всеми параметрами
        x = a;
        y = b;
        fuel = f;
        n = ++tankCounter;
    }

    public Tank() { // конструктор по умолчанию
        this(0, 0, 100);
    }

    public Tank(int a, int b) { //конструктор с возможностью указания координат и уровнем топлива по умолчанию
        this(a, b, 100);
    }

    public void goForward(int i) {
        // Начальное значение direction равное 0 соответствует положительному направлению по x. изменяется по часовой стрелке
        if(Math.abs(i) > fuel && i < 0) i = -fuel;
        else if(Math.abs(i) > fuel && i > 0) i = fuel;
        if(direction == 0) x += i;
        else if(direction == 1) y += i;
        else if(direction == 2) x -= i;
        else y -= i;
        fuel -= Math.abs(i);
    }

    public void printPosition() {
        System.out.println("The Tank " + MODEL + "-" + n + " is at " + x + ", " + y + " now.");
    }


    public void goBackward(int i) {
        if(Math.abs(i) > fuel && i < 0) i = -fuel;
        else if(Math.abs(i) > fuel && i > 0) i = fuel;
        if(direction == 0) x -= i;
        else if(direction == 1) y -= i;
        else if(direction == 2) x += i;
        else y += i;
        fuel -= Math.abs(i);
    }

    public void turnRight() {
        direction++;
        if(direction == 4) {
            direction = 0; // при выходе за пределы допустимых значений, принудительно возвращаем в область.
        }
    }

    public void turnLeft() {
        direction--;
        if(direction == -1) {
            direction = 3; // при выходе за пределы допустимых значений, принудительно возвращаем в область.
        }
    }
}
