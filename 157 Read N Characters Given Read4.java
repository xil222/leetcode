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
    public int read(char[] buf, int n) {
        int readPtr = 0; //pointer for buf
        int readCnt = 0; //cnt for filling each read4 buffer
        char[] buff = new char[4];
        int read4Cnt = read4(buff);
        while (readCnt < read4Cnt && readPtr < n) { //hidden condition readCnt < read4Cnt
            buf[readPtr++] = buff[readCnt++];
            if (read4Cnt == readCnt) {
                readCnt = 0;
                read4Cnt = read4(buff);
            }
        }
        return readPtr;
    }
}