package Transport;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Saurabh on 6/30/2017.
 */
public class TCPReceiver extends Thread
{
    private Socket socket;
    private DataInputStream din;
    private long startTime;
    private long count;


    /**
     *
     * @param socket client socket created upon receiving the incoming
     *               connection request
     * @throws IOException If unable to create the data output stream
     */
    public TCPReceiver(Socket socket) throws IOException
    {
        this.socket = socket;
        this.din = new DataInputStream(this.socket.getInputStream());
        this.startTime = System.currentTimeMillis();
        this.count = 0;
    }


    /**
     * This method will receive the data until there is nothing left
     * Then it will calculate and display the data rate for the current
     * connection
     */
    public void run()
    {
        while (socket!=null)
        {
            try
            {
                byte [] data = new byte[1000];
                din.readFully(data);
                count++;
            }
            catch (IOException e)
            {
                long endTime = System.currentTimeMillis();
                double total = (endTime - this.startTime)/1000.0d;
                double rate = (count *1.0d) / total;
                System.out.println("Total data Received: " + count + " Kb"
                        + "Time: " + total + "sec" + "Data Rate: " + rate + " kbps");
                break;
            }
        }
    }
}
