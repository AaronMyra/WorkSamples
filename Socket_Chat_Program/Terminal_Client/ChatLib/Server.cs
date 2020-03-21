using System;
using System.Net;
using System.Net.Sockets;

namespace ChatLib
{

    /// <summary>
    /// Class for the server which inherietes from user
    /// </summary>
    public class Server : User
    {

        TcpListener server = null;

        /// <summary>
        /// Listen on the port for a client & gets a stream
        /// </summary>
        public void ListenForClient()
        {
            this.client = server.AcceptTcpClient();
            this.stream = this.client.GetStream();
        }

        /// <summary>
        /// Establishes a sever and starts it
        /// </summary>
        public void EstablishServer()
        {
            try
            {
                IPAddress localAddress = IPAddress.Parse(this.ipAddress);
                this.server = new TcpListener(localAddress, this.port);
                server.Start();
            }
            catch(Exception)
            {
            }
        }

        /// <summary>
        /// Overridden method for closing connection
        /// </summary>
        public override void Close()
        {
            this.stream.Close();
            this.client.Close();
            this.server.Stop();
            Environment.Exit(0);
        }
    }
}
