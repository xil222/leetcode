/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int read4ptr = 0;
    private int read4cnt = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        //use pointer to record number of digits read
        int ptr = 0;
        while (ptr < n) {
            //because we may call functions multiple times
            //only read more when read4ptr has been reset
            //ow, we can use the chars that was in bucket
            if (read4ptr == 0) {
                read4cnt = read4(buff);
            }

            if (read4cnt == 0) break;

            //put the read data from buffer to read4 buffer
            //set 2 conditions to
            //prevent when read4cnt is full but we just want to read
            //characters less than that
            while (ptr < n && read4ptr < read4cnt) {
                buf[ptr++] = buff[read4ptr++];
            }

            //reset ptr4 to 0 when finishes the read
            if (read4ptr == read4cnt) {
                read4ptr = 0;
            }
        }
        return ptr;
    }
}