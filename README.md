# Iperfer
Java Program to perform Iperf between two network nodes

Makefile Directions:

make dir : to create dir called "bin"

make : to compile the code


Usage (for client mode): java iperf.iperfer -c -h <server hostname> -p <server port> -t <time>

Usage (for Server mode): java iperf.iperfer -s -p <listen port>

Port number should be between the range 1024 to 65536(including the end values)
