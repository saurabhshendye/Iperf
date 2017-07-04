package Transport;

/**
 * Created by Saurabh on 6/30/2017.
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class TCPSender
{
    private Socket socket;
    private DataOutputStream dout;
    private int time;
    private byte [] data = new byte[1000];
    private long count = 0;


    /**
     *
     * @param socket Client Socket connection
     * @param time Duration for which data needs to be sent
     * @throws IOException DataOutputStream Exception
     */
    public TCPSender(Socket socket, int time) throws IOException
    {
        this.socket = socket;
        this.dout = new DataOutputStream(this.socket.getOutputStream());
        this.time = time;
        new Random().nextBytes(data);
    }

    /**
     * Method will send the random data for the given duration
     * and then will Display the results
     * @throws IOException DataOutputStream Exception
     */
    public void sendData() throws IOException
    {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < time*1000)
        {
            dout.write(data);
            dout.flush();
            count++;
        }
        dout.close();
        this.printDetails();
    }

    /***
     * A method to display the results
     */
    private void printDetails()
    {
        double rate = count *1.0d/ time;
        System.out.println("Sent: " + count + " Kb" + " Rate:"
                + rate);
    }
}
