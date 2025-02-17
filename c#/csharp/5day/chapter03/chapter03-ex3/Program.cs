namespace ConsoleApp1;

class Program
{
    // 문제: FizzBuzz 출력
    //   Q: 1부터 50까지의 숫자를 출력하되
    //       (1) 3의 배수일 경우 "Fizz" 출력, 5의 배수일 경우 "Buzz" 출력
    //       (2) 3과 5의 공배수(같은 배수)일 경우 "FizzBuzz"를 출력. ex) 3과 5의 공배수는 15, 30, 45, ...
    //       (3) 나머지 숫자는 그대로 출력
    //       (4) for문과 if ~ else if ~ else문 이용
    static void Main(string[] args)
    {
        // 코드 작성
        for (int i = 1; i <= 50; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                Console.WriteLine("FizzBuzz");
            }
            else if (i % 5 == 0)
            {
                Console.WriteLine("Buzz");
            }
            else if (i % 3 == 0)
            {
                Console.WriteLine("Fizz");
            }
            else
            {
                Console.WriteLine(i);
            }
        }

    }
}
