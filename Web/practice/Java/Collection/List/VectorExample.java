public class VectorExample {
    public static void main(String [] args) {
      List <Board> list = new Vector <Board> ();

      list.add(new Board("제목1", "내용1", "글쓴이1"));
      list.add(new Board("제목2", "내용2", "글쓴이2"));
      list.add(new Board("제목3", "내용3", "글쓴이3"));
      list.add(new Board("제목4", "내용4", "글쓴이4"));
      list.add(new Board("제목5", "내용5", "글쓴이5"));
      list.add(new Board("제목6", "내용6", "글쓴이6"));

      list.remove(2);
      list.remove(3);


      for(Board board : list) {
        System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
      }
    }
}



class Board {
  String subject;
  String content;
  String writer;

  public Board(String subject, String content, String writer) {
    this.subject = subject;
    this.content = content;
    this.writer = writer;
  }
}