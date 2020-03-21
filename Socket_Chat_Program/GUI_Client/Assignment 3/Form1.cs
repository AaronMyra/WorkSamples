using System;
using System.Threading;
using System.Windows.Forms;
using TaskLib;
using ChatLib;

namespace Assignment_3
{
    public partial class Form1 : Form
    {

        private Client client = new Client();

        public Form1()
        {
            Executor.Messager += new TaskLib.MessageHandler(Executor_Message);
            InitializeComponent();

        }

        //Connect Menu Item
        private void connectMenuItem_Click(object sender, EventArgs e)
        {
            client = new Client();
            if (client.EstablishClient()){
                ConnectActions();
                Thread receiveMsgThread = new Thread(Executor.Message);
                receiveMsgThread.Name = "Receive Message Thread";
                receiveMsgThread.Start();
            }
            else
            {
                convoTextBox.Text = "Could not connect to sever";
            }
        }

        //Disconnect Menu Item
        private void disconnectMenuItem_Click(object sender, EventArgs e)
        {
            DisconnectActions();
            client.Close();
        }

        //Send Message Button
        private void sendButton_Click(object sender, EventArgs e)
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

        private void Executor_Message()
        {
            ReceiveMessageActions();
        }

        //Exit Menu Item
        private void exitMenuItem_Click(object sender, EventArgs e)
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
            convoTextBox.AppendText(">> " + msgTextBox.Text + "\n");
            msgTextBox.Text = "";
        }

        public void ConnectActions()
        {
            convoTextBox.Text = "Connected To Server\n";
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
        }
    }
}
