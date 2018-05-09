package com.euphe.filter;

import com.euphe.filter.mr.Config;
import com.euphe.filter.mr.PreprocessingMapper;
import com.euphe.filter.mr.PreprocessingReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class StandardJob {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		System.out.println("正在运行");
        Configuration config = new Configuration();
        Job job = Job.getInstance(config, "preprocess");
        job.setJarByClass(StandardJob.class);
        job.setMapperClass(PreprocessingMapper.class);
        job.setReducerClass(PreprocessingReducer.class);
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
        System.out.println("运行完成");
    }
}
