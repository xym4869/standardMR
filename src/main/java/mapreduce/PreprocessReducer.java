package mapreduce;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.StringListTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreprocessReducer extends Reducer<SecondarySort.MACTimePair, Text, NullWritable, Text>{
    public static Log log = LogFactory.getLog(PreprocessReducer.class);

    protected void reduce(SecondarySort.MACTimePair key, Iterable<Text> values, Reducer.Context context) throws IOException, InterruptedException {
        try {
            String line = "";
            String result = "";
            List<String> resultList = new ArrayList<String>();
            for (Text value : values) {
                line = value.toString();
                if (line != null)
                    resultList.add(line);
            }
            result = StringListTools.ListToString(resultList, "\n");
            context.write(NullWritable.get(), new Text(result));
        } catch (Exception e) {

        }
    }
}
