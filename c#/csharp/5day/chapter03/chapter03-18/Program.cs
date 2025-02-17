namespace ConsoleApp1;

class Program
{
    static void Main(string[] args)
    {
        // 중첩 루프(다중 for문)
        for (int i = 0; i < 3; i++)
        {
            Console.Write("i:" + i + " -> ");   // 0 -> 
            Console.Write("j: ");
            for (int j = 0; j < 3; j++)
            {
                Console.Write(j + " "); // 0 1 2 
            }
            Console.WriteLine();
        }

        // 구구단
        for (int x = 2; x < 10; x++)
        {
            for (int y = 1; y < 10; y++)
            {
                Console.WriteLine($"{x} * {y} = {x * y}");
            }
            Console.WriteLine();
        }
        // 단이 넘어갔을 때 1줄 띄워보세요.

        // 구구단(열의 단 사이 넘어갔을 경우에는 \t를 활용)
        // 2 x 1 = 2   3 x 1 = 3...   9 x 1 = 9
        // 2 x 2 = 4   3 x 2 = 6...   9 x 2 = 18...
        // 2 x 9 = 18  3 x 9 = 27...   9 x 9 = 81
        for (int i = 1; i <= 9; i++)
        {
            for (int j = 2; j <= 9; j++)
            {
                Console.Write($"{j} x {i} = {j * i}\t");
            }
            Console.WriteLine();
        }

        // 정사각형 별 패턴
        //   Q. 사용자가 입력한 숫자 n을 기준으로 n x n 정사각형의 별 패턴을 출력하세요.
        //      이중 for문을 사용하여 별을 출력하세요.
        // 예시1: 정사각형의 크기를 입력하세요: 4
        //       ****
        //       ****
        //       ****
        //       ****
        // 예시2: 정사각형의 크기를 입력하세요: 3
        //       ***
        //       ***
        //       ***
        // 예시1: 정사각형의 크기를 입력하세요: 2
        //       **
        //       **
        Console.WriteLine("정사각형의 크기를 입력하세요:");
        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                Console.Write("*");
            }
            Console.WriteLine();
        }

        // Console.Write("*")와 Console.WriteLine() 한번만 이용하고 이중 for문으로 구현
        // *
        // **
        // ***
        // ****
        // *****

        // 이중 for문 이용해서 아래와 같이 출력
        // 1 + 1 = 2   1 + 2 = 3   1 + 3 = 4   1 + 4 = 5
        // 2 + 1 = 3   2 + 2 = 4   2 + 3 = 5   2 + 4 = 6
        // 3 + 1 = 4   3 + 2 = 5   3 + 3 = 6   3 + 4 = 7
        // 4 + 1 = 5   4 + 2 = 6   4 + 3 = 7   4 + 4 = 8

    }
}