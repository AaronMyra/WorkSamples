using System;
using System.Threading;
using System.Windows.Forms;
using TaskLib;
using ChatLib;
using Logging;
using log4net;

namespace Assignment_3
{
    public partial class ChatForm : Form
    {
        private Client client;
        private ILoggingService logging;
        private ILog netLog;
        private Thread receiveMsgThread;

        public ChatForm(ILoggingService logging, Client client)
        {
            Executor.ReceiveMessages += new TaskLib.RecieveMessageHandler(Executor_ReceiveMessage);
            InitializeComponent();
            this.logging = logging;
            this.client = client;
        }

        //Connect Menu Item
        private void ConnectMenuItem_Click(object sender, EventArgs e)
        {
            //client = new Client();
            if (client.EstablishClient()){
                ConnectActions();
                this.receiveMsgThread = new Thread(Executor.ReceiveMessage);
                receiveMsgThread.Name = "Receive Message Thread";
                receiveMsgThread.Start();
            }
            else
            {
                convoTextBox.Text = "Could not connect to sever";
            }
        }

        //Disconnect Menu Item
        private void DisconnectMenuItem_Click(object sender, EventArgs e)
        {
            DisconnectActions();
            client.Close();
        }

        //Send Message Button
        private void SendButton_Click(object sender, EventArgs e)
        {
            if (msgTextBox.Text != "")
            {
                if (InvokeRequired)
                {
                    MethodInvoker sendInvoker = new MethodInvoker(delegate ()
                    {
                        SendMessageActions();
                    });
                    msgTextBox.BeginInvoke(sendInvoker);
                }
                else
                {
                    SendMessageActions();
                }
            }
        }

        private void Executor_ReceiveMessage()
        {
            ReceiveMessageActions();
        }

        //Exit Menu Item
        private void ExitMenuItem_Click(object sender, EventArgs e)
        {
            if (disconnectMenuItem.Enabled == false)
            {
                Environment.Exit(0);
            }
            else
            {
                DisconnectActions();
                client.Close();
                Environment.Exit(0);
            }
        }

        public void ReceiveMessageActions()
        {
            do
            {
                if (client.Stream.DataAvailable)
                {
                    if (InvokeRequired)
                    {
                        MethodInvoker receiveMsgInvoker = new MethodInvoker(delegate ()
                        {
                            string output = client.RecieveMessage(client.Stream);
                            convoTextBox.AppendText(output + "\n");
                        });
                        convoTextBox.Invoke(receiveMsgInvoker);
                    }
                    else
                    {
                        string output = client.RecieveMessage(client.Stream);
                        convoTextBox.AppendText(output + "\n");
                    }
                }
            } while (!Executor.Disconnect);
        }

        public void SendMessageActions()
        {
            client.SendMessage(msgTextBox.Text, client.Stream);
            convoTextBox.AppendText(">> " + msgTextBox.Text);
            convoTextBox.AppendText(Environment.NewLine);
            msgTextBox.Text = "";
        }

        public void ConnectActions()
        {
            convoTextBox.Text = "Connected To Server";
            convoTextBox.AppendText(Environment.NewLine);
            disconnectMenuItem.Enabled = true;
            connectMenuItem.Enabled = false;
            sendButton.Enabled = true;
            Executor.Disconnect = false;
        }

        public void DisconnectActions()
        {
            convoTextBox.AppendText("Disconnected");
            disconnectMenuItem.Enabled = false;
            connectMenuItem.Enabled = true;
            Executor.Disconnect = true;
            if (receiveMsgThread != null)
            {
                receiveMsgThread.Join();
            }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            DisconnectActions();
        }
    }
}
