var args = process.argv;

console.log(args);
console.log('A');
console.log('B');
if(args[2] === '1'){
  console.log('C1');
} else {
  console.log('C2');
}
console.log('D');

// 위 코드를 파라미터를 주고 실행 시키면
// 배열을 출력한다.
// 1. nodejs 경로
// 2. 실행한 js 스크립트 경로
// 3. 입력한 파라미터를 순차적으로 반환하는데 (입력 값이 여러개면 이후 배열에 할당)
// 입력한 argument를 받으려면 2번 배열칸을 써야 한다.
