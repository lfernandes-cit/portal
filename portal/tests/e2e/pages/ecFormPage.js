var ecFormPage = function(){
    

    this.dadoQueDigitoNome = function(nome){
        element(by.model("ec.nome")).sendKeys(nome);
    }

    this.dadoQueDigitoTelefone = function(telefone){
        element(by.model("ec.telefone")).sendKeys(telefone)
    }

    this.dadoQueDigitoEndereco = function(endereco){
        element(by.model("ec.endereco")).sendKeys(endereco)
    }

    this.dadoQueDigitoEndereco = function(numero){
    	element(by.model("ec.numero")).sendKeys(numero)
    }

    this.dadoQueDigitoCEP = function(cep){
    	element(by.model("ec.cep")).sendKeys(cep)
    }

    this.dadoQueDigitoCidade = function(cidade){
    	element(by.model("ec.cidade")).sendKeys(cidade)
    }

    this.dadoQueSelecionoPais = function(pais){
    	element(by.model("ec.pais")).sendKeys(pais)
    }

    this.dadoQueDigitoPOS = function(pos){
    	element(by.model("ec.pos")).sendKeys(pos)
    }
    
    this.dadoQueClicoSalvar = function(){
        element(by.id("salvar")).click();  
    };

}

module.exports = ecFormPage;