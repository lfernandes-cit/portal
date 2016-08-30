var EcPage = new require('./pages/ecPage');
var LoginPage = new require('./pages/loginPage');

describe('Ec', function(){

    var pagina = new EcPage();
    var login = new LoginPage();

    beforeEach(function(){
    	login.visita();
        login.dadoQueLogoComUsuarioValido("usuario2", "usuario2");
    }); 

    it('Listar com sucesso', function(){
    	expect(pagina.entaoListaEc().count()).toBeGreaterThan(0);
    });

    

    

});