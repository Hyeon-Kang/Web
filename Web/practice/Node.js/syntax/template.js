var name = 'hyhy';
var letter = 'Dear ' +name+ ' Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';
// name 뒤에 어떻게 개행을 할까?
//console.log(letter);
var letter1  = 'Dear' +name+ '\n\n Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';
//console.log(letter1);

// template literal

var letter2 = `Dear ${name}

Lorem ipsum dolor sit amet, consectetur adipisicing elit,

sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.

Ut enim ad minim veniam, quis nostrud exercitation ullamco

laboris nisi ut aliquip ex ea commodo consequat. Duis aute

irure dolor in reprehenderit in voluptate velit esse cillum

 dolore eu fugiat nulla pariatur. Excepteur sint occaecat

  cupidatat non proident, sunt in culpa qui officia deserunt

  mollit anim id est laborum. ${name}`;

  // template literal을 사용하면 이처럼 특수 기호가 없이 개행이 된다.
