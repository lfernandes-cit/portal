var EcPage = new require('./pages/ecPage');

describe('Ec', function(){

    var pagina = new EcPage();

    it('Listar com sucesso', function(){
    	expect(pagina.entaoListaEc().count()).toBeGreaterThan(0);
    });

    

    

});