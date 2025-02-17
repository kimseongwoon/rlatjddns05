namespace ConsoleApp1;

class Program
{
    static void Main(string[] args)
    {
        // 예약어(preserved), 키워드(keyword): c#에서 미리 사용하고 있는 단어
        int Main = 1;
        int main = 2;

        //int 1n;
        string \u0062ool = "true";

        // null키워드 사용하기
        string? text = null;        // 데이터 타입 제일 오른쪽에 '?'표시를 넣으면 null 사용
        int? a1 = 1;
        a1 = null;
        text = "null";

        Console.WriteLine("a1: " + a1);
        Console.WriteLine("text: " + text);

        string text1 = "";
        System.Int32 a2 = 1;

        // 데이터 타입의 기본값
        bool result;            // 이렇게 사용하지 마세요
        bool result1 = false;        // 변수 result1에는 false값이 들어 있다.
        result1 = false;
        Console.WriteLine("result1: " + result1);     // result1: false

        // 상수(변하지 않는 수 - const키워드): const가 붙은 변수명인 경우 값 수정시 error
        //   ex) 원의 넓이를 구할 때 파이(PI)=3.14
        const bool result2 = false;
        //result2 = false;

        const double PI = 3.14;
        //PI = 3.25;                // const로 선언을 해서 error

        const string jumin = "123456-1234567";
        //jumin = "234567-2345678"; // const로 선언을 해서 error

        const int n1 = 10 + 10;
        int n = Math.Max(n1, 5);        // 20, 5 중에서 큰 것은 20

        // 연산자(+, -, *, /, %)
        // %: 나누었을 때의 나머지
        int z1 = 3 % 2;         // 1
        Console.WriteLine("3 % 2의 나머지는 " + z1);
        int z2 = 4 % 2;
        Console.WriteLine("4 % 2의 나머지는 " + z2);

        int x1 = 3 / 2;
        Console.WriteLine("3 나누기 2의 값은 " + x1);     // 1
        double x2 = 3 / 2.0;    // 정수 / 정수 -> 정수,  실수 / 정수 -> 실수
        Console.WriteLine("3 나누기 2의 값은 " + x2);     // 1.5
        double x3 = 3 / (double)2;
        Console.WriteLine("3 나누기 2의 값은 " + x3);     // 1.5
    }
}