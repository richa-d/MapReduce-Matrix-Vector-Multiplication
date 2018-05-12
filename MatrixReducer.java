
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class MatrixReducer extends MapReduceBase implements Reducer<Text, Text, Text, IntWritable> {

    static int size = 10;

    @Override
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

        int[] a = new int[size];
        int[] b = new int[size];
        int sum = 0;
        while (values.hasNext()) {
            // splitting the value passed from mapper by spaces
            String[] x = values.next().toString().split(" ");
            
            if (x[0].equals("a")) { // if the entry is a matrix
                a[new Integer(x[2])] = new Integer(x[3]);
            } else if (x[0].equals("b")) { // if the entry is a vector
                b[new Integer(x[1])] = new Integer(x[3]);
            }
        }
        
        // compute product and sum
        for (int i = 0; i < size; i++) {
            sum += a[i] * b[i];
        }

        String line = key.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        output.collect(new Text(tokenizer.nextToken()), new IntWritable(sum));

    }
}
