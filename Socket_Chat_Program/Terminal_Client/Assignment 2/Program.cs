using System;
using System.Linq;
using System.Net.Sockets;
using System.Threading;
using ChatLib;

namespace Assignment_2
{
    class Program
    {

        // Looped Function that handles chat input and output
        public static void HandleChat(NetworkStream stream, User user, ConsoleColor ComplementaryColour, ConsoleColor OriginalColor)
        {
            string OutputMessage, InputMessage;
            while (true)
            {
                ConsoleKeyInfo KeyPressed;

                // Checks for key press
                if (Console.KeyAvailable)
                {
                    KeyPressed = Console.ReadKey();
                    if (KeyPressed.Key == ConsoleKey.I)
                    {
                        Console.Write(">> ");
                        InputMessage = Console.ReadLine();
                        user.SendMessage(InputMessage, stream);
                        if (InputMessage.ToLower() == "quit")
                        {
                            user.Close();
                        }
                    }
                }
                else
                {
                    // Checks for data stream input
                    OutputMessage = user.RecieveMessage(stream);
                    if (OutputMessage.ToLower() != "quit" && OutputMessage != "")
                    {
                        // Changes console text color 
                        Console.ForegroundColor = ComplementaryColour;
                        Console.WriteLine(OutputMessage);
                        Console.ForegroundColor = OriginalColor;
                    }

                    // Handles closing
                    if (OutputMessage.ToLower() == "quit")
                    {
                        user.Close();
                     }
                }
            }
        }

        static void Main(string[] args)
        {

            // Main server functions
            if (args.Contains("-server"))
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Server user = new Server();
                user.EstablishServer();
                Console.Write("Waiting for a connection ");
                for (int i = 0; i <= 5; i++)
                {
                    Console.Write(".");
                    Thread.Sleep(250);
                }
                user.ListenForClient();
                Console.WriteLine("Client Connected!\n"); 
                HandleChat(user.Stream, user, ConsoleColor.Cyan, ConsoleColor.Red);
            }

            // Main client functions
            else
            {
                Console.ForegroundColor = ConsoleColor.Cyan;
                Client user = new Client();
                if (!user.EstablishClient())
                {
                    Console.WriteLine("No server available");
                    Environment.Exit(1);
                }
                Console.WriteLine("Connected to server\n");
                HandleChat(user.Stream, user, ConsoleColor.Red, ConsoleColor.Cyan);  
            }
        }
    }
}
