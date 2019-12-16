var fs = require('fs');
fs.readFile('fs_sample.txt', 'utf8', function(err, data){
  console.log(data)
});
