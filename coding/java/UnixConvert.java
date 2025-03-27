import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.Instant;

public class UnixConvert{
    public static void main(String[] args){
        

        if(args.length == 1){
            long epochTime = Long.parseLong(args[0]);

            Instant instant = Instant.ofEpochMilli(epochTime);
            LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneOffset.of("+09:00"));
            String strTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                
            System.out.println(strTime);

        }


    }
}
