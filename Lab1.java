public class Main {
    public static void main(String args[]) {
        Main lab1 = new Main();
        lab1.compulsory();
        lab1.homework(args);
    }
    void compulsory() {
        System.out.println("Hello world!");

        String[] languages = { "C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n = n * 3;
        n = n + 0b10101;
        n = n + 0XFF;
        n = n * 6;
        System.out.println(n);

        int sum=0;
        int digit=0;
        while (sum >= 10 || n>0) {
            if(n == 0) {
                n = sum;
                sum = 0;
            }
            digit = n % 10;
            sum = digit + sum;
            n = n / 10;
        }
        int result = sum;
        System.out.println(result);

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }
    void homework(String args[]) {
        long startTime = System.nanoTime();
        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        String n = args[0];

        try
        {
            Integer.parseInt(n);
            System.out.println(n + " is a valid integer");
            int a= Integer.parseInt(n);
            printLatin(a);

        }


        catch (NumberFormatException e)
        {
            System.out.println(n + " is not a valid integer");
            long endTime = System.nanoTime();

            long time = endTime - startTime;

            System.out.println("Execution time in nanoseconds: " + time);
            System.out.println("Execution time in milliseconds: " + time / 1000000);

        }
    }
    static void printLatin(int a)
    {
        int[][] array;
        array = new int[100][100];

        for (int i = 1; i <= a; i++)
        {
            int b=i;
            for (int j = 1; j <= a; j++)
            {
                if(b<=a){
                    array[i][j]=b;
                    System.out.print(array[i][j]);

                }
                else {
                    int c=b-a;
                    array[i][j]=c;
                    System.out.print(array[i][j]);
                }
                b=b+1;
            }
            System.out.println();
        }
    }

}
