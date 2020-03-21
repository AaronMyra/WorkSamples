using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ChatLib;

namespace TaskLib
{
    public class Executor
    {
        //Bublic flag to disconnect
        public static volatile bool Disconnect = false;

        //Event Handlers
        public static event SendMessageHandler SendMessages;
        public static event RecieveMessageHandler ReceiveMessages;

        public static void SendMessage(string p_message)
        {
            if (SendMessages != null)
            {
                SendMessages();
            }
        }

        public static void ReceiveMessage()
        {
            if (!Disconnect)
            {
                if (ReceiveMessages != null)
                {
                    ReceiveMessages();
                }
            }
        }
    }
}
