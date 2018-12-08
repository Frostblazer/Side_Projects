using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    //Hello World Program

    class Program
    {
        static void Main(string[] args)
        {
            string userName = "";
            int userAge = 0;
            int currentYear = 0;

            Console.Write("Please enter your name: ");
            userName = Console.ReadLine();
            Console.WriteLine("Hello " + userName + "!");
            Console.Write(userName + ", Please enter your age: ");
            userAge = Convert.ToInt32(Console.ReadLine());
            Console.Write(userName + " Please enter the current year: ");
            currentYear = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Your name is " + userName+ ". The current year is " + currentYear);
        }
    }
}
