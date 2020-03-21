using System;
using System.Net.Sockets;

namespace ChatLib
{
    /// <summary>
    /// Abstract for users which handles sending and receving messages over network stream
    /// </summary>
    abstract public class User
    {
        protected string name, ipAddress = "127.0.0.1";
        protected int port = 8080;
        protected TcpClient client;
        protected NetworkStream stream;
        Byte[] data = new Byte[600];
        Int32 bytes;

        public NetworkStream Stream 
        { 
            get { return this.stream; }
            set { this.stream = value; }
        }
        public TcpClient Client 
        {
            get { return this.client; }
            set { this.client = value; } 
        }

        /// <summary>
        /// Converts message into byte array and writes it to the stream
        /// </summary>
        /// <param name="message"></param>
        /// <param name="stream"></param>
        public void SendMessage(String message, NetworkStream stream)
        {
            try
            {
                this.data = System.Text.Encoding.ASCII.GetBytes(message);
                if (stream.CanWrite)
                {
                    stream.Write(data, 0, data.Length);
                }
            }
            catch (Exception)
            {
            }
        }

        /// <summary>
        /// Checks the stream for incomming data and returns it
        /// </summary>
        /// <param name="stream"></param>
        /// <returns></returns>
        public string RecieveMessage(NetworkStream stream)
        {
            try
            {
                string responseData = string.Empty;
                if (stream.CanRead && stream.DataAvailable)
                {
                    data = new Byte[600];
                    this.bytes = stream.Read(data, 0, data.Length);
                    responseData = System.Text.Encoding.ASCII.GetString(data, 0, bytes);
                    Array.Clear(this.data, 0, this.data.Length);
                }
                return responseData;
            }
            catch (Exception e)
            {
                return ("Error Occured: " + e);
            }
        }

        /// <summary>
        /// Declares an abstract method for closing connection
        /// </summary>
        public abstract void Close();
    }
}
