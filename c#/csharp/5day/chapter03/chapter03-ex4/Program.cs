namespace ConsoleApp1;

class Program
{
    static void Main(string[] args)
    {
        // 문제1: 문자열 배열에서 길이가 4 이상인 문자열 출력
        //   Q: 아래과 같은 문자열 배열이 주어졌을 때,
        //      foreach문, if문을 사용하여 길이가 4 이상인 문자열을 출력하세요.
        string[] words = { "cat", "dog", "elephant", "lion", "tiger" };
        // 코드 작성
        foreach (string word in words)
        {
            if (word.Length >= 4)
            {
                Console.WriteLine(word); // elephant, lion, tiger
            }
        }

        // 문제2: 배열의 최대값 찾기
        //    Q: 아래와 같은 정수 배열이 주어졌을 때,
        //       foreach문, if문을 사용하여 최대값을 찾아 출력하세요.
        int[] numbers = { 34, 67, 23, 89, 12, 90 };
        int max = numbers[0];   // 34
        // 코드 작성
        foreach (int number in numbers)
        {
            if (number > max)
            {
                max = number;
            }
        }
        Console.WriteLine(max);  // 89

        // 1차원 int배열에서 최소값 구하기
        int min = numbers[0];
        foreach (int number in numbers)
        {
            if (number < min)
            {
                min = number;
            }
        }
        Console.WriteLine(max);  // 89
    }
}