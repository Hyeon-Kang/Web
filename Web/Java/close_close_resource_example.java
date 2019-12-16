public class close_resources_example implements AutoCloseable {
  public static void main(String args[]){

    try {
      fis = neew FileInputStream("file.txt");
      ...
    } catch (IOException e) {
      ...
    } finally {
      if(fis != null) {
        try {
          fis.close(); // 리소스 닫는 메소드 호출!
        } catch (IOException e) {}
      } // finally - if end
    } // finally end

  } // main end
} // class end


// 위는 자바 6 이전 구형 코드


 자바 7 이후에 적용된 try-with-catch문을 이용하면 다음과 같이 편리해짐

 try(FileInputStream fis = new FileInputStream ("file.txt") ) {
   ...

   만약 예외 상황 발생 시 자동으로 해당 객체를 close 시켜준 후 catch 블록으로 넘어감

 } catch (IOException e) {
   ... 예외 대응 코드
 }

 만약 입출력 객체를 여러개 선언해야 한 다면

 try {
   FileInputStream fis1 = new FileInputStream ("file1.txt");
   FileInputStream fis2 = new FileInputStream ("file2.txt");

   fis1.read();
   fis2.read();
 }

 요렇게 개별로 선언해주어도 가능

 단! close 자동 적용은 AutoCloseable 인터페이스를 꼭 implements해야함!!
