package mapreduce;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.Detect;

import java.io.IOException;


public class PreprocessMapper extends Mapper<LongWritable, Text, SecondarySort.MACTimePair, Text>{
    public static Log log = LogFactory.getLog(PreprocessMapper.class);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        log.info(line);

        line = Detect.Detect(line);
        String mac = Detect.getMac();
        String time = Detect.getTime();

        if(Detect.detectStatus == 1){
            SecondarySort.MACTimePair mtp = new SecondarySort.MACTimePair();
            mtp.set(mac,time);
            context.write(mtp, new Text(line));
        }
    }
}
