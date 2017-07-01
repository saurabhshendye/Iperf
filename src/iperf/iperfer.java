/*
 * Created by Saurabh on 6/30/2017.
 */
package iperf;

import util.argumentParser;

public class iperfer
{
    public static void main(String args[])
    {
        argumentParser parser = new argumentParser(args);
        if (parser.validityCheck())
        {
            if (parser.isClient())
            {

            }
            else
            {

            }
        }
        else
        {
            System.exit(0);
        }
    }
}
