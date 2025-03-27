import java.io.*;

public class PortScanner{
    public static void main(String[] args){
        
        String ip = args[0];
        PortScanner ps = new PortScanner();

        int portMax = (int)Math.pow(2,16) - 1;

        System.out.println(portMax);

        int cntOpenPorts = 0;

        for(int i=0; i<= portMax; i++) {
            if( ps.portCheck(ip, i)){
                cntOpenPorts ++;
            }
        }

        System.out.println("Number Of Open Ports: " + cntOpenPorts);

    }

    private boolean portCheck(String ip, int port){
        try{
            ProcessBuilder pb = new ProcessBuilder("tcping",ip, port+"");
            Process ps = pb.start();

            BufferedReader br = ps.inputReader();
            
            StringBuilder sb = new StringBuilder();
            String buff = "";
            while((buff = br.readLine()) != null){
                sb.append(buff);
            }

            String result = sb.toString();
            if(result.contains("open")){
                System.out.println(result);
                return true;
            }else if(result.contains("close")){
                return false;
            }else{
                System.out.println(result);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
