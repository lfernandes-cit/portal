var EcPage = new require('./pages/ecPage');
var EcFormPage = new require('./pages/ecFormPage');
var LoginPage = new require('./pages/loginPage');

describe('EcForm', function(){

    var login = new LoginPage();
    var ec = new EcPage();
    var ecForm = new EcFormPage();

    beforeEach(function(){
    	login.visita();
        login.dadoQueLogoComUsuarioValido("usuario2", "usuario2");
    }); 


    it('Salvar um Ec com sucesso', function(){
        ec.dadoQueClicoAdicionarEc();
        ecForm.dadoQueDigitoNome ("Luiz Teste");

        ecForm.dadoQueDigitoTelefone("19988733400");

        ecForm.dadoQueDigitoEndereco("Endereço Teste");

        ecForm.dadoQueDigitoCEP("15040540");

        ecForm.dadoQueDigitoCidade("Paulínia");

        //ecForm.dadoQueSelecionoPais();

        ecForm.dadoQueDigitoPOS("ABC123");
        
        
        ecForm.dadoQueClicoSalvar();
        
        expect(ec.entaoMostraMensagemSucesso()).toContain('sucesso'); 
    });


});