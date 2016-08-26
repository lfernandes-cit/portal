angular.module('portal').controller("LoginController", function($scope, $rootScope, $http, $location, $cookies, IpFactory){

    $scope.logar = function(usuario){
        console.log(usuario);

        $http.post(IpFactory.host + "/portal/usuario", usuario).then(
        function(retorno){
            if(retorno.data && retorno.data.object.id){
                $cookies.putObject("usuarioLogado", retorno.data.object);
                $rootScope.usuarioLogado = $cookies.getObject("usuarioLogado");
                $location.path( "/ec");
            }
        },
        function(erro){
            console.log("Erro"+ erro);
        });
    }

});
