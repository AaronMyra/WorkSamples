using System;
using System.IO;
using System.Net.Sockets;
using Logging;
using log4net;

namespace ChatLib
{
    public class Client : User
    {
        /// <summary>
        /// Constructor method
        /// </summary>
        public Client(ILoggingService logger, ILog netLogger)
        {
            this.logger = logger;
            this.netLogger = netLogger;
        }

        /// <summary>
        /// Overridden method for closing connection
        /// </summary>
        public override void Close()
        {
            netLogger.Warn("Client disconnected from server");
            logger.Log(DateTime.Now + " Client disconnected from server");
            this.stream.Close();
            this.client.Close();
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
                netLogger.Info(DateTime.Now + " Client connected to server on " + this.ipAddress + ":" + this.port);
                logger.Log("Client connected to server on " + this.ipAddress + ":" + this.port);
                return true;
            }
            catch (Exception)
            {
                return false;
                
            }
        }
    }
}

