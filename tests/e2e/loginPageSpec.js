var LoginPage = new require('./pages/loginPage');

describe('Login de usuario', function(){

    var pagina = new LoginPage();

    beforeEach(function(){
        pagina.visita();
    }); 

    it('Login com sucesso', function(){
        pagina.dadoQueDigitoUsuario("usuario");
        pagina.dadoQueDigitoSenha("usuario");
        pagina.dadoQueclicoSingIn();
        expect(pagina.entaoObtemUsuarioLogado()).toContain('usuario'); 
    });

});