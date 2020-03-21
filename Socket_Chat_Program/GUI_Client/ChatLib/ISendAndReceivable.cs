using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace ChatLib
{
    public interface ISendAndReceivable
    {
        void SendMessage(String message, NetworkStream stream);

        string RecieveMessage(NetworkStream stream);
    }
}
