var LoginPage = new require('./pages/loginPage');

var pagina = new LoginPage();

module.exports = function () {

    this.Given(/Que acesso a pagina de login/, function (next) {
        pagina.visita();
        next();
    });


    this.Then(/Digito usuario "([^"]*)"$/, function (usuario, next) {
        pagina.dadoQueDigitoUsuario(usuario);
        next();
    });

    this.Then(/Digito senha "([^"]*)"$/, function (senha, next) {
        pagina.dadoQueDigitoSenha(senha);
        next();
    });

    this.Then(/Clico no login/, function (next) {
        return pagina.dadoQueClicoSingIn(function(){
            next();
        });
    });

    this.Then(/Usuario logado "([^"]*)"$/, function (usuario, next) {
        expect(pagina.entaoObtemUsuarioLogado()).toContain(usuario);  
        next();
       });


};


// describe('Login', function(){

//     var pagina = new LoginPage();

//     beforeEach(function(){
//         pagina.visita();
//         pagina.dadoQueclicoLogOut();
//     }); 


//     it('Login com sucesso', function(){
//         pagina.dadoQueDigitoUsuario("usuario");
//         pagina.dadoQueDigitoSenha("usuario");
//         pagina.dadoQueclicoSingIn();
//         expect(pagina.entaoObtemUsuarioLogado()).toContain('usuario'); 
//     });

//     it('Login com falha', function(){
//         pagina.dadoQueDigitoUsuario("naoexiste");
//         pagina.dadoQueDigitoSenha("naoexiste");
//         pagina.dadoQueclicoSingIn();
//         expect(pagina.entaoObtemMenssagemErro()).toContain('Usuario ou senha inválido.'); 
//     });


// });