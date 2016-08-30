var ecPage = function(){
    this.visita =  function(){
        browser.get('http://localhost:3000/ec');  
    };

    this.entaoListaEc = function() {
    	return element.all(by.repeater('ec in ecs | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao | filter:filtro'));

    };
}

module.exports = ecPage;