var ecPage = function(){
    this.visita =  function(){
        browser.get('http://localhost:3000/ec');  
    };

    this.entaoListaEc = function() {
    	return element.all(by.repeater('ec in ecs'));
    };

    this.dadoQueClicoAdicionarEc = function(){
        element(by.id("adicionar")).click();  
    };

    this.entaoMostraMensagemSucesso = function(){
    	return element(by.css(".alert-success")).getText();  
    };
}

module.exports = ecPage;