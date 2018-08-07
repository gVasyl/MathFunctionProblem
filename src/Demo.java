public class Demo {
    public static void main(String[] args) {
        int x=4; int y=10; y=((++x>4 && x==5)? y+y: y);
        System.out.println(y);
    }
}
