public class close_resource_example implements AutoCloseable {
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
