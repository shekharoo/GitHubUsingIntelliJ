public class Practice {

    static int i = 30;
    int j = 10;
    //int i = 50;
    public void display()
    {
        //i=60;
        Practice p = new Practice();
        System.out.println("i value: "+i);
        // System.out.println("i value: "+Practice.i);
        System.out.println("i value: "+p.j);
        //System.out.println("i value: "+this.i);
    }
    {
        System.out.println("i value: "+Practice.i);
        System.out.println("j value: "+j);
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        //p.display();
//        System.out.println("======Main======");
        //System.out.println("i value: "+p.i);
//        System.out.println("i value: "+Practice.i);

    }
}
