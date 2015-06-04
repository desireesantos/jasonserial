//import jssc.SerialPort;
//import jssc.SerialPortEvent;
//import jssc.SerialPortEventListener;
//import jssc.SerialPortException;
import jssc.*;

public class SerialCommunication {
    static SerialPort serialPort;
    private static String result ="";
   
    public SerialCommunication() {	
    	
        serialPort = new SerialPort("/dev/tty.usbmodem1411");
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            int mask = SerialPort.MASK_RXCHAR;
            serialPort.setEventsMask(mask);
            serialPort.addEventListener(new SerialPortReader());
           
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }

    static class SerialPortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR()) {
                try {
                    byte buffer[] = serialPort.readBytes(4);
                    result = new String(buffer);
                    System.out.println("Read: " + result);
                } catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }

        }
    }
    
    public String msg(){
    	return result;
    }
}
