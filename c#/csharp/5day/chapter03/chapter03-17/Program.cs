namespace ConsoleApp1;

class Program
{
    static void Main(string[] args)
    {
        // foreach문 -> 배열일 때 많이 사용
        // foreach 문법
        //   foreach(배열값을받을변수 in 표현식)
        //     구문;
        //  혹은
        //   foreach(배열값을받을변수 in 표현식) 구문;
        int[] arr = { 1, 2, 3, 4, 5 };
        foreach (int elem in arr)
        {
            Console.Write(elem + ", ");  // 1, 2, 3, 4, 5,
        }
        string[] arrStr = { "나는", "학교에", "간다" };
        foreach (string elem in arrStr)
        {
            Console.Write(elem + " ");  // 나는 학교에 간다.
        }
        foreach (string elem in arrStr)
        {
            Console.Write($"{elem}({elem.Length}개 글자) ");  // 나는(2개 글자) 학교에(3개 글자) 간다(2개 글자)
        }

    }
}