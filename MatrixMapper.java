
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class MatrixMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

    static int size = 10;

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            String x = tokenizer.nextToken();
            if (x.equals("a")) { // if entry is a matrix
                Text k = new Text(tokenizer.nextToken() + " 0");
                output.collect(k, value);
            } else if (x.equals("b")) { // if entry is a vector
                for (int i = 0; i < size; i++) {
                    Text k = new Text(i + " 0");
                    output.collect(k, value);
                }
            }
        }
    }
}
