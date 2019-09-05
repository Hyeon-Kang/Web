package week2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO_Example_1 {

	 public static void main(String[] args) {
	        // InputStreamReader, OutputStreamWriter를 선언
	        InputStreamReader isr = null;
	        OutputStreamWriter osw = null;
	        try {
	            isr = new InputStreamReader(System.in); // 수신한 스트림 데이터를 받아올 때 사용하는 InputStreamReader
	            osw = new OutputStreamWriter(System.out); // 데이터를 전달할때 사용 하는 OutputStreamWriter
	        //System.in은 콘솔로부터 스트림을 받아오고, System.out은 콘솔로 전달받은 스트림을 출력해준다.

	            int i = 0;


	            while(true){
	            i=isr.read(); // InputStreamReader에서 한 바이트씩 읽어온다.
	                osw.write((char)i);// OutputStreamWriter에 읽은 문자 하나를 쓴다.
	                osw.flush();//버퍼를 비움과 동시에 출력한다.
	            }


	        } catch (IOException e) {

	            e.printStackTrace();

	        }finally{

	            // InputStreamReader/OutputStreamWriter 를 닫아준다.
	            if(isr != null) try{isr.close();}catch(IOException e){}
	            if(osw != null) try{osw.close();}catch(IOException e){}

	        }
	    } // end main

} // end class
