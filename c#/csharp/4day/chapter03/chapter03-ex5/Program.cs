namespace ConsoleApp1;

class Program
{
    // 문제: 숫자 맞추기 게임
    //    Q. 1부터 50 사이의 무작위 숫자를 생성하고
    //        사용자가 그 숫자를 맞출 때까지 반복하는 게임을 작성하세요.
    //        조건은 다음과 같습니다.
    //        (1) 사용자가 맞출 때까지 반복해야 합니다.
    //        (2) 사용자가 숫자를 잘못 입력하면 "올바른 숫자를 입력하세요"를 출력하고 다시 입력을 받습니다 (continue 사용).
    //        (3) 사용자가 -1을 입력하면 게임을 종료합니다 (break 사용).
    //        (4) 만약 랜덤한 숫자가 사용자가 입력한 숫자보다 크면 "더 작은 숫자를 입력하세요"라고 출력
    //        (5) 만약 랜덤한 숫자가 사용자가 입력한 숫자보다 작으면 "더 큰 숫자를 입력하세요"라고 출력

    // 예시1 (랜덤 숫자(targetNumber)는 26이라고 가정)
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): 10
    // 더 큰 숫자를 입력하세요.
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): 30
    // 더 작은 숫자를 입력하세요
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): 28
    // 더 작은 숫자를 입력하세요
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): 26
    // 정답입니다.

    // 예시2 (랜덤 숫자(targetNumber)는 26이라고 가정)
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): 12
    // 더 큰 숫자를 입력하세요.
    // 1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력): -1
    // 게임을 종료합니다.

    static void Main(string[] args)
    {
        Random random = new Random();
        int targetNumber = random.Next(1, 51); // 1부터 50 사이의 무작위 숫자

        while (true)        // 맞출 때까지 계속 실행. 맞추면 break문으로 빠져나오도록...
        {
            Console.WriteLine("1부터 50 사이의 숫자를 맞춰보세요 (종료하려면 -1 입력):");
            // 코드 작성
            string input = Console.ReadLine();

            int tryOut = 0;
            bool isDigit = int.TryParse(input, out tryOut);  // input값이 숫자이면 true이면 문자이면 false
            if (!isDigit)        // 숫자가 아니면
            {
                Console.WriteLine("올바른 숫자를 입력하세요");
                continue;
            }

            int inputNumber = int.Parse(input);
            if (inputNumber == targetNumber)
            {
                Console.WriteLine("정답입니다.");
                break;
            }

            if (inputNumber == -1)
            {
                Console.WriteLine("게임을 종료합니다.");
                break;
            }
            if (inputNumber > targetNumber)
            {
                Console.WriteLine("더 작은 숫자를 입력하세요");
                continue;
            }
            if (inputNumber < targetNumber)
            {
                Console.WriteLine("더 큰 숫자를 입력하세요");
                continue;
            }

        }
    }
}
