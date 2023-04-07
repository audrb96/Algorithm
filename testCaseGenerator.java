import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class testCaseGenerator {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        OutputStream output = new FileOutputStream("C:/Users/박명규/Desktop/알고리즘 자료/testCase_sample.txt");
        for(int tc=1; tc<= 1;tc++) {
            StringBuilder sb = new StringBuilder();
            int N = 1+random.nextInt(10);
//            int N = ;
            sb.append(N).append("\n");
            for(int i =0;i<N;i++) {
                for(int j =0; j<N;j++) {
                    if(random.nextInt(100) > 25) sb.append(0).append(" ");
                    else sb.append(1+random.nextInt(7)).append(" ");
                }
                sb.append("\n");
            }
            int S = random.nextInt(N);
            int X = 1+ random.nextInt(N);
            int Y = 1 + random.nextInt(N);
            sb.append(S).append(" ").append(X).append(" ").append(Y).append("\n");
            byte[] by = sb.toString().getBytes();
            output.write(by);
        }
    }
}
