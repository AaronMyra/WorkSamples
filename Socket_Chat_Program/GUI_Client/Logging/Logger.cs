using System;
using System.IO;
using Logging;


/// <summary>
/// Class for loggin client server messages
/// </summary>

namespace Logging
{
    public class Logger : ILoggingService
    {
        private string path = "C:\\Users\\Student\\source\\repos\\Aaron_Myra\\Assignments\\Assignment 4\\Logs\\" + DateTime.Now.Hour.ToString() + "_" + DateTime.Now.Minute.ToString() + "_log.txt";

        public Logger()
        {
            if (File.Exists(path))
            {
                File.Delete(path);
            }
        }

        public void Log(string message)
        {
            try
            {
                using (StreamWriter sWriter = File.AppendText(path))
                {
                    LogMessage(message, sWriter);
                }
            }
            catch (Exception e)
            {
                using (StreamWriter sWriter = File.AppendText(path))
                {
                    LogMessage("Error Occurred: " + e, sWriter);
                }
            }
        }

        private void LogMessage(string message, TextWriter txtWriter)
        {
            txtWriter.WriteLine(DateTime.Now.ToLongTimeString() + ": " + message);
        }
    }
}

