using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskLib
{
    class CustomEventArgs
    {
        private string message;

        public CustomEventArgs(string p_Message)
        {
            this.message = p_Message;
        }

        public string Message
        {
            get { return this.message; }
        }
    }
}
