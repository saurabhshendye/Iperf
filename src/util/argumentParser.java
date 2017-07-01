package util;


/**
 * Created by Saurabh on 6/19/2017.
 */
public class argumentParser
{
    private boolean clientFlag;
    private String [] args;
//    private boolean validFlag = false;
    private String ServerName = null;
    private int port;
    private int time;

    /**
     *
     * @param args command-line input arguments to be parsed
     */
    public argumentParser(String [] args)
    {
        this.args = args;
    }

    /**
     * Determines the validity of the arguments passed
     * @return true if valid, false otherwise
     */
    public boolean validityCheck()
    {
        if (args[0].equals("-c"))
        {
            this.clientFlag = true;
            if (args.length == 7)
            {
                int i = 1;
                while (i < args.length && args[i].startsWith("-"))
                {
                    switch (args[i])
                    {
                        case "-h":
                            this.ServerName = args[i++];
                            break;
                        case "-p":
                            this.port = Integer.parseInt(args[i++]);
                            break;
                        case "-t":
                            this.time = Integer.parseInt(args[i++]);
                            break;
                        default:
                            this.printUsage();
                            return false;

                    }
                }

                if (port <= 1024 || port > 65536)
                {
                    this.printUsage();
                    return false;
                }
                return true;
            }
            else
            {
                this.printUsage();
                return false;
            }
        }
        else if (args[0].equals("-s"))
        {
            this.clientFlag = false;
            // Port number has to be between 1025 to 65536
            if (args.length == 3 && args[1].equals("-p")
                    && Integer.parseInt(args[2]) > 1024
                    && Integer.parseInt(args[2]) <= 65536)
            {
                this.port = Integer.parseInt(args[2]);
            }
            else
            {
                this.printUsage();
                return false;
            }
            return true;
        }
        else
        {
            this.printUsage();
            return false;
        }
    }

    /**
     * Prints the usage information of the tool
     */
    private void printUsage()
    {
        System.out.println("Invalid Arguments");
        System.out.println("Usage (for client mode): java iperfer -c -h <server hostname>" +
                " -p <server port> -t <time>");
        System.out.println("Usage (for Server mode): java Iperfer -s -p <listen port>");
        System.out.println("Port number should be between the range 1025 to 65536" +
                "(including the end values)");
    }

    public boolean isClient()
    {
        return clientFlag;
    }
}
