package mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.xml.soap.Text;
import java.io.IOException;

public class PreprocessMapReduce {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println("正在运行");
        Configuration config = new Configuration();
        Job job = new Job(config,"preprocessing");
        job.setJarByClass(PreprocessMapReduce.class);
        job.setMapperClass(PreprocessMapper.class);
        job.setReducerClass(PreprocessReducer.class);
        job.setMapOutputKeyClass(SecondarySort.MACTimePair.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path(Config.HDFSINPUTPATH));
        FileOutputFormat.setOutputPath(job, new Path(Config.HDFSOUTPUTPATH));

    }
}
