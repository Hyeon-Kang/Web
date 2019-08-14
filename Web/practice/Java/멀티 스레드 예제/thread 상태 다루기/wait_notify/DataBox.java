package wait_notify;

public class DataBox {
	private String data;

	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait(); // 데이터가 없으면 소비자 스레드 작업 대기
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String returnValue = data; // 있던 데이터 반출 (복사)
		System.out.println("ConsumerThread가 읽은 데이터 : " + returnValue);
		data = null; // 새로운 데이터를 받기 위해 null로 초기화
		notify(); // wait된 생산자 스레드를 실행 대기로 전환
		return returnValue;
	}

	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait(); // 소비자 스레드가 데이터를 읽기 전 까지 생산자 스레드를 wait
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("ProducerThread가 생성한 데이터 : " + data);
		notify(); // 데이터 저장 후 wait된 소비자 스레드 작업 재개
	}



}
