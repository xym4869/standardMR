package mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class PreprocessMapReduce {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        Configuration config = new Configuration();
        Job job = Job.getInstance(config, "preprocess");
        job.setJarByClass(PreprocessMapReduce.class);
        job.setMapperClass(PreprocessMapper.class);
        job.setReducerClass(PreprocessReducer.class);
        job.setNumReduceTasks(1);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path(Config.HDFSINPUTPATH));
        FileOutputFormat.setOutputPath(job, new Path(Config.HDFSOUTPUTPATH));
        FileSystem.get(config).delete(new Path(Config.HDFSOUTPUTPATH), true);
        boolean b = job.waitForCompletion(true);
        
        if(!b) {
            System.err.println("This task has failed!!!");
        }
    }
}
