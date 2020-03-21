using System;
using System.Net.Sockets;

namespace ChatLib
{
    public class Client : User
    {

        /// <summary>
        /// Overridden method for closing connection
        /// </summary>
        public override void Close()
        {
            this.stream.Close();
            this.client.Close();
            Environment.Exit(0);
        }

        /// <summary>
        /// Establishes a new client and gets the stream
        /// </summary>
        public bool EstablishClient()
        {
            try
            {
                this.client = new TcpClient(this.ipAddress, this.port);
                this.stream = this.client.GetStream();
                return true;
            }
            catch (Exception)
            {
                return false;
                
            }
        } 
    }
}

