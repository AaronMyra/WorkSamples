using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChatLib
{
    public class Log
    {
        private string path;

        public Log()
        {
            path = "C:\\Users\\Student\\source\\repos\\Aaron_Myra\\Assignments\\Assignment 3_V2\\Logs\\" + DateTime.Now.Hour.ToString() + "_" + DateTime.Now.Minute.ToString() + "_log.txt";
            if (File.Exists(path))
            {
                File.Delete(path);
            }
        }

        public void WriteToLog(string message)
        {
            try
            {
                using(StreamWriter sWriter = File.AppendText(path))
                {
                    LogMessage(message, sWriter);
                }
            }catch(Exception e)
            {
                using(StreamWriter sWriter = File.AppendText(path))
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
