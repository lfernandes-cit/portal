var express = require('express');
var path = require('path');
var app = express();

app.use(express.static(__dirname+'/public'));


// habilitando HTML5MODE
app.all('/*', function(req, res) {
    res.sendFile(path.resolve('public/index.html'));
});

app.listen(3000);
console.log("App listening on port 3000");
