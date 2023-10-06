package hwSeminar3;
/*
. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
переданное число в интервал (25;100)
public boolean numberInInterval(int n) { … }

 */
public class SecondTask {

//    public boolean numberInInterval(int n) {
//        return n > 25 && n < 100;
//    }

        public boolean numberInInterval(int n, int min, int max) {
        return n > min && n < max;
    }

}
