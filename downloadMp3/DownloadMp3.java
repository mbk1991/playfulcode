import java.util.*;
import java.io.*;
import java.net.*;


public class DownloadMp3{
    static String testUrl = "https://youtu.be/k55xLARoSsU?si=qW3QmUUYozhSIFyo";
    static String sshId = "root";
    static String sshPw = "#@dltnstls00";
    static String sshIp = "192.168.10.209";
    static String sshPort = "22";
    static String sshPath = "/data";
    
    public static void main(String[] args){
        
        if(args.length > 0 && args[0].equals("-i")){
            Scanner sc = new Scanner(System.in);
            System.out.println("input YouTube link");
            testUrl = sc.next();

            System.out.println("input ssh id");
            sshId = sc.next();

            System.out.println("input ssh host");
            sshIp = sc.next();

            System.out.println("input ssh port");
            sshPort = sc.next();

            System.out.println("input ssh dst path");
            sshPath = sc.next();

        }
        
        try{
          File file = new File("./test_" +(int) (Math.random() * 100) + ".mp3");
          URL url = new URL(testUrl);
          HttpURLConnection con = (HttpURLConnection) url.openConnection();
          InputStream is = con.getInputStream();
          OutputStream os = new FileOutputStream(file);
            
          byte[] buff = new byte[4096];
          int len;
          while((len = is.read(buff)) > 0){
              os.write(buff, 0, len);
          }
          System.out.println("complete download");
          os.close();
          is.close();

          ProcessBuilder pb = new ProcessBuilder("scp","-P" + sshPort , file.getPath(), sshId+"@"+sshIp+":"+sshPath);
          Process ps = pb.start();

          try(BufferedReader br = new BufferedReader( new InputStreamReader(ps.getInputStream()))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
          }

          int exitCode = ps.waitFor();
          if(exitCode == 0){
              System.out.println("success");
          }else{
              System.out.println("fail");
          }
        }catch(Exception e){
        }
    }
}

