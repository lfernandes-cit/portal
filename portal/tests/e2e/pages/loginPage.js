var loginPage = function(){
    this.visita =  function(){
        browser.get('http://localhost:3000/login');  
    };

    this.dadoQueDigitoUsuario = function(login){
        element(by.model("usuario.login")).sendKeys(login)
    }

    this.dadoQueDigitoSenha = function(senha){
        element(by.model("usuario.senha")).sendKeys(senha)
    }

    this.dadoQueclicoSingIn = function(){
        element(by.id("signIn")).click();  
    };

    this.dadoQueclicoLogOut = function(){
        var botao = element(by.id("Logout"));
            botao.getText().then(function(text) {
            if(text){
                botao.click();
            }
        });
    };


    this.entaoObtemUsuarioLogado = function(){
        return element(by.binding("usuarioLogado.nome")).getText();
    };


    this.entaoObtemMenssagemErro = function(){
        return element(by.css(".alert-danger")).getText();
    };

    this.dadoQueLogoComUsuarioValido = function(login, senha){
        //if (element(by.binding("usuarioLogado.nome"))) {
            element(by.model("usuario.login")).sendKeys(login);
            element(by.model("usuario.senha")).sendKeys(senha);
            element(by.id("signIn")).click();
        //}
        
    };

}

module.exports = loginPage;