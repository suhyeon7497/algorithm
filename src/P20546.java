import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int jSeed = money;
        int jStockCnt = 0;
        int sSeed = money;
        int sStockCnt = 0;

        int cnt = 0;
        int[] stockPrice = new int[14];
        for (int i = 0; i < 14; i++) {
            stockPrice[i] = Integer.parseInt(st.nextToken());
            if (jSeed / stockPrice[i] > 0) {
//                System.out.println(String.format("[%d j buy] price : %d, cnt : %d", i, stockPrice[i], jSeed / stockPrice[i]));
                jStockCnt += jSeed / stockPrice[i];
                jSeed -= stockPrice[i] * (jSeed / stockPrice[i]);
            }
            if (i > 0) {
                if (stockPrice[i - 1] < stockPrice[i]) {
                    if (cnt >= 0) cnt++;
                    else cnt = 1;
                }
                else if (stockPrice[i - 1] > stockPrice[i]) {
                    if (cnt <= 0) cnt--;
                    else cnt = -1;
                }
                else if (stockPrice[i - 1] == stockPrice[i]) {
                    cnt = 0;
                }

                if (cnt <= -3) {
                    if (sSeed / stockPrice[i] > 0) {
//                        System.out.println(String.format("[%d s buy] price : %d, cnt : %d", i, stockPrice[i], sSeed / stockPrice[i]));
                        sStockCnt += sSeed / stockPrice[i];
                        sSeed -= stockPrice[i] * (sSeed / stockPrice[i]);
                    }
                }
                else if (cnt >= 3) {
//                    System.out.println(String.format("[%d s sell] price : %d, cnt : %d", i, stockPrice[i], sStockCnt));
                    sSeed += stockPrice[i] * sStockCnt;
                    sStockCnt = 0;
                }
            }
        }

        int jFinal = jSeed + jStockCnt * stockPrice[13];
        int sFinal = sSeed + sStockCnt * stockPrice[13];
//        System.out.println(jSeed + " " + jStockCnt + " " + jFinal);
//        System.out.println(sSeed + " " + sStockCnt + " " + sFinal);
        if (jFinal > sFinal) System.out.println("BNP");
        else if (jFinal < sFinal) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
