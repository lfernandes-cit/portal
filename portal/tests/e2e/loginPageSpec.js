var LoginPage = new require('./pages/loginPage');

describe('Login', function(){

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

    it('Login com falha', function(){
        pagina.dadoQueDigitoUsuario("naoexiste");
        pagina.dadoQueDigitoSenha("naoexiste");
        pagina.dadoQueclicoSingIn();
        expect(pagina.entaoObtemMenssagemErro()).toContain('Usuario ou senha inválido.'); 
    });

});