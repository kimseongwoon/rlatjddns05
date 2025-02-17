// 실수형 기본 타입 
// 1) float -> 4byte(2의 32승)
// 2) double -> 8byte(2의 64승)
// 3) decimal -> 16byte(2의 128승) 

namespace ConsoleApp1;

class program
{

    static void Main(string[] args)
    {
        float f = 5.2f;  // 기본적으로 소수점은 double -> float으로 바꾸려면 숫자 마지막 뒤에 'f'를 넣어야 함 
        double d = 10.5;
        decimal money = 200.099m;

        Console.WriteLine(f);
        Console.WriteLine(d);
        Console.WriteLine(money);

        // 문제1.다음과 같은 변수를 선언하고 올바르게 초기화하시오 
        //    (1) 정수형 변수 age에 25 할당하고 출력하는 코드 작성 
        //    (2) 소수점 값을 가지는 height변수에 175.5할당 
        ushort age = 25;
        float height = 175.5f;

        // 문제2. 아래 코드에서 오류를 찾아 수정하시오.
        short num = 300;
        double result = num + 100.5;
    }
}
