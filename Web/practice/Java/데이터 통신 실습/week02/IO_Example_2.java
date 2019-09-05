package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IO_Example_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			isr = new InputStreamReader(System.in); // 수신한 스트림 데이터를 받아올 때 사용하는 InputStreamReader
            br = new BufferedReader(isr); //수신한 스트림 데이터를 버퍼에 저장
            osw = new OutputStreamWriter(System.out); // 데이터를 전달할때 사용 하는 OutputStreamWriter
            pw = new PrintWriter(osw); //전달할 데이터 스트림을 문자 스트림으로 바꿔서 전달
        //System.in은 콘솔로부터 스트림을 받아오고, System.out은 콘솔로 전달받은 스트림을 출력해준다.

            while(true) {
                pw.println(br.readLine()); //버퍼리더에 저장된 바이트 스트림을 읽어와서 PrintWriter를 통해 문자열로 출력
                pw.flush();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }finally{

            // InputStreamReader/OutputStreamWriter/BufferedReader 를 닫아준다.
            if(isr != null) try{isr.close();}catch(IOException e){}
            if(osw != null) try{osw.close();}catch(IOException e){}
            if(br != null) try{br.close();}catch(IOException e){}
        }


	}

}
