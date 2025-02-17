namespace ConsoleApp1;

class Program
{
    // 문제: 3의 배수 합 구하기(기회 제한)
    //    Q: 사용자로부터 0 이상의 숫자를 입력받아 3의 배수의 합을 계산하는 프로그램을 작성하세요.
    //       조건은 다음과 같습니다.
    //       (1) 사용자는 최대 10번의 입력 기회를 갖습니다 (while 사용).
    //       (2) 3의 배수가 아닌 경우 "3의 배수만 합산됩니다."를 출력하고 다음 입력을 받습니다 (continue 사용)
    //       (3) 사용자가 -1을 입력하면 반복을 종료합니다 (break 사용).
    //       (4) 10번의 입력 기회가 끝나면 최종 합을 출력하고 한 줄 띄워서 '프로그램 종료'라는 것도 출력
    static void Main(string[] args)
    {
        int tryCount = 1;   // 입력 기회 변수
        int sum = 0;        // 최종 합 변수

        while (tryCount++ <= 10)    // 10번의 입력 기회가 끝났을 경우 (1,4번 조건 만족)
        {
            string input = Console.ReadLine();   // 숫자 입력 받아서 input변수에 대입
            int number = int.Parse(input);       // input 문자로된 숫자를 사칙연산이 가능하도록 정수형으로 변환

            if (3 % number != 0)                 // 3의 배수가 아닌 경우에 실행  (2번 조건 만족)
            {
                Console.WriteLine("3의 배수만 합산됩니다.");
                continue;
            }

            if (number == -1)  // 사용자가 -1을 입력하면 while문을 나가도록 한다. (3번 조건 만족)
            {
                break;
            }

            sum = sum + number;
        }
        Console.WriteLine("3의 배수들의 합은 " + sum);
    }
}
