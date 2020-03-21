using System;
using System.Windows.Forms;
using Logging;
using ChatLib;
using Unity;
using Castle.Windsor;
using Castle.MicroKernel.Registration;
using log4net;

[assembly: log4net.Config.XmlConfigurator(Watch =true)]

namespace Assignment_3
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// Using dependiency injection
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            //With Log4net Framwork
            log4net.ILog netLogger = log4net.LogManager.GetLogger(System.Reflection.MethodBase
                .GetCurrentMethod().DeclaringType);
            Logger logger = new Logger();
            log4net.ILog netLog = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);
            Client client = new Client(logger, netLog);

            //Container Declration using Unity
            UnityContainer container = new UnityContainer();
            container.RegisterInstance(client);
            container.RegisterInstance<ILoggingService>(logger);
            container.RegisterInstance<ILog>(netLog);

            //Container Declration using Castle Windsor
            //WindsorContainer container = new WindsorContainer();
            //container.Register(Component.For<Client>().ImplementedBy<Client>());
            //container.Register(Component.For<ILoggingService>().ImplementedBy<Logger>());
            //container.Register(Classes.FromThisAssembly().BasedOn<Form>());

            //Log4net register
            //container.Register(Component.For<ILog>().ImplementedBy<log4net.ILog>());

            Application.Run(container.Resolve<ChatForm>());

        }
    }
}
