//package Control;
//
//import com.jcraft.jsch.JSchException;
//import java.io.IOException;
//
//public class ssh {
//    private static final String USERNAME = "cpcx86ktsizu";
//    private static final String HOST = "carlossolis.info";
//    private static final int PORT = 3306;
//    private static final String PASSWORD = "Cs19101293";
// 
//    public static void main(String[] args) throws IOException {
// 
//        try {
//            sshConxion sshConnector = new sshConxion();
//             
//             
//            sshConnector.connect(USERNAME,PASSWORD, HOST, PORT);
//            String result = sshConnector.executeCommand("ls -l");
//            sshConnector.disconnect();
//             
//            System.out.println(result);
//        } catch (JSchException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        }
//    }
//}
