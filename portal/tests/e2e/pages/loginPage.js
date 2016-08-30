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

    this.entaoObtemUsuarioLogado = function(){
        return element(by.model("usuarioLogado.nome")).getText();
    };

}

module.exports = loginPage;