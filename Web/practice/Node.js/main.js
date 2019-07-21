var http = require('http');
var fs = require('fs');
var app = http.createServer(function(request,response){
  var url = request.url;
  if (request.url == '/'){
    url = '/index.html';
  }
  if(request.url == '/faiblcon.ico'){
    return response.writeHead(404);
  }
  response.writeHead(200);
  response.end(fs.readFileSync(__dirname + url));
});
app.listen(3000);

// 원본 : 생활코딩/module/3549/21032
