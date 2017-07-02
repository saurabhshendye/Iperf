/*
 * Created by Saurabh on 6/30/2017.
 */
package iperf;

import Transport.TCPReceiver;
import Transport.TCPSender;
import util.argumentParser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class iperfer
{
    public static void main(String args[]) throws IOException
    {
        argumentParser parser = new argumentParser(args);
        if (parser.validityCheck())
        {
            if (parser.isClient())
            {
                Socket socket = new Socket(parser.ServerName, parser.port);
                TCPSender sender = new TCPSender(socket, parser.time);
                sender.sendData();
            }
            else
            {
                ServerSocket server = new ServerSocket(parser.port);
                Socket clientSocket = server.accept();
                TCPReceiver receiver = new TCPReceiver(clientSocket);
                receiver.start();
            }
        }
        else
        {
            System.exit(0);
        }
    }
}
