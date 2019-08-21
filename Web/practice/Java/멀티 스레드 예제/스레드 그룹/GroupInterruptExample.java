package thread_group;

public class GroupInterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		// main 그룹 휘하에 myGroup 생성

		WorkThread worker1 = new WorkThread(myGroup, "worker1");
		WorkThread worker2 = new WorkThread(myGroup, "worker2");
		WorkThread worker3 = new WorkThread(myGroup, "worker3");

		worker1.start();
		worker2.start();
		worker3.start();

		System.out.println("[ main 스레드 그룹의 list() 메소드 출력 결과.]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

		mainGroup.list(); // 메인 그룹의 현재 목록 출력


		try {
			Thread.sleep(3000); // 인터럽트 유발
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]");
		myGroup.interrupt();



	}

}



//[ main 스레드 그룹의 list() 메소드 출력 결과.]
//java.lang.ThreadGroup[name=main,maxpri=10]
//    Thread[main,5,main]
//    java.lang.ThreadGroup[name=myGroup,maxpri=10]
//        Thread[worker1,5,myGroup]
//        Thread[worker2,5,myGroup]
//        Thread[worker3,5,myGroup]
//[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]
//worker1interrupted
//worker3interrupted
//스레드 종료.
//worker2interrupted
//스레드 종료.
//스레드 종료.
