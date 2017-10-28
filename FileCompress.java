import java.io.*;
import java.util.Arrays;

public class FileCompress {
    private InputStream inputStream;
    private BitsOutputstream outputStream;
    FileCompress(InputStream in,OutputStream out) throws IOException{
         this.inputStream=new BufferedInputStream(in);
        this.outputStream=new BitsOutputstream(new BufferedOutputStream(out));
        compress(this.inputStream,this.outputStream);
        inputStream.close();
        outputStream.close();
    }
    public void compress(InputStream inputStream,BitsOutputstream outputStream)throws IOException{
        int[] frequencytable=new int[257];
        Arrays.fill(frequencytable,1);
        Frequencylist frequencylist=new Frequencylist(frequencytable);
        CompressEncoder encoder=new CompressEncoder(outputStream);
       encoder.setCodetree(frequencylist.buildcodetree());
       int i=0;
       while (true){
            int symbol=inputStream.read();
            if (symbol==-1){
                break;
            }
            encoder.write(symbol);
            frequencylist.increment(symbol);
            i++;
            if (i<262144&&isPowerOf2(i)||i%262144==0){

            encoder.setCodetree( frequencylist.buildcodetree());
            }
            if (i%262144==0) {
                frequencylist = new Frequencylist(frequencytable);
            }
       }
       encoder.write(256);

    }
    private static boolean isPowerOf2(int x) {
        return x > 0 && (x & -x) == x;
    }
}
