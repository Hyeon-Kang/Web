// 멀티쓰레드에서 안전한(Thread-safe) 싱글톤 클래스, 인스턴스 만드는 방법

// 1. Thread safe Lazy initialization (게으른 초기화)
// 이와 같은 방법은 synchronized 특성상 큰 성능저하로 인하여 권장하지 않는 방법
public class ThreadSafeLazyInitialization{

    private static ThreadSafeLazyInitialization instance;
    // static 싱글톤 객체 하나 생성 (이것을 우려먹을 것!)

    private ThreadSafeLazyInitialization(){} //생성자 (외부에서 추가 생성 차단)

    public static synchronized ThreadSafeLazyInitialization getInstance(){
      //synchronized 키워드를 사용하여 동기화처리 (thread-safe 처리 적용)

        if(instance == null){
            instance = new ThreadSafeLazyInitialization();
        }
        return instance;
    }

}

// 2. Thread safe lazy initialization + Double-checked locking
//  동기화 전 2번에 걸친 인스턴스 존재 여부 검사로 최초 이후의 synchronized의 동기화 과정을
//  회피함으로써 성능저하를 완화하고자 하는 방법
//  그러나 이 역시 불완전한 방법이다.
public class ThreadSafeLazyInitialization {

    private volatile static ThreadSafeLazyInitialization instance;

    private ThreadSafeLazyInitialization(){}

    public static ThreadSafeLazyInitialization getInstance(){

        if(instance == null){
            synchronized (ThreadSafeLazyInitialization.class) {
                if(instance == null)
                    instance = new ThreadSafeLazyInitialization();
            }

        }
        return instance;

}

// 3. Initialization on demand holder idiom (holder에 의한 초기화)
// 사람이 직접 동기화 문제를 해결하려 할 경우 구조도 복잡해질 뿐 더러 인지못하는 오류가
// 발생하는 경우가 잦다.
// 다음 방법은 JVM의 클래스 초기화 과정에서 보장되는 atomic한 특성을 이용하여
// 싱글턴의 초기화 문제에 대한 책임을 JVM에 떠넘기는 방법

// 클래스 안에 클래스(holder)를 두어 JVM의 Class loader 매커니즘과
// Class가 로드되는 시점을 이용한 방법

public class Something {
    private Something() {
    }

    private static class LazyHolder {
        public static final Something INSTANCE = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }
}

// Something 클래스를 호출하는 과정에서 내부의 LazyHolder가 새로 호출되며
// 이 과정은 JVM이 atomic 하게 처리하므로 싱글톤의 초기화를 JVM이 자동으로 해준다.
// 최종적으로 호출되는 Something INSTANCE는 static 이므로 최초에 한 번 선언되며
// final을 통해 다시 값이 할당되지 않는다.


1,2,3번 모두 처음부터 싱글톤 변수에 초기화를 시키지 않고 있습니다.
필요로 할 때(게으르게) getInstance() 메서드를 통해 인스턴스를 생성하죠.

1번은 synchronized 를 이용해서 멀티 쓰레드가 getInstance() 메서드를 동시에 접근해서 2개 이상 싱글톤 객체가 생기는 것을 방지하는 것입니다.

2번은 getInstance() 메서드 전체를 synchronized로 잡는 것은 불필요하게 lock을 잡는 것을 방지하는 방식으로 개선한 것입니다.

3번은 synchronized 키워드로 개발자가 직접 싱글톤 변수의 중복 생성을 방지하는 것이 아니라 JVM에 위임하는 방법입니다.
- static 키워드는 클래스가 로딩될 때 한번 만 실행된다는 것을 JVM이 보장해줍니다. 따라서 getInstance() 메서드가 최초로 호출될 때 JVM이 클래스를 로드하며 INSTANCE를 생성해줍니다.
- final 키워드를 통해서 초기화된 이후 다시 값이 할당되는 것을 방지해서 싱글톤임을 보장합니다.



// 출처: https://jeong-pro.tistory.com/86 [기본기를 쌓는 정아마추어 코딩블로그]
